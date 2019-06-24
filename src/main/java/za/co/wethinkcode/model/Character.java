package za.co.wethinkcode.model;

public class Character {
    @NotNull
    private int health;

    @NotNull
    private int attack;

    @NotNull
    private int defense;
    // Coordinates;

    public Character(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    // Move Cardinal Direction
}
