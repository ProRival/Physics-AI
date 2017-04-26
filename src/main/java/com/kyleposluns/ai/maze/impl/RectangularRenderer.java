package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.renderer.MazeRenderer;
import com.kyleposluns.ai.util.Direction;
import com.kyleposluns.ai.util.Location;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class RectangularRenderer extends MazeRenderer<RectangularMaze> {

	private int CELL_WIDTH, CELL_HEIGHT;

	private List<RectangularCell> solution;

	private int current;

	public RectangularRenderer(RectangularMaze maze) {
		super(maze);
		this.current = -1;
		this.solution = new ArrayList<>();
		init();
	}

	public void step() {
		if (current >= solution.size()) return;
		current++;
		repaint();
	}

	public void setSolution(List<RectangularCell> solution) {
		this.solution = solution;
		this.current = -1;
		repaint();
	}

	public boolean hasSolution() {
		return this.solution != null && !this.solution.isEmpty();
	}

	@Override
	public void init() {
		this.CELL_WIDTH = (getWidth() / maze.getRows());
		this.CELL_HEIGHT = (getHeight() / maze.getColumns());
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		init();
		Graphics2D g = (Graphics2D) graphics;

		g.setColor(Color.BLACK);

		g.drawLine(0, 0, maze.getRows() * CELL_WIDTH, 0);
		g.drawLine(0, maze.getColumns() * CELL_HEIGHT, maze.getRows() * CELL_WIDTH, maze.getColumns() * CELL_HEIGHT);
		g.drawLine(0, 0, 0, maze.getColumns() * CELL_HEIGHT);
		g.drawLine(maze.getRows() * CELL_WIDTH, 0, maze.getRows() * CELL_WIDTH, maze.getColumns() * CELL_HEIGHT);

		for (int x = 0; x < maze.getRows(); x++) {
			for (int y = 0; y < maze.getColumns(); y++) {
				g.setColor(Color.BLACK);
				drawCell(g, x, y);
				if (current < 0) {
					drawSolution(g, x, y);
				}
			}
		}

		if (current >= 0) {
			for (int i = 0; i < current; i++) {
				Location location = solution.get(i).getLocation();
				drawSolution(g, location.x, location.y);
			}
		}
	}

	private void drawSolution(Graphics2D g, int x, int y) {
		if (!hasSolution() || !(solution.contains(maze.getAccessor().access(x, y)))) return;
		g.setColor(Color.RED);
		g.fillOval((int) ((x + .25) * CELL_WIDTH), (int) ((y + .25) * CELL_HEIGHT), CELL_WIDTH / 2, CELL_HEIGHT / 2);
	}


	private void drawCell(Graphics2D g, int x, int y) {
		if (maze.getAccessor().access(x, y).hasWall(Direction.NORTH)) {
			g.setColor(Color.BLACK);
			g.drawLine(x * CELL_WIDTH, (y + 1) * CELL_HEIGHT, (x + 1) * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		} else {
			g.setColor(new Color(245, 245, 245));
			g.drawLine(x * CELL_WIDTH, (y + 1) * CELL_HEIGHT, (x + 1) * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}

		if (maze.getAccessor().access(x, y).hasWall(Direction.WEST)) {
			g.setColor(Color.BLACK);
			g.drawLine(x * CELL_WIDTH, y * CELL_HEIGHT, x * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		} else {
			g.setColor(new Color(245, 245, 245));
			g.drawLine(x * CELL_WIDTH, y * CELL_HEIGHT, x * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}
	}

}

