package com.kyleposluns.ai.maze.tridimensional;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.MazePlan;

public interface MazePlan3d extends MazePlan {

	MazeCell getCell(int x, int y, int z);

}
