package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Character {
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

    public Character(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    // Move Cardinal Direction
}
