package com.kyleposluns.ai.maze;

import com.kyleposluns.ai.maze.render.MazeRenderer;

/**
 * Created by Kyle on 3/29/17.
 */
public interface Maze {

	default void init() {

	}

	MazeRenderer getRenderer();

	MazeModel getModel();

	MazeType getType();

	default boolean verify() {
		return this.getType().getModelClass().isAssignableFrom(this.getModel().getType().getClass()) && this.getType().getModelClass().isAssignableFrom(this.getRenderer().getType().getModelClass());
	}
}
