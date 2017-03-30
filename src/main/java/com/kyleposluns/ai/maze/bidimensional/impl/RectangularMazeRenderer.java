package com.kyleposluns.ai.maze.bidimensional.impl;

import com.kyleposluns.ai.maze.render.MazeRenderer;
import com.kyleposluns.ai.util.CardinalDirection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RectangularMazeRenderer extends MazeRenderer<RectangularMaze> {

	private final int CELL_WIDTH, CELL_HEIGHT;

	public RectangularMazeRenderer(RectangularMaze model) {
		super(model);
		this.CELL_WIDTH = 500 / model.getRows();
		this.CELL_HEIGHT = 500 / model.getColumns();

	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		for (int x = 0; x < model.getRows(); x++) {
			for (int y = 0; y < model.getColumns(); y++) {
				g.setColor(Color.BLACK);

				if (model.getCell(x, y).hasWall(CardinalDirection.NORTH)) {
					g.drawLine(x * CELL_WIDTH, (y + 1) * CELL_HEIGHT, (x + 1) * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
				}

				if (model.getCell(x, y).hasWall(CardinalDirection.WEST)) {
					g.drawLine(x * CELL_WIDTH, y * CELL_HEIGHT, x * CELL_WIDTH, y * CELL_HEIGHT);
				}
			}
		}

	}
}
