package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.util.CardinalDirection;
import com.kyleposluns.ai.util.Location;

public class CartesianCell implements MazeCell {

	private boolean[] walls;

	private Location location;

	public CartesianCell(Location location) {
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


}
