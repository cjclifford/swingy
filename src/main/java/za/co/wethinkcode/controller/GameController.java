package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.view.ConsoleGameView;

public class GameController implements IController{
	
	private Game game;
	
	private ConsoleGameView consoleGameView;
	
	// TODO: implement swing renderer
	// private SwingRenderer swingRenderer;
	
	public GameController(Game game) {
		this.game = game;
		this.consoleGameView = new ConsoleGameView(this.game);
	}
	
	public void handleInput() {
	
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	@Override
	public EController run() {
		return EController.QUIT;
	}
	
}
