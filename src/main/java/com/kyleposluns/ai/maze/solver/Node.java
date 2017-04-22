package com.kyleposluns.ai.maze.solver;

import com.kyleposluns.ai.maze.MazeCell;
import java.util.Map;

public interface Node {

	Map<? extends MazeCell, Double> getLinks();
	

}
