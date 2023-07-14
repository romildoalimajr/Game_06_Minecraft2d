package net.kalangos.main;

import java.awt.Color;
import java.awt.Graphics;

import net.kalangos.world.Tile;

public class Inventory {

	public int inventoryBoxSize = 50;

	public String[] items = { "grama", "terra", "neve", "areia", "", "" };

	public int initialPosition = (Game.WIDTH * Game.SCALE) / 2 - (items.length * inventoryBoxSize) / 2;

	public void tick() {

	}

	public void render(Graphics g) {
		for (int i = 0; i < items.length; i++) {

			g.setColor(Color.gray);
			g.fillRect(initialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize,
					inventoryBoxSize, inventoryBoxSize);
			g.setColor(Color.black);
			g.drawRect(initialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize,
					inventoryBoxSize, inventoryBoxSize);
			
			if(items[i] == "grama") {
				g.drawImage(Tile.TILE_GRAMA,initialPosition + (i * inventoryBoxSize) + 10, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 10,
						32, 32,null);
			}else if(items[i] == "terra") {
				g.drawImage(Tile.TILE_TERRA,initialPosition + (i * inventoryBoxSize) + 10, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 10,
						32, 32,null);
			}
		}
	}
}
