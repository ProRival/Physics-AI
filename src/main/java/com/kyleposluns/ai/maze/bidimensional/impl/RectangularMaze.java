package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;
import com.kyleposluns.ai.util.CardinalDirection;
import com.kyleposluns.ai.util.Location;
import java.util.List;

public class RectangularMaze extends CartesianMazeModel {

	public RectangularMaze(int width, int height) {
		super(width, height);
	}

	public RectangularMaze(Location start, Location goal, int width, int height) {
		super(start, goal, width, height);
	}

	@Override
	public void init() {
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = new CartesianCell(new Location(x, y));
			}
		}
	}

	private void carve(CartesianCell c1, CardinalDirection dir) {
		CartesianCell relative = getRelative(c1, dir);
		c1.openWall(dir);

		relative.openWall(dir.getOpposite());
	}

	private boolean isAcceptable(Location loc) {
		return loc.x < width && loc.x >= 0 && loc.y < height && loc.y >= 0;
	}

	private void generate(int x, int y) {
		CartesianCell cell = getCell(x, y);
		cell.setVisited(true);
		List<CardinalDirection> dirs = CardinalDirection.getRandomDirections();
		for (int i = 0; i < dirs.size(); i++) {
			CardinalDirection ranDir = dirs.get(i);
			if (getRelative(cell, ranDir) == null) continue;
			if (getRelative(cell, ranDir).isVisited()) continue;
			carve(cell, ranDir);
			generate(cell.getLocation().x + ranDir.getDeltaX(), cell.getLocation().y + ranDir.getDeltaY());
		}
	}



	@Override
	public void generate() {
		if (isGenerated) return;
		generate(1, 1);
	}


	@Override
	public MazeType getType() {
		return MazeType2D.RECTANGULAR;
	}

	@Override
	public CartesianCell getCell(int x, int y) {
		return maze[x][y];
	}

}
