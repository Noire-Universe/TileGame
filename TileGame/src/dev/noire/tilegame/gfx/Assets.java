package dev.noire.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage[] player_up, player_down, player_left, player_right, start_btn;
	public static BufferedImage player, dirt, grass, stone, tree;
	
	private static final int width = 32, height = 32;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		player_up = new BufferedImage[2];
		player_down = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		start_btn = new BufferedImage[2];
		
		player_up[0] = sheet.crop(0, height*2, width, height);
		player_up[1] = sheet.crop(width*2, height*2, width, height);
		
		player_down[0] = sheet.crop(0, 0, width, height);
		player_down[1] = sheet.crop(width*2, 0, width, height);
		
		player_left[0] = sheet.crop(0, height*3, width, height);
		player_left[1] = sheet.crop(width*2, height*3, width, height);
		
		player_right[0] = sheet.crop(0, height, width, height);
		player_right[1] = sheet.crop(width*2, height, width, height);
		
		start_btn[0] = sheet.crop(width*7, height*4, width*3, height);
		start_btn[1] = sheet.crop(width*7, height*5, width*3, height);
		
		player = sheet.crop(width, 0, width, height);
		dirt = sheet.crop(width*5, height*2, width, height);
		grass = sheet.crop(width*4, height*2, width, height);
		stone = sheet.crop(width*6, height*2, width, height);
		tree = sheet.crop(width*4, 0, width, height);
		
	}
	
}
