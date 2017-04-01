package com.kyleposluns.ai.maze.bidimensional.impl.rectangular;

import com.kyleposluns.ai.maze.MazeType;
import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.maze.bidimensional.MazeType2D;
import com.kyleposluns.ai.maze.bidimensional.impl.CartesianCell;
import com.kyleposluns.ai.util.CardinalDirection;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectangularMazeModel extends CartesianMazeModel {

	private Random random;

	public RectangularMazeModel(int width, int height) {
		this(new Location(1, 1), new Location(width - 1, height - 1), width, height);
	}

	public RectangularMazeModel(Location start, Location goal, int width, int height) {
		super(start, goal, width, height);
		this.random = new Random();
		init();
	}

	public void init() {
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = new CartesianCell(new Location(x, y));
			}
		}
	}

	private void carve(CartesianCell c1, CardinalDirection dir) {
		CartesianCell relative = getRelative(c1, dir);
		if (relative == null) throw new NullPointerException();
		c1.openWall(dir);
		relative.openWall(dir.getOpposite());
	}

	private void mark(List<CartesianCell> frontier, CartesianCell origin) {
		origin.setVisited(true);
		for (CardinalDirection dir : CardinalDirection.values()) {
			if (getRelative(origin, dir) == null) continue;
			if (getRelative(origin, dir).isVisited()) continue;
			frontier.add(getRelative(origin, dir));
		}
	}

	private CardinalDirection getInNeighbor(CartesianCell cell) {
		CardinalDirection neighbor = null;
		for (CardinalDirection dir : CardinalDirection.values()) {
			if (getRelative(cell, dir).isVisited()) continue;
			if (neighbor == null) {
				neighbor = dir;
			} else {
				neighbor = random.nextInt() % 2 == 0 ? dir : neighbor;
			}
		}
		return neighbor;
	}

	@Override
	public void generate() {
		if (isGenerated) return;
		List<CartesianCell> frontier = new ArrayList<>();
		CartesianCell startCell = getCell(random.nextInt(width), random.nextInt(height));
		mark(frontier, startCell);
		while (!frontier.isEmpty()) {
			try {
				CartesianCell frontierCell = frontier.remove(random.nextInt(frontier.size()));
				CardinalDirection dir = getInNeighbor(frontierCell);
				carve(frontierCell, dir);
				mark(frontier, frontierCell);
			} catch (Exception e) {
				continue;
			}
		}

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
