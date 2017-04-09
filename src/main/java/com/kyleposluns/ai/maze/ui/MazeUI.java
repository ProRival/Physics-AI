package com.kyleposluns.ai.maze.ui;

import com.kyleposluns.ai.maze.impl.RectangularMaze;
import com.kyleposluns.ai.maze.impl.RectangularMazeGenerator;
import com.kyleposluns.ai.maze.impl.RectangularRenderer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.function.IntConsumer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

public class MazeUI {

	public static final int DEFAULT_FRAME_DIMENSION = 500;

	public static final int DEFAULT_MAZE_DIMENSION = 25;

	public static void buildUI() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new BorderLayout());

		RectangularMaze maze = generate(DEFAULT_MAZE_DIMENSION, DEFAULT_MAZE_DIMENSION);
		RectangularRenderer renderer = new RectangularRenderer(maze);
		renderer.setPreferredSize(new Dimension(DEFAULT_FRAME_DIMENSION, DEFAULT_FRAME_DIMENSION));
		renderer.setSize(renderer.getPreferredSize());
		f.getContentPane().add(renderer, BorderLayout.CENTER);

		JPanel controls = new JPanel(new FlowLayout());
		controls.add(createSlider("Rows", 5, 150, rows -> {
			int columns = maze.getColumns();
			renderer.setMaze(generate(rows, columns));
		}));
		controls.add(createSlider("Columns", 5, 150, columns -> {
			int rows = maze.getRows();
			renderer.setMaze(generate(rows, columns));
		}));
		f.getContentPane().add(controls, BorderLayout.EAST);

		f.setLocationRelativeTo(null);
		f.setVisible(true);

		f.pack();

	}

	private static RectangularMaze generate(int rows, int columns) {
		RectangularMazeGenerator generator = new RectangularMazeGenerator(rows, columns);
		generator.generate();
		return new RectangularMaze(generator);
	}

	private static JPanel createSlider(String name, int min, int max, IntConsumer intConsumer) {
		JPanel p = new JPanel(new BorderLayout());
		p.add(new JLabel(name), BorderLayout.NORTH);
		JSlider slider = new JSlider(min, max, DEFAULT_MAZE_DIMENSION);
		JLabel value = new JLabel(String.valueOf(slider.getValue()));
		slider.addChangeListener(e -> {
			value.setText(String.valueOf(slider.getValue()));
			intConsumer.accept(slider.getValue());
		});
		p.add(slider, BorderLayout.CENTER);
		p.add(value, BorderLayout.SOUTH);
		return p;
	}


}
