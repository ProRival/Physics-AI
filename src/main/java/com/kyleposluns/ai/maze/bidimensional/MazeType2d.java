package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.MazeModel;
import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.RectangularMazeModel;
import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.square.SquareMazeModel;

public enum MazeType2D implements MazeType {

	RECTANGULAR(RectangularMazeModel.class), SQUARE(SquareMazeModel.class);

	private Class<? extends MazeModel> clazz;

	MazeType2D(Class<? extends MazeModel> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Class<? extends MazeModel> getModelClass() {
		return this.clazz;
	}
}
