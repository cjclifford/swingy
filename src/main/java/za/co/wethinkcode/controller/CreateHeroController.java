package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.Controller;
import za.co.wethinkcode.view.ConsoleCreateHeroView;

public class CreateHeroController implements IController {
	
	private Game game;
	
	private ConsoleCreateHeroView consoleCreateHeroView;
	
	public CreateHeroController(Game game) {
		this.game = game;
		this.consoleCreateHeroView = new ConsoleCreateHeroView();
	}
	
	@Override
	public Controller run() {
		Hero hero = this.consoleCreateHeroView.onCreateHero();
		
		this.game.world = new World(hero);
		return Controller.GAME;
	}

}
