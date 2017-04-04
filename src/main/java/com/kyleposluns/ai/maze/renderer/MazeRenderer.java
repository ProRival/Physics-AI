package com.kyleposluns.ai.maze.renderer;

import com.kyleposluns.ai.maze.Maze;

import java.awt.Dimension;
import javax.swing.JComponent;

public abstract class MazeRenderer<T extends Maze> extends JComponent {

	protected T maze;

	public MazeRenderer(T maze, int width, int height) {
		this.maze = maze;
		this.setPreferredSize(new Dimension(width, height));
		this.setSize(new Dimension(width, height));
	}

	protected abstract void init();

	public void setMaze(T maze) {
		this.maze = maze;
		init();
		super.repaint();
	}

}
