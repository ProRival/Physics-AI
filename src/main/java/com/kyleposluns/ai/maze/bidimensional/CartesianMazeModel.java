package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.bidimensional.impl.CartesianCell;
import java.util.Random;

public abstract class CartesianMazeModel implements MazeModel2D {

	protected static final Random RANDOM = new Random();

	protected int width, height;

	protected boolean isGenerated;

	protected CartesianCell[][] maze;

	public CartesianMazeModel(int width, int height) {
		this.width = width;
		this.height = height;
		this.isGenerated = false;
		this.maze = new CartesianCell[width][height];
	}

	public int getRows() {
		return this.width;
	}

	public int getColumns() {
		return this.height;
	}

	public abstract CartesianCell getCell(int x, int y);

}
