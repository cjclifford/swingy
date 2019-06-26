package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.Cardinal;

public class GameController {
	
	private World world;
	
	public GameController(World world) { this.world = world; }
	
	// onMove()
	public void onMove(Cardinal cardinal) {
		switch (cardinal) {
		case NORTH:
			if (this.world.hero.coordinates.getY() > 0)
				this.world.hero.coordinates.decrementY();
			break;
		case SOUTH:
			if (this.world.hero.coordinates.getY() < this.world.getSize() - 1)
				this.world.hero.coordinates.incrementY();
			break;
		case WEST:
			if (this.world.hero.coordinates.getX() > 0)
				this.world.hero.coordinates.decrementX();
			break;
		case EAST:
			if (this.world.hero.coordinates.getX() < this.world.getSize() - 1)
				this.world.hero.coordinates.incrementX();
			break;
		}
	}
	// onFight()
	// onRun()

}
