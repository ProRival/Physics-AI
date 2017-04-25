package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.renderer.MazeRenderer;
import com.kyleposluns.ai.util.Direction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class RectangularRenderer extends MazeRenderer<RectangularMaze> {

	private int CELL_WIDTH, CELL_HEIGHT;

	private List<RectangularCell> solution;

	private BufferedImage image;


	public RectangularRenderer(RectangularMaze maze,  BufferedImage image) {
		this(maze);
		this.image = image;
	}

	public RectangularRenderer(RectangularMaze maze) {
		super(maze);
		this.solution = new ArrayList<>();
		init();
	}

	public void setSolution(List<RectangularCell> solution) {
		this.solution = solution;
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

		g.setColor(Color.WHITE);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		g.drawLine(0, 0, maze.getRows() * CELL_WIDTH, 0);
		g.drawLine(0, maze.getColumns() * CELL_HEIGHT, maze.getRows() * CELL_WIDTH, maze.getColumns() * CELL_HEIGHT);
		g.drawLine(0, 0, 0, maze.getColumns() * CELL_HEIGHT);
		g.drawLine(maze.getRows() * CELL_WIDTH, 0, maze.getRows() * CELL_WIDTH, maze.getColumns() * CELL_HEIGHT);

		for (int x = 0; x < maze.getRows(); x++) {
			for (int y = 0; y < maze.getColumns(); y++) {
				g.setColor(Color.BLACK);
				drawCell(g, x, y);
				drawSolution(g, x, y);
			}
		}

	}

	private void drawSolution(Graphics2D g, int x, int y) {
		if (!hasSolution() || !(solution.contains(maze.getAccessor().access(x, y)))) return;
		if (image == null) {
			g.setColor(Color.RED);
			g.fillOval(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH / 2, CELL_HEIGHT / 2);
		} else {
			g.drawImage(image, x * CELL_WIDTH, y * CELL_HEIGHT, this);
		}
	}

	private void drawCell(Graphics2D g, int x, int y) {
		if (maze.getAccessor().access(x, y).hasWall(Direction.NORTH)) {
			g.drawLine(x * CELL_WIDTH, (y + 1) * CELL_HEIGHT, (x + 1) * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}

		if (maze.getAccessor().access(x, y).hasWall(Direction.WEST)) {
			g.drawLine(x * CELL_WIDTH, y * CELL_HEIGHT, x * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}
	}

}

