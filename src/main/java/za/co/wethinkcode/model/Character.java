package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public abstract class Character {
	@NotNull
	private String name;
	
    @NotNull
    private int health;

    @NotNull
    private int attack;

    @NotNull
    private int defense;
    
    @NotNull
    private Coordinates coordinates;

    public Character(String name, int health, int attack, int defense, int x, int y) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.coordinates = new Coordinates(x, y);
    }
    
    public String getName() { return this.name; }
    
    public int getHealth() { return this.health; }
    
    public int getAttack() { return this.attack; }
    
    public int getDefense() { return this.defense; }
}
