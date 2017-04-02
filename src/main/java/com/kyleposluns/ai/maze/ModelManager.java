package com.kyleposluns.ai.maze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ModelManager {

	private Collection<MazeModel> models;

	public ModelManager() {
		this.models = new HashSet<>();
	}

	public void registerModel(MazeModel model) {
		models.removeIf(m -> model.getType().equals(m.getType()));
		this.models.add(model);
	}

	public Collection<MazeModel> getModels() {
		return new ArrayList<>(models);
	}

	public <T extends MazeModel> T getModel(Class<T> modelClazz) {
		for (MazeModel model : this.models) {
			if (modelClazz.isAssignableFrom(model.getClass())) {
				return (T) model;
			}
		}
		return null;
	}

	public MazeModel getModel(MazeType type) {
		for (MazeModel model : this.models) {
			if (model.getType().equals(type)) {
				return model;
			}
		}
		return null;
	}

}
