package com.kyleposluns.ai.util;

public class Location {

	public static final int MANHATTAN = 0;

	public static final int EUCLIDEAN = 1;

	public final int x, y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Location() {
		this(0, 0);
	}

	public double distance(Location location, int type) {
		switch (type) {
			case MANHATTAN:
				return Math.abs(location.x - this.x) + Math.abs(location.y - this.y);
			case EUCLIDEAN:
				return Math.sqrt(Math.pow(location.x - this.x, 2) + Math.pow(location.y - this.y, 2));
		}
		return 0.0;
	}

	public double distance(Location location) {
		return distance(location, MANHATTAN);
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
