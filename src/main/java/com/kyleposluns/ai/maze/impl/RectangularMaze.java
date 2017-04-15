package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.CellAccessor;
import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.solver.Node;
import com.kyleposluns.ai.maze.solver.NodeGraph;
import com.kyleposluns.ai.maze.solver.PathFinder;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMaze implements Maze<RectangularCell> {

	private final int rows, columns;

	private Location start, finish;

	private final CellAccessor<RectangularCell> accessor;

	public RectangularMaze(Location start, Location finish, int rows, int columns, CellAccessor<RectangularCell> accessor) {
		this.start = start;
		this.finish = finish;
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

	@Override
	public Location getStart() {
		return this.start;
	}

	@Override
	public Location getFinish() {
		return this.finish;
	}

	@Override
	public PathFinder<RectangularCell> getPathFinder() {
		Map<RectangularCell, Map<RectangularCell, Float>> heuristic = new HashMap<>();

		return null;
	}
}
