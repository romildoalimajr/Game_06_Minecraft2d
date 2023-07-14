package net.kalangos.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity {

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		depth = 2;

	}

	public void render(Graphics g) {

	}

}
