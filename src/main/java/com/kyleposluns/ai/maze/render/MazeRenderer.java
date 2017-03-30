package com.kyleposluns.ai.maze.render;

import com.kyleposluns.ai.maze.MazeModel;
import java.awt.Graphics;

public interface MazeRenderer<T extends MazeModel> {

	void paint(Graphics g);

}
