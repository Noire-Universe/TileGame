package dev.noire.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//tiles
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile stoneTile = new StoneTile(2);
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	//class
	protected BufferedImage texture;
	protected int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {return false;}
	public int getId() {return id;}
}
