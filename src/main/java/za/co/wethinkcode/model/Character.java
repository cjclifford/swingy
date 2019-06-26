package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public abstract class Character {
	@NotNull
	private final String name;
	
    @NotNull
    private int health;

    @NotNull
    private int attack;

    @NotNull
    private int defense;
    
    @NotNull
    public Coordinates coordinates;

    public Character(String name, int health, int attack, int defense) {
    	this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }
    
    public Character(String name) {
    	this.name = name;
    	this.health = 100;
    	this.attack = 1;
    	this.defense = 0;
    }
    
    public String getName() { return this.name; }
    
    public int getHealth() { return this.health; }
    
    public int getAttack() { return this.attack; }
    
    public int getDefense() { return this.defense; }
    
    public void setHealth(int health) { this.health = health; }
    
    public void setAttack(int attack) { this.attack = attack; }
    
    public void setDefense(int defense) { this.defense = defense; }
    
}
