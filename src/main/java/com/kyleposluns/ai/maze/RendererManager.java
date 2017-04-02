package com.kyleposluns.ai.maze;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class RendererManager {

	private Collection<MazeRenderer> renderers;

	public RendererManager() {
		this.renderers = new HashSet<>();
	}

	public void registerRenderer(MazeRenderer renderer) {
		renderers.removeIf(r -> renderer.getType().equals(r.getType()));
		this.renderers.add(renderer);
	}

	public Collection<MazeRenderer> getRenderers() {
		return new ArrayList<>(this.renderers);
	}

	public <T extends MazeRenderer> T getRenderer(Class<T> rendererClazz) {
		for (MazeRenderer renderer : this.renderers) {
			if (rendererClazz.isAssignableFrom(renderer.getClass())) {
				return (T) renderer;
			}
		}
		return null;
	}

	public MazeRenderer getRenderer(MazeType type) {
		for (MazeRenderer renderer : this.renderers) {
			if (renderer.getType().equals(type)) {
				return renderer;
			}
		}
		return null;
	}


}
