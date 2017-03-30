package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.MazeModel;
import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.impl.RectangularMaze;
import com.kyleposluns.ai.maze.bidimensional.impl.SquareMaze;

public enum MazeType2D implements MazeType {

	RECTANGULAR(RectangularMaze.class), SQUARE(SquareMaze.class);

	private Class<? extends MazeModel> clazz;

	MazeType2D(Class<? extends MazeModel> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Class<? extends MazeModel> getPlanClass() {
		return this.clazz;
	}
}
