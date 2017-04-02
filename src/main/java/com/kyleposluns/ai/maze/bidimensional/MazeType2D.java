package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.RectangularMaze;

public enum MazeType2D implements MazeType {

	RECTANGULAR(RectangularMaze.class);

	private Class<? extends Maze> clazz;

	MazeType2D(Class<? extends Maze> clazz) {
		this.clazz = clazz;
	}
	@Override
	public Class<? extends Maze> getMazeClass() {
		return this.clazz;
	}
}
