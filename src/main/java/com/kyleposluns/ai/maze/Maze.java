package com.kyleposluns.ai.maze;

import com.kyleposluns.ai.maze.solver.MazeSolver;
import com.kyleposluns.ai.util.Location;

public interface Maze<T extends MazeCell> {

	Location getStart();

	Location getFinish();

	CellAccessor<T> getAccessor();

	MazeSolver<T> getSolver();

}
