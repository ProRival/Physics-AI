package com.kyleposluns.ai.maze.render;

import com.kyleposluns.ai.maze.MazeModel;
import java.awt.Graphics;

public abstract class MazeRenderer<T extends MazeModel> {

	protected final T model;

	protected final int width, height;

	public MazeRenderer(T model, int width, int height) {
		this.model = model;
		this.width = width;
		this.height = height;
	}

	public abstract  void paint(Graphics g);

}
