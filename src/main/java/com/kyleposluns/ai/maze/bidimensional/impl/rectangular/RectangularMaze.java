package com.kyleposluns.ai.maze.bidimensional.impl.rectangular;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeModel;
public class RectangularMaze implements Maze{

	private final RectangularMazeModel model;

	private final RectangularMazeRenderer renderer;

	public RectangularMaze(RectangularMazeModel model, RectangularMazeRenderer renderer) {
		this.model = model;
		this.renderer = renderer;
	}

	@Override
	public MazeModel getModel() {
		return model;
	}

}
