package dev.noire.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.noire.tilegame.display.Display;

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
	
	
	//input:
	
	
	//game camera:
	
	
	//handler:
	
	
	//constructor:
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		
	}
	
	//game loop:
	public void tick() {
		
		
		
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
