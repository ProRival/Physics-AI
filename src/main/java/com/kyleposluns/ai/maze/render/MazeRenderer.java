package com.kyleposluns.ai.maze.render;

import com.kyleposluns.ai.maze.MazeModel;
import javax.swing.JComponent;

public abstract class MazeRenderer<T extends MazeModel> extends JComponent{

	protected final T model;
	
	public MazeRenderer(T model) {
		this.model = model;
	}

}
