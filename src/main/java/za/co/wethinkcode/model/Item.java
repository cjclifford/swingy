package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public abstract class Item {
	
	@NotNull
	private String name;
	
	@NotNull
	private String id;
	
	@NotNull
	private int level;
	
	public Item(String name, String id, int level) {
		this.name = name;
		this.id = id;
		this.level = level;
	}
	
	public String getName() { return this.name; }
	
	public String getId() { return this.id; }
	
	public int getLevel() { return this.level; }

}
