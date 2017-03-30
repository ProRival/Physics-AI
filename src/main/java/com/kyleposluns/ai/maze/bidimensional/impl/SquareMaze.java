package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;

public class SquareMaze extends RectangularMaze {

	public SquareMaze(int n) {
		super(n, n);
	}

	@Override
	public MazeType getType() {
		return MazeType2D.SQUARE;
	}
}
