package net.kalangos.main;

import java.awt.Color;
import java.awt.Graphics;

import net.kalangos.world.Tile;

public class Inventory {

	public int selected = 0;
	public boolean isPressed = false;

	public int mouseX, mouseY;

	public boolean isPlaceItem= false;
	public int inventoryBoxSize = 45;

	public String[] items = { "grama", "terra", "neve", "areia", "ar", "" };

	public int initialPosition = (Game.WIDTH * Game.SCALE) / 2 - (items.length * inventoryBoxSize) / 2;

	public void tick() {
		if (isPressed) {
			isPressed = false;
			if (mouseX >= initialPosition && mouseX < initialPosition + (inventoryBoxSize * items.length)) {
				if (mouseY >= Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1
						&& mouseY < Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1 + inventoryBoxSize) {
					selected = (int) ((mouseX - initialPosition) / inventoryBoxSize);
				}
			}
		}

	}

	public void render(Graphics g) {
		for (int i = 0; i < items.length; i++) {

			g.setColor(Color.gray);
			g.fillRect(initialPosition + (i * inventoryBoxSize) + 1, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 1,
					inventoryBoxSize, inventoryBoxSize);
			g.setColor(Color.black);
			g.drawRect(initialPosition + (i * inventoryBoxSize) + 1, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 1,
					inventoryBoxSize, inventoryBoxSize);

			if (items[i] == "grama") {
				g.drawImage(Tile.TILE_GRAMA, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			} else if (items[i] == "terra") {
				g.drawImage(Tile.TILE_TERRA, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}else if(items[i] == "ar") {
				g.drawImage(Tile.TILE_AR, initialPosition + (i * inventoryBoxSize) + 7,
						Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}

			if (selected == i) {
				g.setColor(Color.red);
				g.drawRect(initialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1,
						inventoryBoxSize, inventoryBoxSize);
			}
		}
	}
}
