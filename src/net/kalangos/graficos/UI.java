package net.kalangos.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import net.kalangos.main.Game;

public class UI {
	
	public int seconds = 0;
	public int minutes = 0;
	public int frames = 0;
	
	public void tick() {
		frames++;
		if(frames == 60) {
			//passou um segundo
			frames = 0;
			seconds++;
			if(seconds == 60) {
				seconds = 0;
				minutes++;
			}
			
		}
	}

	public void render(Graphics g) {
		int curLife = (int)(Game.player.life / 100) + 200;
		
		g.setColor(Color.RED);
		g.fillRect(Game.WIDTH*Game.SCALE - 220, 10, curLife, 30);
		g.setColor(Color.GREEN);
		g.fillRect(Game.WIDTH*Game.SCALE - 220, 10, curLife, 30);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 23));
		g.drawString((int)(Game.player.life) + "/" + "100", Game.WIDTH * Game.SCALE - 160, 35);
		
		String formatTime = "";
		if(minutes < 10) {
			formatTime+= "0" + minutes + ":";
		}else {
			formatTime += minutes + ":";
		}
		
		if(seconds < 10) {
			formatTime+= "0" + seconds;
		}else {
			formatTime += seconds;
		}
		
		g.setFont(new Font("arial", Font.BOLD, 23));
		g.drawString(formatTime, 14, 30);
	}
	
}
