package com.kyleposluns.ai.maze.solver;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.impl.RectangularCell;
import com.kyleposluns.ai.util.Direction;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStarSolver implements MazeSolver<RectangularCell> {

	private final Maze<RectangularCell> maze;

	public AStarSolver(Maze<RectangularCell> maze) {
		this.maze = maze;
	}

	@Override
	public List<RectangularCell> solve(Location source, Location destination) {

		Map<RectangularCell, MazeNode> nodeGraph = new HashMap<>();

		final Map<RectangularCell, RectangularCell> path = new HashMap<>();
		final Set<MazeNode> closed = new HashSet<>();

		Map<MazeNode, Double> gScore = new HashMap<>();
		Map<MazeNode, Double> fScore = new HashMap<>();

		final Queue<MazeNode> open = new PriorityQueue<>(11, Comparator.comparingDouble(fScore::get));

		for (RectangularCell cell : maze) {
			Map<RectangularCell, Double> links = new HashMap<>();
			for (Direction dir : Direction.values()) {
				if (cell.hasWall(dir)) continue;
				RectangularCell relative = cell.getRelative(dir);
				if (relative == null) continue;
				links.put(relative, cell.getLocation().distance(destination));
			}
			MazeNode node = new MazeNode(cell, links);
			nodeGraph.put(cell, node);
			gScore.put(node, Double.POSITIVE_INFINITY);
			fScore.put(node, Double.POSITIVE_INFINITY);
		}

		MazeNode start = nodeGraph.get(maze.getAccessor().access(source));
		gScore.put(start, 0D);
		fScore.put(start, source.distance(destination));

		open.add(start);

		while (!(open.isEmpty())) {
			MazeNode current = open.poll();
			if (current.getWrappedObject().getLocation().equals(destination)) {
				return path(path, maze.getAccessor().access(destination));
			}

			open.remove(current);
			closed.add(current);

			for (Map.Entry<RectangularCell, Double> neighbor : current.getLinks().entrySet()) {
				MazeNode node = nodeGraph.get(neighbor.getKey());
				if (closed.contains(node)) continue;

				double tentativeG = gScore.get(current) + current.getWrappedObject().getLocation().distance(neighbor.getKey().getLocation());

				if (!(open.contains(node))) {
					open.add(node);
				} else if (tentativeG >= gScore.get(node)) continue;

				path.put(neighbor.getKey(), current.getWrappedObject());
				gScore.put(node, tentativeG);
				fScore.put(node, gScore.get(node) + neighbor.getValue());

			}

		}
		return new ArrayList<>();
	}

	private List<RectangularCell> path(Map<RectangularCell, RectangularCell> path, RectangularCell destination) {
		assert path != null;
		assert destination != null;

		final List<RectangularCell> pathList = new ArrayList<>();
		pathList.add(destination);
		while (path.containsKey(destination)) {
			destination = path.get(destination);
			pathList.add(destination);
		}
		Collections.reverse(pathList);
		return Collections.unmodifiableList(pathList);
	}


	private class MazeNode implements Node<RectangularCell> {

		private final RectangularCell cell;

		private Map<RectangularCell, Double> links;

		public MazeNode(RectangularCell cell, Map<RectangularCell, Double> links) {
			this.cell = cell;
			this.links = links;
		}

		@Override
		public RectangularCell getWrappedObject() {
			return this.cell;
		}

		@Override
		public Map<RectangularCell, Double> getLinks() {
			return Collections.unmodifiableMap(links);
		}
	}
}
