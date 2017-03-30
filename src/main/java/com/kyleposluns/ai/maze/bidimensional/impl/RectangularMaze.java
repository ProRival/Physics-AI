package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.MazeCell;
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

	private void generate(int x, int y) {
		List<CardinalDirection> dirs = CardinalDirection.getRandomDirections();

		for (int i = 0; i < dirs.size(); i++) {
			CardinalDirection direction = dirs.get(i);

			Location relative = new Location(x + direction.getDeltaX(), y + direction.getDeltaY());
			Location nextRelative = new Location(x + (direction.getDeltaX() * 2), y + (direction.getDeltaY() * 2));

			if (nextRelative.x >= width || nextRelative.y >= height) continue;
			if (nextRelative.x < 0 || nextRelative.y < 0) continue;
			if (maze[nextRelative.x][nextRelative.y] == null) continue;

			if (maze[nextRelative.x][nextRelative.y].getLocation().equals(goal)) {
				maze[relative.x][relative.y].openWall(direction);
				continue;
			}

			if (maze[nextRelative.x][nextRelative.y].hasWall(direction)) {
				maze[relative.x][relative.y].openWall(direction);
				maze[nextRelative.x][nextRelative.y].openWall(direction);
				generate(nextRelative.x, nextRelative.y);
			}

		}
	}

	@Override
	public void generate() {
		if (isGenerated) return;
		generate(0, 0);
	}



	@Override
	public MazeType getType() {
		return MazeType2D.RECTANGULAR;
	}

	@Override
	public MazeCell getCell(int x, int y) {
		return maze[x][y];
	}

}
