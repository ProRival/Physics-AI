package com.kyleposluns.ai;


import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.RectangularMazeModel;
import com.kyleposluns.ai.maze.bidimensional.impl.rectangular.RectangularMazeRenderer;
import com.kyleposluns.ai.maze.render.MazeRenderer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

public class PhysicsAI {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RectangularMazeModel maze = new RectangularMazeModel(50, 50);
		maze.generate();
		MazeRenderer<RectangularMazeModel> renderer = new RectangularMazeRenderer(maze, 500, 500);

		renderer.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				renderer.setSize(e.getComponent().getSize());
			}
		});

		f.getContentPane().setLayout(new BorderLayout());

		f.getContentPane().add(renderer, BorderLayout.CENTER);
		f.setResizable(true);
		f.setVisible(true);
		f.pack();

	}



}
