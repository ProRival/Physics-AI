package com.kyleposluns.ai.maze;

public interface MazeCell {

	void connect(MazeCell cell);

	boolean isVisited();

	void setVisited(boolean visited);

}
