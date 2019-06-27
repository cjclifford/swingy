package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Controller;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.RenderMode;

import javax.validation.constraints.NotNull;

public class GameController implements IController{
	
	private Game game;
	
	// TODO: implement swing renderer
	// private SwingRenderer swingRenderer;
	
	public GameController(Game game) {
		this.game = game;
	}
	
	public void handleConsoleInput() {
	}
	
	// handle swing input
	// public void handleSwingInput(Event e) {}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	@Override
	public Controller run() {
		return Controller.QUIT;
	}
	
}
