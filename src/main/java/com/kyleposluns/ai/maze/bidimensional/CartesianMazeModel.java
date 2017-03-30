package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.util.Location;

public abstract class CartesianMazeModel implements MazeModel2D, Maze {

	protected int width, height;

	protected boolean isGenerated;

	protected MazeCell[][] maze;

	protected Location start, goal;

	public CartesianMazeModel(Location start, Location goal, int width, int height) {
		this.start = start;
		this.goal = goal;
		this.width = width;
		this.height = height;
		this.isGenerated = false;
		this.maze = new MazeCell[width][height];
		this.init();
	}

	public CartesianMazeModel(int width, int height) {
		this(new Location(), new Location(width - 1, height - 1), width, height);
	}

	public abstract MazeCell getCell(int x, int y);

}
