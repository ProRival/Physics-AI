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

	public double distance(Location location) {
		return Math.sqrt(distanceSquared(location));
	}

	public double distanceSquared(Location location) {
		return Math.pow(location.x - x, 2) + Math.pow(location.y - 1, 2);
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
