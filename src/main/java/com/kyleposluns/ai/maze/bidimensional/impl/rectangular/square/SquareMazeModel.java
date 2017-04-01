package com.kyleposluns.ai.maze.bidimensional.impl.rectangular.square;

import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;
import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.RectangularMazeModel;

public class SquareMazeModel extends RectangularMazeModel {

	public SquareMazeModel(int n) {
		super(n, n);
	}

	@Override
	public MazeType getType() {
		return MazeType2D.SQUARE;
	}
}
