package com.kyleposluns.ai.maze.solver;

import com.kyleposluns.ai.maze.MazeCell;

public interface MazeSolver<T extends MazeCell> {

	PathFinder<T> getPathFinder();

}
