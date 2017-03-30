package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;
import com.kyleposluns.ai.util.Location;

public class RectangularMaze extends CartesianMazeModel {

	public RectangularMaze(int width, int height) {
		super(width, height);
	}

	@Override
	public void init() {
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = new CartesianCell(new Location(x, y));
			}
		}
	}

	@Override
	public void generate() {
		if (isGenerated) return;

	}



	@Override
	public MazeType getType() {
		return MazeType2D.RECTANGULAR;
	}

	@Override
	public MazeCell getCell(int x, int y) {
		return null;
	}
}
