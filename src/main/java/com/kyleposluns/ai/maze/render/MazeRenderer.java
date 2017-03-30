package com.kyleposluns.ai.maze.render;

import com.kyleposluns.ai.maze.MazeModel;
import javax.swing.JComponent;

public abstract class MazeRenderer<T extends MazeModel> extends JComponent{

	protected final T model;

	protected final int width, height;

	public MazeRenderer(T model, int width, int height) {
		this.model = model;
		this.width = width;
		this.height = height;
	}

}
