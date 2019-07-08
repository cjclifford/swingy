package za.co.wethinkcode.model;

public class Enemy extends Character {
	
	private Item loot;
	
	public boolean isChasing;
	
	public Enemy(EnemyBuilder builder) {
		super(
				builder.name,
				builder.health,
				builder.attack,
				builder.defense
		);
		
		this.coordinates = builder.coordinates;
		this.loot = builder.loot;
		this.isChasing = false;
	}
	
	public boolean hasLoot() { return this.loot != null; }
	
	public Item dropLoot() { return this.loot; }
	
	public void setLoot(Item loot) {
		if (loot instanceof Weapon || loot instanceof Armour || loot instanceof Helmet)
			this.loot = loot;
	}
	
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
		
		public Enemy build() {
			return new Enemy(this);
		}
	}
}
