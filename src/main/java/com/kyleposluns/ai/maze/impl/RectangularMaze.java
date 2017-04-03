package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.Maze;

public class RectangularMaze implements Maze {

	private RectangularMazeGenerator generator;

	public RectangularMaze(RectangularMazeGenerator generator) {
		this.generator = generator;
	}

	public RectangularCell getCell(int x, int y) {
		return generator.maze[x][y];
	}

	public int getRows() {
		return generator.width;
	}

	public int getColumns() {
		return generator.height;
	}

}
