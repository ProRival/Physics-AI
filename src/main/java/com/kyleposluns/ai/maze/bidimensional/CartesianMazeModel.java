package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.bidimensional.impl.CartesianCell;
import com.kyleposluns.ai.util.Location;

public abstract class CartesianMazeModel implements MazeModel2D {

	protected int width, height;

	protected boolean isGenerated;

	protected CartesianCell[][] maze;

	protected Location start, goal;

	public CartesianMazeModel(Location start, Location goal, int width, int height) {
		this.start = start;
		this.goal = goal;
		this.width = width;
		this.height = height;
		this.isGenerated = false;
		this.maze = new CartesianCell[width][height];
	}

	public CartesianMazeModel(int width, int height) {
		this(new Location(), new Location(width - 1, height - 1), width, height);
	}

	public int getRows() {
		return this.width;
	}

	public int getColumns() {
		return this.height;
	}

	public abstract CartesianCell getCell(int x, int y);

}
