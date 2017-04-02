package com.kyleposluns.ai.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kyle on 3/29/17.
 */
public enum Direction {

	NORTH(0, 1),

	EAST(1, 0),

	SOUTH(0, -1),

	WEST(-1, 0);

	public int dx, dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Direction getOpposite() {
		return Direction.values()[ (this.ordinal() + 2) & 3];
	}

	public static List<Direction> getRandomDirections() {
		List<Direction> dirs = Arrays.asList(Direction.values());
		Collections.shuffle(dirs);
		return dirs;
	}


}
