package dev.noire.tilegame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.gfx.Assets;
import dev.noire.tilegame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		bounds.x = 10;
		bounds.y = (int)(height/1.5f);
		bounds.width = width-(bounds.x*2);
		bounds.height = (int)(height-(height/1.5f));
	}
	
	public void tick() {}
	
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.RED);
		g.drawRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()), (int)(y+bounds.y-handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

}
