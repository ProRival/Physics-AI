package com.kyleposluns.ai.maze;

/**
 * Created by Kyle on 3/29/17.
 */
public interface Maze {

	default void init() {

	}

	MazeType getType();
}
