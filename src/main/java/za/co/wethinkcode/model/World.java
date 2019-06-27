package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class World {
	
	@NotNull
	private int size;
	
	private ArrayList<Enemy> enemies;
	
	@NotNull
	private Object[][] board;
	
	private Enemy.EnemyBuilder enemyBuilder;
	
	public Hero hero;
	
	private Random random;
	
	public World(Hero hero) {
		this.hero = hero;
		this.enemies = new ArrayList<Enemy>();
		this.random = new Random();
		this.generateWorld(hero.getLevel());
	}
	
	public int getSize() { return this.size; }
	
	// for testing only
	public void printBoard() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.board[i][j] == null)
					System.out.print(".");
				else if (this.board[i][j] instanceof Hero)
					System.out.print("H");
				else if (this.board[i][j] instanceof Enemy)
					System.out.print("E");
			}
			System.out.println();
		}
	}
	
	public void generateWorld(int level) {
		
		// calculate size of map from hero level
		this.size = (level - 1) * 5 + 10 - (level % 2);
		
		// set player in the center of the board
		int halfSize = (int)Math.ceil(this.size / 2);
		this.hero.coordinates = new Coordinates(halfSize, halfSize);
		
		this.board = new Object[this.size][this.size];
		
		// initiate the board to be empty
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board[i][j] = null;
			}
		}
		
		// set the hero position on the board
		this.board[this.hero.coordinates.getX()][this.hero.coordinates.getY()] = this.hero;
		
		// TODO: give enemies different statistics based on level
		this.enemyBuilder = new Enemy.EnemyBuilder("EnemyName")
		.health(20)
		.attack(2)
		.defense(0);
		
		this.enemies.clear();
		
		// 6.6% of the map will be filled with enemies
		int enemyCount = (int)(this.size * this.size * 0.066);
		
		// create enemies at random locations on the map
		for (int i = 0; i < enemyCount; i++) {
			int randX = random.nextInt(this.size);
			int randY = random.nextInt(this.size);
			while (this.board[randX][randY] != null) {
				randX = random.nextInt(this.size);
				randY = random.nextInt(this.size);
			}
			Enemy enemy = this.enemyBuilder.coordinates(randX, randY).build();
			this.board[randX][randY] = enemy;
			this.enemies.add(enemy);
		}
	}

}
