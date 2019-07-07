package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.model.EInput;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.Character;
import za.co.wethinkcode.model.Enemy;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.ERenderMode;
import za.co.wethinkcode.view.ConsoleGameView;

import java.util.Random;

public class GameController implements IController {
	
	private Game game;
	
	private ConsoleGameView consoleGameView;
	
	public GameController(Game game) {
		this.game = game;
		this.consoleGameView = new ConsoleGameView(this.game);
	}
	
	public boolean simulateFight(Enemy enemy, int x, int y) {
		Hero hero = this.game.world.hero;
		
		this.consoleGameView.onFight(enemy);
		if (hero.getAttack() >= enemy.getAttack()) {
			int attack = hero.getDefense() - enemy.getAttack();
			
			if (attack < 0) attack = 0;
			int healthDamaged = hero.getEquippedArmour().getArmour() - attack;
			if (healthDamaged < 0)
				hero.setHealth(hero.getHealth() + healthDamaged);
			this.game.world.removeEnemy(enemy);
			this.consoleGameView.onDefeatEnemy(enemy);
			this.game.world.hero.coordinates.setX(x);
			this.game.world.hero.coordinates.setY(y);
			hero.gainXp((enemy.getAttack() + enemy.getDefense() + enemy.getHealth()) * 10);
			return true;
		} else {
			this.consoleGameView.onDeath(enemy);
			return false;
		}
		
	}
	
	public boolean initiateEncounter(Enemy enemy, int x, int y) {
		switch (this.consoleGameView.onEncounter(enemy)) {
		case FIGHT:
			return this.simulateFight(enemy, x, y);
		case RUN:
			switch (new Random().nextInt(2)) {
			case 0:
				this.consoleGameView.onRunSuccess();
				return true;
			case 1:
				this.consoleGameView.onRunFailure();
				return this.simulateFight(enemy, x, y);
			}
		}
		return false;
	}
	
	public EController update(EInput input) {
		World world = this.game.world;
		Hero hero = this.game.world.hero;
		Character character;
		
		int x = hero.coordinates.getX();
		int y = hero.coordinates.getY();
		
		switch (input) {
		case NORTH:
			if (y <= 0) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x, y - 1);
				if (character != null)
					System.out.println("Moving into space with " + character.getClass());
				if (character instanceof Enemy) {
					if (!this.initiateEncounter((Enemy)character, x, y - 1))
						return EController.QUIT;
				} else {
					hero.coordinates.decrementY();
					world.updateBoard();
				}
			}
			world.moveEnemies();
			world.updateBoard();
			return EController.GAME;
		case SOUTH:
			if (y >= world.getSize() - 1) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x, y + 1);
				if (character instanceof Enemy) {
					if (!this.initiateEncounter((Enemy)character, x, y + 1))
						return EController.QUIT;
				} else {
					hero.coordinates.incrementY();
					world.updateBoard();
				}
			}
			world.moveEnemies();
			world.updateBoard();
			return EController.GAME;
		case WEST:
			if (x <= 0) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x - 1, y);
				if (character instanceof Enemy) {
					if (!this.initiateEncounter((Enemy)character, x - 1, y))
						return EController.QUIT;
				} else {
					hero.coordinates.decrementX();
					world.updateBoard();
				}
			}
			world.moveEnemies();
			world.updateBoard();
			return EController.GAME;
		case EAST:
			if (hero.coordinates.getX() >= world.getSize() - 1) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x + 1, y);
				if (character instanceof Enemy) {
					if (!this.initiateEncounter((Enemy)character, x + 1, y))
						return EController.QUIT;
				} else {
					hero.coordinates.incrementX();
					world.updateBoard();
				}
			}
			world.moveEnemies();
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
