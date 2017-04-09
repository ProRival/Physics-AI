package com.kyleposluns.ai.maze.generator;

import com.kyleposluns.ai.maze.Maze;

public interface MazeGenerator<T extends Maze> {

	T generate();

	boolean isGenerated();

}
