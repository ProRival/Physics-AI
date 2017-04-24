package com.kyleposluns.ai.maze.solver;

import java.util.Map;

public interface Node<T> {

	T getWrappedObject();

	Map<T, Double> getLinks();
}
