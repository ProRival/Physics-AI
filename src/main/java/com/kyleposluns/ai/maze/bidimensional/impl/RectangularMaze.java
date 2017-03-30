package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;

public class RectangularMaze implements Maze, CartesianMazeModel {

	private boolean isGenerated;

	private int width, height;

	public RectangularMaze(int width, int height) {
		this.width = width;
		this.height = height;
		this.isGenerated = false;
	}

	@Override
	public void generate() {
		if (isGenerated) return;
	}



	@Override
	public MazeType getType() {
		return MazeType2D.RECTANGULAR;
	}

	@Override
	public MazeCell getCell(int x, int y) {
		return null;
	}
}
