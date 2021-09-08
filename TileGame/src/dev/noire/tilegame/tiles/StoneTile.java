package dev.noire.tilegame.tiles;

import dev.noire.tilegame.gfx.Assets;

public class StoneTile extends Tile {

	public StoneTile(int id) {
		super(Assets.stone, id);
	}
	
	public boolean isSolid() {return true;}

}
