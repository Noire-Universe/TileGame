package dev.noire.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.noire.tilegame.display.Display;
import dev.noire.tilegame.gfx.Assets;
import dev.noire.tilegame.gfx.GameCamera;
import dev.noire.tilegame.input.KeyManager;
import dev.noire.tilegame.states.GameState;
import dev.noire.tilegame.states.MenuState;
import dev.noire.tilegame.states.State;

public class Game implements Runnable {

	//MAIN GAME CLASS:
	
	//fields:
	private Display display;
	
	private String title;
	private int width, height;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running;
	private Thread thread;
	
	//states:
	public State menuState;
	public State gameState;
	
	//input:
	private KeyManager keyManager;
	
	
	//game camera:
	private GameCamera gameCamera;
	
	//handler:
	private Handler handler;
	
	//constructor:
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	
		keyManager = new KeyManager();
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		menuState = new MenuState(handler);
		gameState = new GameState(handler);
		State.setState(menuState);
	}
	
	//game loop:
	public void tick() {
		
		keyManager.tick();
		
		if(State.getState()!=null)
			State.getState().tick();
		
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//start drawing...
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//...end drawing.
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		
		int ticks = 0;
		double timer = 0;
		int fps = 60;
		double framesPerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now-lastTime)/framesPerTick;
			timer += now-lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Frames & Ticks: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {return keyManager;}
	
	public GameCamera getGameCamera() {return gameCamera;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
