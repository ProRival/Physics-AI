package com.kyleposluns.ai.maze.ui;

import com.kyleposluns.ai.maze.Maze;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.maze.impl.RectangularCell;
import com.kyleposluns.ai.maze.impl.RectangularMaze;
import com.kyleposluns.ai.maze.impl.RectangularMazeGenerator;
import com.kyleposluns.ai.maze.impl.RectangularRenderer;
import com.kyleposluns.ai.maze.solver.MazeSolver;
import com.kyleposluns.ai.util.Location;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

public class MazeUI {

	public static final int DEFAULT_FRAME_DIMENSION = 500;

	public static final int DEFAULT_MAZE_DIMENSION = 25;

	private RectangularMaze maze;

	private RectangularRenderer renderer;

	private final BufferedImage image;

	private JFrame frame;

	public MazeUI() {
		this(null);
	}

	public MazeUI(BufferedImage image) {
		this.frame = new JFrame();
		this.image = image;
		init();
	}

	public void setMaze(RectangularMaze maze) {
		this.maze = maze;
	}


	private static RectangularMaze generate(int rows, int columns) {
		RectangularMazeGenerator generator = new RectangularMazeGenerator(rows, columns);
		return generator.generate();
	}

	private void init() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension((int) (DEFAULT_FRAME_DIMENSION * 1.5), DEFAULT_FRAME_DIMENSION));

		this.maze = generate(DEFAULT_MAZE_DIMENSION, DEFAULT_MAZE_DIMENSION);
		this.renderer = new RectangularRenderer(maze, image);

		this.frame.getContentPane().add(renderer, BorderLayout.CENTER);

		JPanel controls = new JPanel(new GridLayout(10, 1));
		controls.add(createSlider("Rows", 15, 50, rows -> {
			int columns = maze.getColumns();
			this.maze = generate(rows, columns);
			renderer.setMaze(this.maze);
		}));
		controls.add(createSlider("Columns", 15, 50, columns -> {
			int rows = maze.getRows();
			this.maze = generate(rows, columns);
			renderer.setMaze(this.maze);
		}));


		JButton solve = new JButton("Solve");
		solve.addActionListener(e -> renderer.setSolution(maze.getSolver().solve(maze.getStart(), maze.getFinish())));

		controls.add(solve);

		frame.add(controls, BorderLayout.EAST);

		frame.setVisible(true);

		frame.pack();
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
