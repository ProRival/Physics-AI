package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.MazeType2d;

public class SquareMaze extends RectangularMaze {

	public SquareMaze(int n) {
		super(n, n);
	}

	@Override
	public MazeType getType() {
		return MazeType2d.SQUARE;
	}
}
