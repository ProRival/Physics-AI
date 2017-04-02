package com.kyleposluns.ai.maze.bidimensional.impl.rectangular.square;

import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.RectangularMazeModel;
import com.kyleposluns.ai.util.Location;

public class SquareMazeModel extends RectangularMazeModel {

	public SquareMazeModel(Location start, Location goal, int n) {
		super(start, goal, n, n);
	}

}
