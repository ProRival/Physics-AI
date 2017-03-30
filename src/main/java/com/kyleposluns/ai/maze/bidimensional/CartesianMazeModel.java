package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.MazeCell;

public interface CartesianMazeModel extends MazeModel2D {

	MazeCell getCell(int x, int y);

}
