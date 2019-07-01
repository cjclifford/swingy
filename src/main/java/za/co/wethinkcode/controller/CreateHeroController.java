package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.Game.EArmour;
import za.co.wethinkcode.model.Game.EHelmet;
import za.co.wethinkcode.model.Game.EWeapon;

import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.model.HeroClass;
import za.co.wethinkcode.view.ConsoleCreateHeroView;

public class CreateHeroController implements IController {
	
	private Game game;
	
	private ConsoleCreateHeroView consoleCreateHeroView;
	
	public CreateHeroController(Game game) {
		this.game = game;
		this.consoleCreateHeroView = new ConsoleCreateHeroView(this.game);
	}
	
	@Override
	public EController run() {
		
		Hero hero = this.consoleCreateHeroView.onCreateHero();
		
		this.game.world = new World(hero);
		return EController.GAME;
	}

}
