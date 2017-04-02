package com.kyleposluns.ai.maze.bidimensional.impl.rectangular;

import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.maze.bidimensional.impl.CartesianCell;
import com.kyleposluns.ai.util.Location;
import java.util.Random;

public class RectangularMazeModel extends CartesianMazeModel {

	private Random random;

	public RectangularMazeModel(Location start, Location goal, int width, int height) {
		super(start, goal, width, height);
		this.random = new Random();
		init();
	}

	public void init() {
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = new CartesianCell(this, new Location(x, y));
			}
		}
	}


	@Override
	public void generate() {
		if (isGenerated) return;


	}



	@Override
	public CartesianCell getCell(int x, int y) {
		return maze[x][y];
	}

}
