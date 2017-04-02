package com.kyleposluns.ai.maze.bidimensional.impl.rectangular;

import com.kyleposluns.ai.maze.bidimensional.CartesianMazeModel;
import com.kyleposluns.ai.maze.bidimensional.impl.CartesianCell;
import com.kyleposluns.ai.util.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RectangularMazeModel extends CartesianMazeModel {

	private List<CartesianCell> frontier;

	public RectangularMazeModel(int width, int height) {
		this(new Location(RANDOM.nextInt(width), RANDOM.nextInt(height)), width, height);
	}

	public RectangularMazeModel(Location start, int width, int height) {
		super(start, width, height);
		init();
	}

	public void init() {
		this.frontier = new ArrayList<>();
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				maze[x][y] = new CartesianCell(this, new Location(x, y));
			}
		}
	}

	private final void mark(CartesianCell cell) {
		cell.setVisited(true);
		List<CartesianCell> neighbors = cell.getNeighbors();
		neighbors.removeIf(CartesianCell::isVisited);
		Collections.shuffle(neighbors);
		frontier.addAll(neighbors);
	}

	private final CartesianCell getRandomNeighbor(CartesianCell cell) {
		List<CartesianCell> neighbors = cell.getNeighbors();
		neighbors.removeIf(c -> !c.isVisited());
		return neighbors.get(RANDOM.nextInt(neighbors.size()));
	}

	@Override
	public void generate() {
		if (isGenerated) return;
		CartesianCell startCell = getCell(RANDOM.nextInt(width), RANDOM.nextInt(height));
		System.out.println(startCell.getLocation());
		mark(startCell);
		while (!frontier.isEmpty()) {
			CartesianCell frontierCell = frontier.get(RANDOM.nextInt(frontier.size()));
			CartesianCell neighbor = getRandomNeighbor(frontierCell);
			frontierCell.connect(neighbor);
			mark(frontierCell);
			frontier.removeIf(CartesianCell::isVisited);
		}

	}


	@Override
	public CartesianCell getCell(int x, int y) {
		return maze[x][y];
	}

}
