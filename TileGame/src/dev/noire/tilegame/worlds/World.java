package dev.noire.tilegame.worlds;

import java.awt.Graphics;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.tiles.Tile;
import dev.noire.tilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height, xSpawn, ySpawn;
	private int[][] tiles;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		
		loadWorld(path);
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		xSpawn = Utils.parseInt(tokens[2]);
		ySpawn = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+(y*width))+4]);
			}
		}

	}
	
	public void tick() {
		
		
		
	}
	
	public Tile getTile(int x, int y) {
		if(x<0||y<0||x>=width||y>=height)
			return Tile.grassTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.dirtTile;
		return t;
	}
	
	public void render(Graphics g) {
		int xStart = 0;
		int xEnd = width;
		int yStart = 0;
		int yEnd = height;
		for(int y=yStart; y<yEnd; y++) {
			for(int x=xStart; x<xEnd; x++) {
				getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()),
										(int)(y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
}
