package dev.noire.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.noire.tilegame.Handler;
import dev.noire.tilegame.gfx.Animation;
import dev.noire.tilegame.gfx.Assets;

public class Player extends Creature {

	private Animation playerUp, playerDown, playerLeft, playerRight;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		playerUp = new Animation(500, Assets.player_up);
		playerDown = new Animation(500, Assets.player_down);
		playerLeft = new Animation(500, Assets.player_left);
		playerRight = new Animation(500, Assets.player_right);
		
		bounds.x = 23;
		bounds.y = 32;
		bounds.width = 36;
		bounds.height = 24;
		
	}
	
	public void tick() {
		move();
		getInput();
		handler.getGameCamera().centerOnEntity(this);
		playerUp.tick();
		playerDown.tick();
		playerLeft.tick();
		playerRight.tick();
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	public void render(Graphics g) {
		g.drawImage(renderFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.RED);
		
	}
	
	public BufferedImage renderFrame() {
		if(yMove < 0)return playerUp.getCurrentFrame();
		else if(yMove > 0)return playerDown.getCurrentFrame();
		else if(xMove < 0)return playerLeft.getCurrentFrame();
		else if(xMove > 0)return playerRight.getCurrentFrame();
		else return Assets.player;
	}
}
