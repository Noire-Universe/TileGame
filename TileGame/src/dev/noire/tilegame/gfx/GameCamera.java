package dev.noire.tilegame.gfx;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.entities.Entity;
import dev.noire.tilegame.tiles.Tile;

public class GameCamera {

	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	private void checkBlankSpace() {
		if(xOffset < 0)
			xOffset = 0;
		if(xOffset > handler.getWorld().getWidth() *Tile.TILEWIDTH+handler.getWidth())
			xOffset = handler.getWorld().getWidth() *Tile.TILEWIDTH+handler.getWidth();
		
		if(yOffset < 0)
			yOffset = 0;
		if(yOffset > handler.getWorld().getHeight() *Tile.TILEHEIGHT+handler.getHeight())
			yOffset = handler.getWorld().getHeight() *Tile.TILEHEIGHT+handler.getHeight();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() -handler.getWidth()/2+e.getWidth()/2;
		yOffset = e.getY() -handler.getHeight()/2+e.getHeight()/2;
		checkBlankSpace();
	}
	
	//GETTERS & SETTERS:
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}