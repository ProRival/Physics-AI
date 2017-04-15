package com.kyleposluns.ai.maze.impl;

import com.kyleposluns.ai.maze.renderer.MazeRenderer;
import com.kyleposluns.ai.util.Direction;
import com.kyleposluns.ai.util.Location;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RectangularRenderer extends MazeRenderer<RectangularMaze> {

	private int CELL_WIDTH, CELL_HEIGHT;

	public RectangularRenderer(RectangularMaze maze) {
		super(maze);
		init();
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
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		g.drawLine(0, 0, maze.getRows() * CELL_WIDTH, 0);
		g.drawLine(0, maze.getColumns() * CELL_HEIGHT, maze.getRows() * CELL_WIDTH, maze.getColumns() * CELL_HEIGHT);
		g.drawLine(0, 0, 0, maze.getColumns() * CELL_HEIGHT);
		g.drawLine(maze.getRows() * CELL_WIDTH, 0, maze.getRows() * CELL_WIDTH, maze.getColumns() * CELL_HEIGHT);

		for (int x = 0; x < maze.getRows(); x++) {
			for (int y = 0; y < maze.getColumns(); y++) {
				g.setColor(Color.BLACK);
				drawCell(g, x, y);
			}
		}

	}

	private void drawCell(Graphics2D g, int x, int y) {
		if (maze.getAccessor().access(new Location(x, y)).hasWall(Direction.NORTH)) {
			g.drawLine(x * CELL_WIDTH, (y + 1) * CELL_HEIGHT, (x + 1) * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}

		if (maze.getAccessor().access(new Location(x, y)).hasWall(Direction.WEST)) {
			g.drawLine(x * CELL_WIDTH, y * CELL_HEIGHT, x * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}
	}

}

