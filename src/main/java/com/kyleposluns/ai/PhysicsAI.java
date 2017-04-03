package com.kyleposluns.ai;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.generator.MazeGenerator;
import com.kyleposluns.ai.maze.impl.RectangularMaze;
import com.kyleposluns.ai.maze.impl.RectangularMazeGenerator;
import com.kyleposluns.ai.maze.impl.RectangularRenderer;
import com.kyleposluns.ai.maze.renderer.MazeRenderer;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

public class PhysicsAI {

	public static void main(String[] args) {
		new PhysicsAI();
	}


	private static final int DEFAULT_DIMENSION = 25;

	private JFrame frame;


	public PhysicsAI() {
		init();
	}


	private final void init() {
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		RectangularMazeGenerator generator = new RectangularMazeGenerator(25, 25);
		RectangularMaze maze = generator.generate();

		MazeRenderer renderer = new RectangularRenderer(maze, 500, 500);

		renderer.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				renderer.setSize(e.getComponent().getSize());
			}
		});
		frame.setLayout(new BorderLayout());

		frame.getContentPane().add(renderer, BorderLayout.CENTER);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.pack();
	}




}
