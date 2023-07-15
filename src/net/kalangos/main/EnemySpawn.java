package net.kalangos.main;

import net.kalangos.entities.Enemy;
import net.kalangos.entities.Entity;
import net.kalangos.world.World;

public class EnemySpawn {

	public int interval = 60*10;
	public int curTime = 0;
	
	
	public void tick() {
		curTime++;
		if(curTime == interval) {
			int xInitial = Entity.rand.nextInt((World.WIDTH/2) * 16 - 16 - 16) + 16;
			curTime = 0;
			Enemy enemy =  new Enemy(xInitial,16,16,16,1,Entity.ENEMY_RIGHT, Entity.ENEMY_LEFT);
			Game.entities.add(enemy);
		}
	}
}
