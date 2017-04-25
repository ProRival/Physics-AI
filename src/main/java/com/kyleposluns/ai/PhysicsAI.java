package com.kyleposluns.ai;

import com.kyleposluns.ai.maze.ui.MazeUI;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class PhysicsAI {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			if (args.length != 1) throw new IllegalArgumentException();
			File pathFile = new File(args[0]);
			try {
				BufferedImage path = ImageIO.read(pathFile);
				new MazeUI(path);
			} catch (IOException e) {
				e.printStackTrace();
				new MazeUI();
			}
		});
	}

}
