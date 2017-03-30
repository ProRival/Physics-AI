package com.kyleposluns.ai.maze.render;

import com.kyleposluns.ai.maze.MazeModel;
import java.awt.Graphics;

public abstract class MazeRenderer<T extends MazeModel> {

	protected T model;

	public MazeRenderer(T model) {
		this.model = model;
	}

	public abstract  void paint(Graphics g);

}
