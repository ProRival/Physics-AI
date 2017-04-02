package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.util.Direction;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.List;

public class CartesianCell implements MazeCell {

	private CartesianMazeModel model;

	private boolean[] walls;

	private boolean visited;

	private Location location;

	public CartesianCell(CartesianMazeModel model, Location location) {
		this.model = model;
		this.location = location;
		this.visited = false;
		this.walls = new boolean[]{true, true, true, true};
	}

	public Location getLocation() {
		return this.location;
	}

	public void openWall(Direction direction) {
		this.walls[direction.ordinal()] = false;
	}

	public boolean hasWall(Direction direction) {
		return walls[direction.ordinal()];
	}

	public List<CartesianCell> getNeighbors() {
		List<CartesianCell> neighbors = new ArrayList<>();
		for (Direction dir : Direction.values()) {
			CartesianCell relative = getRelative(dir);
			if (relative != null) {
				neighbors.add(relative);
			}
		}
		return neighbors;
	}

	public CartesianCell getRelative(Direction dir) {
		try {
			return model.getCell(location.x + dir.dx, location.y + dir.dy);
		} catch (ArrayIndexOutOfBoundsException a) {
			return null;
		}
	}

	@Override
	public void connect(MazeCell cell) {
		if (!(cell instanceof CartesianCell)) throw new IllegalArgumentException();
		for (Direction dir : Direction.values()) {
			CartesianCell relative = getRelative(dir);
			if (relative != null && relative.equals(cell)) {
				this.openWall(dir);
				relative.openWall(dir.getOpposite());
				break;
			}
		}
	}

	@Override
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public boolean isVisited() {
		return this.visited;
	}
}

