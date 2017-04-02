package com.kyleposluns.ai.maze;

import java.awt.Dimension;
import javax.swing.JComponent;

public abstract class MazeRenderer<T extends MazeModel> extends JComponent{

	protected final T model;

	protected final int width, height;

	public MazeRenderer(T model, int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.model = model;
		this.setPreferredSize(new Dimension(width, height));
	}

	public abstract MazeType getType();
}
