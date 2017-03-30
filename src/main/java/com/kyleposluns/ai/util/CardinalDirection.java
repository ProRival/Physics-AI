package com.kyleposluns.ai.util;

/**
 * Created by Kyle on 3/29/17.
 */
public enum CardinalDirection {

	NORTH(0, 0),

	EAST(0, 0),

	SOUTH(0, 0),

	WEST(0, 0);

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

}
