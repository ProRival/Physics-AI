package com.kyleposluns.ai.maze.solver;
import com.kyleposluns.ai.maze.MazeCell;
import com.kyleposluns.ai.util.Location;
import java.util.List;

public interface MazeSolver<T extends MazeCell> {

	default List<T> solve(T source, T destination) {
		return solve(source.getLocation(), destination.getLocation());
	}

	List<T> solve(Location source, Location destination);

}
