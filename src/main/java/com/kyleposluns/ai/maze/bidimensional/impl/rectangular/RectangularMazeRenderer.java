package com.kyleposluns.ai.maze.bidimensional.impl.rectangular;

import com.kyleposluns.ai.maze.render.MazeRenderer;
import com.kyleposluns.ai.util.Direction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;

public class RectangularMazeRenderer extends MazeRenderer<RectangularMazeModel> {

	private int CELL_WIDTH, CELL_HEIGHT;

	public RectangularMazeRenderer(RectangularMazeModel model, int width, int height) {
		super(model, width, height);
		init();
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	}

	private final void init() {
		this.CELL_WIDTH = (((int) (this.getPreferredSize().getWidth())) / model.getRows());
		this.CELL_HEIGHT = (((int) (this.getPreferredSize().getHeight())) / model.getColumns());
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
				drawCell(g, x, y);
			}
		}


	}

	private void drawCell(Graphics2D g, int x, int y) {
		if (model.getCell(x, y).hasWall(Direction.NORTH)) {
			g.drawLine(x * CELL_WIDTH, (y + 1) * CELL_HEIGHT, (x + 1) * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}

		if (model.getCell(x, y).hasWall(Direction.WEST)) {
			g.drawLine(x * CELL_WIDTH, y * CELL_HEIGHT, x * CELL_WIDTH, (y + 1) * CELL_HEIGHT);
		}

	}

}
