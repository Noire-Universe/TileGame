package dev.noire.tilegame;

import dev.noire.tilegame.gfx.GameCamera;
import dev.noire.tilegame.input.KeyManager;
import dev.noire.tilegame.input.MouseManager;
import dev.noire.tilegame.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
		
	}

	//input
	public KeyManager getKeyManager() {return game.getKeyManager();}
	public MouseManager getMouseManager() {return game.getMouseManager();}
	
	//camera
	public GameCamera getGameCamera() {return game.getGameCamera();}
	
	public int getWidth() {return game.getWidth();}
	public int getHeight() {return game.getHeight();}
	
	//GETTERS & SETTERS:
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
