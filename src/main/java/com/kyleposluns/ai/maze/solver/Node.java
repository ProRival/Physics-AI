package com.kyleposluns.ai.maze.solver;

import java.util.Map;

public interface Node<T> {

	Map<T, Double> getLinks();

	T getWrappedObject();


}
