package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.util.CardinalDirection;
import com.kyleposluns.ai.util.Location;

public class CartesianCell implements MazeCell {

	private CartesianMazeModel model;

	private boolean[] walls;

	private Location location;

	public CartesianCell(CartesianMazeModel model, Location location) {
		this.model = model;
		this.location = location;
		this.walls = new boolean[]{true, true, true, true};
	}

	public Location getLocation() {
		return this.location;
	}

	public void openWall(CardinalDirection direction) {
		this.walls[direction.ordinal()] = false;
	}

	public boolean hasWall(CardinalDirection direction) {
		return walls[direction.ordinal()];
	}

	public CartesianCell getRelative(CardinalDirection dir) {
		try {
			return model.getCell(location.x + dir.dx, location.y + dir.dy);
		} catch (ArrayIndexOutOfBoundsException a) {
			return null;
		}
	}

	@Override
	public void connect(MazeCell cell) {
		if (!(cell instanceof CartesianCell)) throw new IllegalArgumentException();
		for (CardinalDirection dir : CardinalDirection.values()) {
			CartesianCell relative = getRelative(dir);
			if (relative != null && relative.equals(cell)) {
				this.openWall(dir);
				relative.openWall(dir.getOpposite());
				break;
			}
		}
	}
}

