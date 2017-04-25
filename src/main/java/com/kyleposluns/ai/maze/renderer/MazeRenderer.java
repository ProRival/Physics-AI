package com.kyleposluns.ai.maze.renderer;

import com.kyleposluns.ai.maze.Maze;

import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.solver.MazeSolver;
import java.util.List;
import javax.swing.JPanel;

public abstract class MazeRenderer<T extends Maze> extends JPanel {

	protected T maze;

	public MazeRenderer(T maze) {
		this.maze = maze;
		init();
	}

	public abstract void init();

	public void setMaze(T maze) {
		this.maze = maze;
		repaint();
	}


}
