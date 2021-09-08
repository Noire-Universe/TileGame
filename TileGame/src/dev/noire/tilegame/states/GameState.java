package dev.noire.tilegame.states;

import java.awt.Graphics;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.entities.creatures.Player;
import dev.noire.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	
	private Player player;
	
	public GameState(Handler handler) {
		super(handler);
		
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
		player = new Player(handler, 100, 100);
	}
	
	public void tick() {
		
		world.tick();
		
		player.tick();
		
	}
	
	public void render(Graphics g) {
		
		world.render(g);
		
		player.render(g);
	}
	
}
