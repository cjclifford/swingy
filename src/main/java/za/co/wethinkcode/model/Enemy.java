package za.co.wethinkcode.model;

public class Enemy extends Character {
	
	private Item loot;
	
	public Enemy(EnemyBuilder builder) {
		super(
				builder.name,
				builder.health,
				builder.attack,
				builder.defense
		);
		
		this.coordinates = builder.coordinates;
		this.loot = builder.loot;
	}
	
	public Item dropLoot() { return this.loot; }
	
	public static class EnemyBuilder {

		private final String name;
		
		private int health;
		
		private int attack;
		
		private int defense;
		
		private Coordinates coordinates;
		
		private Item loot = null;
		
		public EnemyBuilder(String name) {
			this.name = name;
		}
		
		public EnemyBuilder health(int health) {
			this.health = health;
			return this;
		}
		
		public EnemyBuilder attack(int attack) {
			this.attack = attack;
			return this;
		}
		
		public EnemyBuilder defense(int defense) {
			this.defense = defense;
			return this;
		}
		
		public EnemyBuilder coordinates(int x, int y) {
			this.coordinates = new Coordinates(x, y);
			return this;
		}
		
		public EnemyBuilder loot(Item loot) {
			this.loot = loot;
			return this;
		}
		
		public Enemy build() {
			return new Enemy(this);
		}
	}
}
