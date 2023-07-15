package net.kalangos.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.kalangos.main.Game;
import net.kalangos.world.Camera;
import net.kalangos.world.FloorTile;
import net.kalangos.world.Tile;
import net.kalangos.world.WallTile;
import net.kalangos.world.World;

public class Enemy extends Entity {

	public boolean right = true, left = false;

	public double life = Entity.rand.nextInt(200-60)+60;
	public double maxLife = life;

	public BufferedImage sprite1, sprite2;

	public int dir = 1;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite1,
			BufferedImage sprite2) {
		super(x, y, width, height, speed, null);
		// TODO Auto-generated constructor stub
		this.sprite1 = sprite1;
		this.sprite2 = sprite2;
	}

	public void tick() {
		if (World.isFree((int) x, (int) (y + 1))) {
			y += 1;
		}
		if (dir == 1) {
			if (World.isFree((int) (x + speed), (int) y)) {
				x += speed;
			} else {
				int xnext = (int) ((x + speed) / 16) + 1;
				int ynext = (int) (y / 16);

				if (World.tiles[xnext + ynext * World.WIDTH] instanceof WallTile && World.tiles[xnext + ynext * World.WIDTH].solid == false) {
					World.tiles[xnext + ynext * World.WIDTH] = new FloorTile(xnext * 16, ynext * 16, Tile.TILE_AR);
				}
				dir = -1;
				left = true;
				right = false;
			}
		} else if (dir == -1) {
			if (World.isFree((int) (x - speed), (int) y)) {
				x -= speed;
			} else {
				int xnext = (int) ((x - speed) / 16);
				int ynext = (int) (y / 16);

				if (World.tiles[xnext + ynext * World.WIDTH] instanceof WallTile && World.tiles[xnext + ynext * World.WIDTH].solid == false) {
					World.tiles[xnext + ynext * World.WIDTH] = new FloorTile(xnext * 16, ynext * 16, Tile.TILE_AR);
				}
				dir = 1;
				right = true;
				left = false;
			}
		}
		
		if(life == 0)
		{
			Game.entities.remove(this);
			return;
		}
	}

	public void render(Graphics g) {
		if (right) {
			sprite = sprite1;
		} else if (left) {
			sprite = sprite2;
		}
		super.render(g);
		
		int curLife = (int)(life / maxLife) * 10;
		g.setColor(Color.red);
		g.fillRect(this.getX() - 4 - Camera.x, this.getY() - 8 - Camera .y, 20, 5);
		g.setColor(Color.green);
		g.fillRect(this.getX() - 4 - Camera.x, this.getY() - 8 - Camera.y, curLife, 5);
	}

}
