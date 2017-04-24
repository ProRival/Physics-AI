package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.CellAccessor;
import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.solver.AStarSolver;
import com.kyleposluns.ai.maze.solver.MazeSolver;
import com.kyleposluns.ai.util.Location;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class RectangularMaze implements Maze<RectangularCell> {

	private final Set<RectangularCell> cells;

	private final int rows, columns;

	private Location start, finish;

	private final CellAccessor<RectangularCell> accessor;

	private final MazeSolver<RectangularCell> solver;

	public RectangularMaze(Location start, Location finish, int rows, int columns, CellAccessor<RectangularCell> accessor) {
		this.start = start;
		this.finish = finish;
		this.rows = rows;
		this.columns = columns;
		this.accessor = accessor;
		Set<RectangularCell> cellSet = new HashSet<>();
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				cellSet.add(accessor.access(x, y));
			}
		}
		this.cells = Collections.unmodifiableSet(cellSet);
		this.solver = new AStarSolver(this);
	}

	@Override
	public int getRows() {
		return this.rows;
	}

	@Override
	public int getColumns() {
		return this.columns;
	}

	@Override
	public CellAccessor<RectangularCell> getAccessor() {
		return this.accessor;
	}

	@Override
	public MazeSolver<RectangularCell> getSolver() {
		return this.solver;
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
	public Iterator<RectangularCell> iterator() {
		return this.cells.iterator();
	}
}
