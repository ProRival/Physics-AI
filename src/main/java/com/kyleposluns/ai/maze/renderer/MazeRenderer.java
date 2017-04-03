package com.kyleposluns.ai.maze.renderer;

import com.kyleposluns.ai.maze.Maze;
import java.awt.Graphics;

/**
 * Created by Kyle on 4/2/17.
 */
public interface MazeRenderer<T extends Maze> {

	void render(T maze, Graphics g);

}
