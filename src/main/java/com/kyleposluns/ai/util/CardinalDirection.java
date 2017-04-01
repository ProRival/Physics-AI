package com.kyleposluns.ai.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kyle on 3/29/17.
 */
public enum CardinalDirection {

	NORTH(0, -1),

	EAST(1, 0),

	SOUTH(0, 1),

	WEST(-1, 0);

	private int deltaX, deltaY;

	CardinalDirection(int deltaX, int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	public int getDeltaX() {
		return this.deltaX;
	}

	public int getDeltaY() {
		return this.deltaY;
	}

	public CardinalDirection getOpposite() {
		return CardinalDirection.values()[ (this.ordinal() + 2) & 3];
	}

	public static List<CardinalDirection> getRandomDirections() {
		List<CardinalDirection> dirs = Arrays.asList(CardinalDirection.values());
		Collections.shuffle(dirs);
		return dirs;
	}


}
