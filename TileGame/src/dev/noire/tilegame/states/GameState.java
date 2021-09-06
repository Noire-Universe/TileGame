package dev.noire.tilegame.states;

import java.awt.Graphics;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.gfx.Assets;
import dev.noire.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		
		world = new World();
		handler.setWorld(world);
		
	}
	
	public void tick() {
		
		
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.grass, 0, 0, null);
		
	}
	
}
