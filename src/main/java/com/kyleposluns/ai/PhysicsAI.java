package com.kyleposluns.ai;

import com.kyleposluns.ai.maze.ui.MazeUI;
import javax.swing.SwingUtilities;

public class PhysicsAI {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MazeUI::buildUI);
	}

}
