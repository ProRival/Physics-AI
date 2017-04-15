package com.kyleposluns.ai.maze.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PathFinder<T> {

	private final NodeGraph<T> graph;

	public PathFinder(NodeGraph<T> graph) {
		this.graph = graph;
	}

	public NodeGraph<T> getGraph() {
		return this.graph;
	}

	private List<T> constructPath(Map<T, T> path, T destination) {
		assert path != null;
		assert destination != null;

		final List<T> pathList = new ArrayList<>();
		pathList.add(destination);
		while (path.containsKey(destination)) {
			destination = path.get(destination);
			pathList.add(destination);
		}
		Collections.reverse(pathList);
		return pathList;
	}

	public List<T> getPath(T start, T end) {
		final Queue<Node<T>> open = new PriorityQueue<>((o1, o2) -> Float.compare(o1.getFCost(), o2.getFCost()));

		Node<T> origin = graph.getNode(start);
		origin.setGCost(0F);
		origin.calcFCost(end);

		open.add(origin);

		final Map<T, T> path = new HashMap<>();
		final Set<Node<T>> closed = new HashSet<>();

		while(!(open.isEmpty())) {
			final Node<T> node = open.poll();

			if (node.getObject().equals(end)) {
				return constructPath(path, end);
			}

			closed.add(node);

			for (Map.Entry<Node<T>, Float> entry : graph.getConnections(node.getObject()).entrySet()) {

				Node<T> neighbor = entry.getKey();
				if (closed.contains(neighbor)) continue;

				float dist = entry.getValue();
				float tentativeG = dist + node.getGCost();

				if (tentativeG < neighbor.getGCost()) {
					neighbor.setGCost(tentativeG);
					neighbor.calcFCost(end);

					path.put(neighbor.getObject(), node.getObject());

					if (!open.contains(neighbor)) {
						open.add(neighbor);
					}
				}
			}

		}
		return new ArrayList<>();
	}

}
