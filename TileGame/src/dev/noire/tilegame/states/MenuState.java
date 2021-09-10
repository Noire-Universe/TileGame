package dev.noire.tilegame.states;

import java.awt.Graphics;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.gfx.Assets;
import dev.noire.tilegame.ui.ClickListener;
import dev.noire.tilegame.ui.UIImageButton;
import dev.noire.tilegame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(200, 100, 128, 64, Assets.start_btn, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		
	}
	
	public void tick() {
		
		uiManager.tick();
		
	}
	
	public void render(Graphics g) {
		
		uiManager.render(g);
		
	}
	
}
