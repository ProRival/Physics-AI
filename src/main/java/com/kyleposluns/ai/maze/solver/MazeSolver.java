package com.kyleposluns.ai.maze.solver;


import com.kyleposluns.ai.maze.MazeCell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface MazeSolver<T extends MazeCell> {

	List<T> solve(T origin, T destination);

	default List<T> path(Map<T, T> path, T destination) {
		assert path != null;
		assert destination != null;

		final List<T> pathList = new ArrayList<T>();
		pathList.add(destination);
		while (path.containsKey(destination)) {
			destination = path.get(destination);
			pathList.add(destination);
		}
		Collections.reverse(pathList);
		return pathList;
	}


}
