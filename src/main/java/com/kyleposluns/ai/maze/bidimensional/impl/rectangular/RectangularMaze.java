package com.kyleposluns.ai.maze.bidimensional.impl.rectangular;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeModel;
import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;
import com.kyleposluns.ai.maze.render.MazeRenderer;

public class RectangularMaze implements Maze{

	private final RectangularMazeModel model;

	private final RectangularMazeRenderer renderer;

	public RectangularMaze(RectangularMazeModel model, RectangularMazeRenderer renderer) {
		this.model = model;
		this.renderer = renderer;
	}
	
	@Override
	public MazeRenderer getRenderer() {
		return renderer;
	}

	@Override
	public MazeModel getModel() {
		return model;
	}

	@Override
	public MazeType getType() {
		return MazeType2D.RECTANGULAR;
	}
}
