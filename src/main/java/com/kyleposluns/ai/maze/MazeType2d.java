package com.kyleposluns.ai.maze;

import com.kyleposluns.ai.maze.bidimensional.RectangularMaze;
import com.kyleposluns.ai.maze.bidimensional.SquareMaze;

public enum MazeType2d implements MazeType {

	RECTANGULAR(RectangularMaze.class), SQUARE(SquareMaze.class);

	private Class<? extends MazePlan> clazz;

	MazeType2d(Class<? extends MazePlan> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Class<? extends MazePlan> getPlanClass() {
		return this.clazz;
	}
}
