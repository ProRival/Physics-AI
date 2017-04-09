package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.generator.MazeGenerator;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RectangularMazeGenerator implements MazeGenerator {

	private static final Random RANDOM = new Random();

	protected final int width, height;

	private List<RectangularCell> frontier;

	protected RectangularCell[][] maze;

	private boolean generated;

	public RectangularMazeGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		this.generated = false;
		this.maze = new RectangularCell[width][height];
		this.frontier = new ArrayList<>();
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = new RectangularCell(maze, new Location(x, y));
			}
		}
	}

	protected RectangularCell getCell(int x, int y) {
		try {
			return maze[x][y];
		} catch (IndexOutOfBoundsException e) {
			return null;
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

	@Override
	public void generate() {
		if (generated) return;
		RectangularCell startCell = maze[RANDOM.nextInt(width)][RANDOM.nextInt(height)];
		mark(startCell);
		while (!frontier.isEmpty()) {
			RectangularCell frontierCell = frontier.get(RANDOM.nextInt(frontier.size()));
			RectangularCell neighbor = getRandomNeighbor(frontierCell);
			frontierCell.connect(neighbor);
			mark(frontierCell);
			frontier.removeIf(RectangularCell::isVisited);
		}
		this.generated = true;
	}

	@Override
	public boolean isGenerated() {
		return this.generated;
	}
}
