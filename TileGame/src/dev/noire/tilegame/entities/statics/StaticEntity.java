package dev.noire.tilegame.entities.statics;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}	

}
