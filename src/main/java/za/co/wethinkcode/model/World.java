package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class World {
	
	enum Entity {
		NONE,
		HERO,
		ENEMY
	}
	
	@NotNull
	private int size;
	
	private ArrayList<Enemy> enemies;
	
	private Entity[][] board;
	
	private Enemy.EnemyBuilder enemyBuilder;
	
	public World(int level) {
		this.enemies = new ArrayList<Enemy>();
		this.generateWorld(level);
	}
	
	public int getSize() { return this.size; }
	
	public void printBoard() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				System.out.print(this.board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void generateWorld(int level) {
		
		this.size = level * 5 + 10 - (level % 2);
		
		this.board = new Entity[this.size][this.size];
		
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.board[i][j] = Entity.NONE;
			}
		}
		
		this.enemyBuilder = new Enemy.EnemyBuilder("EnemyName")
		.health(20)
		.attack(2)
		.defense(0);
		
		this.enemies.clear();
		
		int enemyCount = (int)(this.size * 0.01);
		
		for (int i = 0; i < enemyCount; i++) {
			this.enemies.add(enemyBuilder.build());
		}
	}

}
