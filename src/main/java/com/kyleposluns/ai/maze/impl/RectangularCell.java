package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.util.Direction;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.List;

public class RectangularCell implements MazeCell {

	private final RectangularCell[][] maze;

	private final Location location;

	private boolean visited;

	private boolean[] walls;

	public RectangularCell(RectangularCell[][] maze, Location location) {
		this.maze = maze;
		this.location = location;
		this.visited = false;
		this.walls = new boolean[]{true, true, true, true};
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	public void openWall(Direction direction) {
		this.walls[direction.ordinal()] = false;
	}

	@Override
	public boolean hasWall(Direction direction) {
		return walls[direction.ordinal()];
	}

	public List<RectangularCell> getNeighbors() {
		List<RectangularCell> neighbors = new ArrayList<>();
		for (Direction dir : Direction.values()) {
			RectangularCell relative = getRelative(dir);
			if (relative != null) {
				neighbors.add(relative);
			}
		}
		return neighbors;
	}

	public RectangularCell getRelative(Direction dir) {
		try {
			return maze[location.x + dir.dx][location.y + dir.dy];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public void connect(MazeCell cell) {
		if (!(cell instanceof RectangularCell)) throw new IllegalArgumentException();
		for (Direction dir : Direction.values()) {
			RectangularCell relative = getRelative(dir);
			if (relative != null && relative.equals(cell)) {
				this.openWall(dir);
				relative.openWall(dir.getOpposite());
				break;
			}
		}
	}

	@Override
	public boolean isVisited() {
		return this.visited;
	}

	@Override
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
