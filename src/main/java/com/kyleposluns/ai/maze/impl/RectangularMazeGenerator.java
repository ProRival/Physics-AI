package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.generator.MazeGenerator;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RectangularMazeGenerator implements MazeGenerator<RectangularMaze> {

	private static final Random RANDOM = new Random();

	protected final int width, height;

	private List<RectangularCell> frontier;

	protected RectangularCell[][] maze;

	public RectangularMazeGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		init();
	}

	private final void init() {
		this.maze = new RectangularCell[width][height];
		this.frontier = new ArrayList<>();
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze.length; y++) {
				maze[x][y] = new RectangularCell(maze, new Location(x, y));
			}
		}

	}

	private final void mark(RectangularCell cell) {
		cell.setVisited(true);
		List<RectangularCell> neighbors = cell.getNeighbors();
		neighbors.removeIf(RectangularCell::isVisited);
		Collections.shuffle(neighbors);
		frontier.addAll(neighbors);
	}

	private final RectangularCell getRandomNeighbor(RectangularCell cell) {
		List<RectangularCell> neighbors = cell.getNeighbors();
		neighbors.removeIf(c -> !c.isVisited());
		return neighbors.get(RANDOM.nextInt(neighbors.size()));
	}

	public void recalc() {
		init();
	}

	@Override
	public RectangularMaze generate() {
		RectangularCell startCell = maze[RANDOM.nextInt(width)][RANDOM.nextInt(height)];
		mark(startCell);
		while (!frontier.isEmpty()) {
			RectangularCell frontierCell = frontier.get(RANDOM.nextInt(frontier.size()));
			RectangularCell neighbor = getRandomNeighbor(frontierCell);
			frontierCell.connect(neighbor);
			mark(frontierCell);
			frontier.removeIf(RectangularCell::isVisited);
		}
		return new RectangularMaze(this);
	}
}
