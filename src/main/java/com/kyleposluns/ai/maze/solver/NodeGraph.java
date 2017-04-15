package com.kyleposluns.ai.maze.solver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NodeGraph<T> implements Iterable<T> {

	private final Map<T, Map<Node<T>, Float>> graph;

	private final Map<T, Node<T>> nodes;

	private final Map<T, Map<T, Float>> heuristicMap;

	public NodeGraph(Map<T, Map<T, Float>> heuristicMap) {
		if (heuristicMap == null) throw new IllegalArgumentException("The heuristic map cannot be null!");
		this.heuristicMap = heuristicMap;
		this.nodes = new HashMap<>();
		this.graph = new HashMap<>();
	}

	public void addNode(T obj) {
		if (obj == null) throw new IllegalArgumentException("The node cannot be null!");

		graph.put(obj, new HashMap<>());
		nodes.put(obj, new Node<>(obj, heuristicMap.get(obj)));
	}

	public void link(T first, T second, float length) {
		if (first == null || second == null) throw new NullPointerException("Nodes cannot be null!");

		graph.get(first).put(nodes.get(second), length);
		graph.get(second).put(nodes.get(first), length);
	}

	public Map<Node<T>, Float> getConnections(T node) {
		return Collections.unmodifiableMap(graph.get(node));
	}


	public Node<T> getNode(T node) {
		return nodes.get(node);
	}

	@Override
	public Iterator<T> iterator() {
		return graph.keySet().iterator();
	}

}
