package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Coordinates {
	@NotNull
	private int x;
	
	@NotNull
	private int y;
	
	public Coordinates (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return this.x; }
	
	public int getY() { return this.y; }
	
	public void incrementX() { this.x++; }
	
	public void incrementY() { this.y++; }
	
	public void decrementX() { this.x--; }
	
	public void decrementY() { this.y--; }
}
