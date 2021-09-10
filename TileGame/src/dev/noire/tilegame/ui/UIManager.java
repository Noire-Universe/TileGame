package dev.noire.tilegame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.noire.tilegame.Handler;

public class UIManager {

	private Handler handler;
	private ArrayList<UIObject>objects;
	
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	public void tick() {
		for(UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g) {
		for(UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMoved(MouseEvent e) {
		for(UIObject o : objects)
			o.onMouseMoved(e);
	}
	
	public void onMouseReleased(MouseEvent e) {
		for(UIObject o : objects)
			o.onMouseReleased(e);
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}

	//GETTERS & SETTERS:
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}
}
