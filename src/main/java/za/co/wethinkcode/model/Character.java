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
    private Coordinates coordinates;

    public Character(String name, int health, int attack, int defense, Coordinates coordinates) {
    	this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.coordinates = coordinates;
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
}
