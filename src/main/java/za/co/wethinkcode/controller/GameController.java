package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.model.EInput;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.Character;
import za.co.wethinkcode.model.Enemy;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.view.ConsoleGameView;

import java.util.Random;

public class GameController implements IController {
	
	private Game game;
	
	private ConsoleGameView consoleGameView;
	
	public GameController(Game game) {
		this.game = game;
		this.consoleGameView = new ConsoleGameView(this.game);
	}
	
	public boolean simulateFight(Enemy enemy) {
		Hero hero = this.game.world.hero;
		
		this.consoleGameView.onFight(enemy);
		if (hero.getAttack() > enemy.getAttack()) {
			int attack = hero.getTotalDefense() - enemy.getAttack();
			
			if (attack < 0) attack = 0;
			hero.setHealth(hero.getTotalHealth() - attack);
			this.consoleGameView.onDefeatEnemy(enemy);
			return true;
		} else {
			this.consoleGameView.onDeath(enemy);
			return false;
		}
		
	}
	
	public boolean initiateEncounter(Enemy enemy) {
		switch (this.consoleGameView.onEncounter(enemy)) {
		case FIGHT:
			return true;
		case RUN:
			switch (new Random().nextInt(2)) {
			case 0:
				this.consoleGameView.onRunSuccess();
				return false;
			case 1:
				this.consoleGameView.onRunFailure();
				return false;
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
			world.moveEnemies();
			if (y <= 0) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x, y - 1);
				if (character instanceof Enemy) {
					if (this.initiateEncounter((Enemy)character)) {
						if (this.simulateFight((Enemy)character))
							hero.coordinates.decrementY();
						else {
							this.consoleGameView.onDeath((Enemy)character);
							return EController.QUIT;
						}
					}
				} else {
					hero.coordinates.decrementY();
				}
			}
			world.updateBoard();
			return EController.GAME;
		case SOUTH:
			world.moveEnemies();
			if (y >= world.getSize() - 1) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x, y + 1);
				if (character instanceof Enemy) {
					if (this.initiateEncounter((Enemy)character)) {
						if (this.simulateFight((Enemy)character))
							hero.coordinates.incrementY();
						else {
							this.consoleGameView.onDeath((Enemy)character);
							return EController.QUIT;
						}
					}
				} else {
					hero.coordinates.incrementY();
				}
			}
			world.updateBoard();
			return EController.GAME;
		case WEST:
			world.moveEnemies();
			if (x <= 0) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x - 1, y);
				if (character instanceof Enemy) {
					if (this.initiateEncounter((Enemy)character)) {
						if (this.simulateFight((Enemy)character))
							hero.coordinates.decrementX();
						else {
							this.consoleGameView.onDeath((Enemy)character);
							return EController.QUIT;
						}
					}
				} else {
					hero.coordinates.decrementX();
				}
			}
			world.updateBoard();
			return EController.GAME;
		case EAST:
			world.moveEnemies();
			if (hero.coordinates.getX() >= world.getSize() - 1) {
				this.consoleGameView.onReachBoundary();
				world.generateWorld();
			} else {
				character = this.game.world.boardAt(x + 1, y);
				if (character instanceof Enemy) {
					if (this.initiateEncounter((Enemy)character)) {
						if (this.simulateFight((Enemy)character))
							hero.coordinates.incrementY();
						else {
							this.consoleGameView.onDeath((Enemy)character);
							return EController.QUIT;
						}
					}
				} else {
					hero.coordinates.incrementX();
				}
			}
			world.updateBoard();
			return EController.GAME;
		case QUIT:
			System.out.println("wat");
			return EController.QUIT;
		}
		System.out.println("wtf was that?");
		return EController.QUIT;
	}
	
	@Override
	public EController run() {
		this.consoleGameView.onRenderState();
		return this.update(this.consoleGameView.onHandleInput());
	}
	
}
