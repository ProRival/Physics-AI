package com.kyleposluns.ai.maze;

import com.kyleposluns.ai.util.Location;

public interface CellAccessor<T extends MazeCell> {

	T access(Location location);

}
