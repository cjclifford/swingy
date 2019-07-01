package za.co.wethinkcode;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.controller.IController;
import za.co.wethinkcode.controller.MenuController;
import za.co.wethinkcode.controller.SelectHeroController;
import za.co.wethinkcode.controller.CreateHeroController;
import za.co.wethinkcode.controller.GameController;

import java.util.Map;
import java.util.HashMap;

public class App {
	
    public static void main( String[] args ) {
    	RenderMode renderMode;
    	
    	if (args.length == 0) {
    		System.out.println("Proper usage is: java -jar swingy.jar [console|gui]");
    		return;
    	}
    	
    	switch (args[0].toUpperCase()) {
    	case "CONSOLE":
    		renderMode = RenderMode.CONSOLE;
    		break;
    	case "GUI":
    		renderMode = RenderMode.GUI;
    		break;
    	default:
    		return;
    	}
    	
    	Map<EController, IController> controllers = new HashMap<>();
    	EController currentController = EController.MAIN_MENU;
    	Game game = new Game(renderMode);
    	
    	MenuController menuController = new MenuController(game);
    	SelectHeroController selectHeroController = new SelectHeroController(game);
    	CreateHeroController createHeroController = new CreateHeroController(game);
    	GameController gameController = new GameController(game);
    	
    	controllers.put(EController.MAIN_MENU, menuController);
    	controllers.put(EController.SELECT_HERO, selectHeroController);
    	controllers.put(EController.CREATE_HERO, createHeroController);
    	controllers.put(EController.GAME, gameController);
    	
    	System.out.println("Welcome to Swingy!");
    	
    	while (currentController != EController.QUIT) {
    		currentController = controllers.get(currentController).run();
    	}
    	
    	System.out.println("Thank you for playing Swingy!");
    }
    
}