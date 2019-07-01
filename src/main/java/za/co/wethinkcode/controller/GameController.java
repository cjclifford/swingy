package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.model.EInput;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.Enemy;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.view.ConsoleGameView;

import java.util.Scanner;

public class GameController implements IController {
	
	private Game game;
	
	private ConsoleGameView consoleGameView;
	
	public GameController(Game game) {
		this.game = game;
		this.consoleGameView = new ConsoleGameView(this.game);
	}
	
	private boolean isEnemyEncounter(int x, int y) {
		return this.game.world.getBoard()[y][x] instanceof Enemy;
	}
	
	public EController update(EInput input) {
		World world = this.game.world;
		Hero hero = this.game.world.hero;
		
		int x = hero.coordinates.getX();
		int y = hero.coordinates.getY();
		
		switch (input) {
		case NORTH:
			world.moveEnemies();
			if (y <= 0) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				if (isEnemyEncounter(x, y - 1))
					return EController.GAME_ENCOUNTER;
				hero.coordinates.decrementY();
			}
			world.updateBoard();
			return EController.GAME;
		case SOUTH:
			world.moveEnemies();
			if (y >= world.getSize() - 1) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				if (isEnemyEncounter(x, y + 1))
					return EController.GAME_ENCOUNTER;
				hero.coordinates.incrementY();
			}
			world.updateBoard();
			return EController.GAME;
		case WEST:
			world.moveEnemies();
			if (x <= 0) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				if (isEnemyEncounter(x - 1, y))
					return EController.GAME_ENCOUNTER;
				hero.coordinates.decrementX();
			}
			world.updateBoard();
			return EController.GAME;
		case EAST:
			world.moveEnemies();
			if (hero.coordinates.getX() >= world.getSize() - 1) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				if (isEnemyEncounter(x + 1, y))
					return EController.GAME_ENCOUNTER;
				hero.coordinates.incrementX();
			}
			world.updateBoard();
			return EController.GAME;
		case QUIT:
			return EController.QUIT;
		}
		return EController.QUIT;
	}
	
	@Override
	public EController run() {
		this.consoleGameView.onRenderState();
		return this.update(this.consoleGameView.onHandleInput());
	}
	
}
