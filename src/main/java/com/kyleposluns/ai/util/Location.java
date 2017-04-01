package com.kyleposluns.ai.util;

public class Location {

	public final int x, y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Location() {
		this(0, 0);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Location)) return false;
		if (!(o.getClass().equals(this.getClass()))) return false;

		Location loc = (Location) o;
		return loc.x == this.x && loc.y == this.y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
