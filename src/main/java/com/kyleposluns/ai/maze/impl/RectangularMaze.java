package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.CellAccessor;
import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.util.Location;

public class RectangularMaze implements Maze, CellAccessor<RectangularCell> {

	private RectangularMazeGenerator generator;

	public RectangularMaze(RectangularMazeGenerator generator) {
		this.generator = generator;
		if (!generator.isGenerated()) {
			generator.generate();
		}
	}

	public int getRows() {
		return generator.width;
	}

	public int getColumns() {
		return generator.height;
	}

	@Override
	public RectangularCell access(Location location) {
		return generator.getCell(location.x, location.y);
	}

}
