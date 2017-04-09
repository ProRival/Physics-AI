package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.CellAccessor;
import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.util.Location;

public class RectangularMaze implements Maze {

	private final int rows, columns;

	private final CellAccessor<RectangularCell> accessor;

	public RectangularMaze(int rows, int columns, CellAccessor<RectangularCell> accessor) {
		this.rows = rows;
		this.columns = columns;
		this.accessor = accessor;

	}

	public int getRows() {
		return this.rows;
	}

	public int getColumns() {
		return this.columns;
	}


	public CellAccessor<RectangularCell> getAccessor() {
		return this.accessor;
	}

}
