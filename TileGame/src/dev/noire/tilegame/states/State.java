package dev.noire.tilegame.states;

import java.awt.Graphics;

import dev.noire.tilegame.Handler;

public abstract class State {

	//state manager:
	private static State currentState = null;
	public static State getState() {return currentState;}
	public static void setState(State state) {currentState = state;}
	
	
	//class:
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
