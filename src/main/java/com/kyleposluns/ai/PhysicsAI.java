package com.kyleposluns.ai;


import com.kyleposluns.ai.maze.bidimensional.impl.RectangularMaze;
import com.kyleposluns.ai.maze.bidimensional.impl.RectangularMazeRenderer;
import com.kyleposluns.ai.maze.render.MazeRenderer;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class PhysicsAI {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RectangularMaze maze = new RectangularMaze(25, 25);
		maze.generate();
		MazeRenderer<RectangularMaze> renderer = new RectangularMazeRenderer(maze, 500, 500);

		f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

		f.getContentPane().add(renderer);
		f.pack();
		f.setVisible(true);

	}



}
