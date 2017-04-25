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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.IntConsumer;
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

	private final BufferedImage path;

	private JFrame frame;

	public MazeUI() {
		this(null);
	}

	public MazeUI(BufferedImage path) {
		this.frame = new JFrame();
		this.path = path;
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
		this.renderer = new RectangularRenderer(maze, path);


		renderer.setBackground(Color.WHITE);
		this.frame.getContentPane().add(renderer, BorderLayout.CENTER);

		JLabel timeLabel = new JLabel("Solve Time: N/A");

		JPanel controls = new JPanel(new GridLayout(10, 1));
		controls.add(createSlider("Rows", 15, 50, rows -> {
			int columns = maze.getColumns();
			this.maze = generate(rows, columns);
			renderer.setMaze(this.maze);
			timeLabel.setText("Solve Time: N/A");
		}));
		controls.add(createSlider("Columns", 15, 50, columns -> {
			int rows = maze.getRows();
			this.maze = generate(rows, columns);
			renderer.setMaze(this.maze);
			timeLabel.setText("Solve Time: N/A");
		}));


		JButton solve = new JButton("Solve");
		solve.addActionListener(e -> {
			long start = System.currentTimeMillis();
			renderer.setSolution(maze.getSolver().solve(maze.getStart(), maze.getFinish()));
			long stop = System.currentTimeMillis();
			timeLabel.setText("Solved Time: " + new SimpleDateFormat("ss.SS").format(new Date(stop - start)) + " seconds!");
		});

		controls.add(timeLabel);
		controls.add(solve);
		controls.setBackground(new Color(255, 255, 204));

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
		p.setBackground(new Color(255, 182, 193));
		return p;
	}

}
