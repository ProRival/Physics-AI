package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.MazePlan;

/**
 * Created by Kyle on 3/28/17.
 */
public interface MazePlan2d extends MazePlan {

	MazeCell getCell(int x, int y);

}
