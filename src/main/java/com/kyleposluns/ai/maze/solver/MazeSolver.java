package com.kyleposluns.ai.maze.solver;


import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.util.Location;
import java.util.List;

public interface MazeSolver<T extends MazeCell> {

	List<T> solve(Location origin, Location destination);

}
