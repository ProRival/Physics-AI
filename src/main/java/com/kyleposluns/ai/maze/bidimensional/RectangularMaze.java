package com.kyleposluns.ai.maze.bidimensional;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.MazeType;
import java.awt.Graphics;

public class RectangularMaze implements Maze, MazePlan2d {

	private boolean isGenerated;

	private int width, height;

	public RectangularMaze(int width, int height) {
		this.width = width;
		this.height = height;
		this.isGenerated = false;
	}

	@Override
	public void generate() {
		if (isGenerated) return;
	}

	@Override
	public void paint(Graphics graphics) {
		if (!isGenerated) {
			generate();
		}

	}

	@Override
	public MazeCell getCell(int x, int y) {
		return null;
	}

	@Override
	public MazeType getType() {
		return MazeType2d.RECTANGULAR;
	}
}
