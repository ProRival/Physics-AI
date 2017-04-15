package com.kyleposluns.ai.maze.solver;

import java.util.Map;

public class Node<T> {

	private final T obj;

	private final Map<T, Float> heuristic;

	private float gCost, hCost, fCost;

	public Node(T obj, Map<T, Float> heuristic) {
		this.obj = obj;
		this.heuristic = heuristic;
		this.gCost = Float.MAX_VALUE;
	}

	public T getObject() {
		return obj;
	}

	public float getGCost() {
		return this.gCost;
	}

	public void setGCost(float gCost) {
		this.gCost = gCost;
	}

	public void calcFCost(T destination) {
		this.hCost = heuristic.get(destination);
		this.fCost = this.hCost + this.gCost;
	}

	public float getHCost() {
		return this.hCost;
	}

	public float getFCost() {
		return this.fCost;
	}

}
