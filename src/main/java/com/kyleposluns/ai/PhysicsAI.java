package com.kyleposluns.ai;

import com.kyleposluns.ai.maze.ui.MazeUI;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class PhysicsAI {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MazeUI::new);
	}

}
