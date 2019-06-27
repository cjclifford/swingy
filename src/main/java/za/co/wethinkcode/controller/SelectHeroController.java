package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Controller;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.view.ConsoleSelectHeroView;

public class SelectHeroController implements IController {
	
	private Game game;
	
	private ConsoleSelectHeroView consoleSelectHeroView;
	
	public SelectHeroController(Game game) {
		this.game = game;
		this.consoleSelectHeroView = new ConsoleSelectHeroView(this.game);
	}
	
	@Override
	public Controller run() {
		Hero hero = this.consoleSelectHeroView.onSelectHero();
		if (hero == null)
			return Controller.MAIN_MENU;
		this.game.world = new World(hero);
		return Controller.GAME;
	}

}
