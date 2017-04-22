package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.CellAccessor;
import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.solver.Node;
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

public class RectangularMaze implements Maze<RectangularCell> {

	private final int rows, columns;

	private Location start, finish;

	private final CellAccessor<RectangularCell> accessor;

	private final Map<MazeNode, Double> graph;

	private Map<RectangularCell, MazeNode> cellNodeMap;


	public RectangularMaze(Location start, Location finish, int rows, int columns, CellAccessor<RectangularCell> accessor) {
		this.start = start;
		this.finish = finish;
		this.rows = rows;
		this.columns = columns;
		this.accessor = accessor;
		this.cellNodeMap = new HashMap<>();
		this.graph = this.initGraph();
	}



	private Map<MazeNode, Double> initGraph() {
		Map<MazeNode, Double> nodes = new HashMap<>();
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				RectangularCell cell = getAccessor().access(x, y);
				Map<RectangularCell, Double> neighbors = new HashMap<>();
				for (Direction dir : Direction.values()) {
					if (!cell.hasWall(dir)) {
						RectangularCell neighbor = cell.getRelative(dir);
						neighbors.put(neighbor, cell.getLocation().distanceSquared(neighbor.getLocation()));
					}
				}
				MazeNode node = new MazeNode(cell, neighbors);
				nodes.put(node, cell.getLocation().distanceSquared(finish));
				this.cellNodeMap.put(cell, node);
			}
		}
		return Collections.unmodifiableMap(nodes);
	}

	public int getRows() {
		return this.rows;
	}

	public int getColumns() {
		return this.columns;
	}

	@Override
	public CellAccessor<RectangularCell> getAccessor() {
		return this.accessor;
	}

	@Override
	public Location getStart() {
		return this.start;
	}

	@Override
	public Location getFinish() {
		return this.finish;
	}


	@Override
	public List<RectangularCell> solve(Location origin, Location destination) {
		if ((!(origin.equals(start)) || !(destination.equals(finish)))) {
			throw new IllegalArgumentException();
		}
		final Queue<MazeNode> open = new PriorityQueue<>(11, Comparator.comparingDouble(graph::get));

		Map<MazeNode, Double> gScore = new HashMap<>();

		MazeNode source = cellNodeMap.get(getAccessor().access(origin));
		gScore.put(source, 0D);
		open.add(source);

		final Map<RectangularCell, RectangularCell> path = new HashMap<>();
		final Set<MazeNode> closed = new HashSet<>();

		while (!(open.isEmpty())) {

			final MazeNode node = open.poll();

			if (node.cell.getLocation().equals(origin)) {
				return path(path, getAccessor().access(destination));
			}

			closed.add(node);

			for (Map.Entry<RectangularCell, Double> neighbor : node.getLinks().entrySet()) {
				MazeNode neighborNode = cellNodeMap.get(neighbor.getKey());

				if (closed.contains(neighborNode)) {
					continue;
				}

				double distance = neighbor.getValue();
				double tentativeG = distance + gScore.get(node);

				gScore.putIfAbsent(neighborNode, Double.MAX_VALUE);

				if (tentativeG < (gScore.get(neighborNode))) {
					gScore.put(neighborNode, tentativeG);

					path.put(neighborNode.cell, node.cell);
					if (!(open.contains(neighborNode))) {
						open.add(neighborNode);
					}
				}
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
		return pathList;
	}


	protected class MazeNode implements Node {

		final RectangularCell cell;

		private Map<RectangularCell, Double> links;

		public MazeNode(RectangularCell cell, Map<RectangularCell, Double> links) {
			this.cell = cell;
			this.links = links;
		}

		@Override
		public Map<RectangularCell, Double> getLinks() {
			return Collections.unmodifiableMap(links);
		}


	}


}
