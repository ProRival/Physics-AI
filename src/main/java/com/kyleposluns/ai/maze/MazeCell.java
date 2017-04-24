package com.kyleposluns.ai.maze;

import com.kyleposluns.ai.util.Direction;
import com.kyleposluns.ai.util.Location;

public interface MazeCell {

	void connect(MazeCell cell);

	boolean isVisited();

	void setVisited(boolean visited);

	Location getLocation();

	boolean hasWall(Direction dir);



}
