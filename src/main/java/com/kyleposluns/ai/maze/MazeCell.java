package com.kyleposluns.ai.maze;

public interface MazeCell {

	void connect(MazeCell cell);

	void setVisited(boolean visited);

	boolean isVisited();

}
