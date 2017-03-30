package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;

public abstract class CartesianMazeModel implements MazeModel2D, Maze {

	protected int width, height;

	protected boolean isGenerated;

	protected MazeCell[][] maze;

	public CartesianMazeModel(int width, int height) {
		this.width = width;
		this.height = height;
		this.isGenerated = false;
		this.maze = new MazeCell[width][height];
		this.init();
	}

	public abstract MazeCell getCell(int x, int y);

}
