package za.co.wethinkcode;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.controller.IController;
import za.co.wethinkcode.controller.MenuController;
import za.co.wethinkcode.controller.SelectHeroController;
import za.co.wethinkcode.controller.CreateHeroController;
import za.co.wethinkcode.controller.GameController;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;;

public class Terminally {
	
    public static void main( String[] args ) {
    	
    	List<Integer> myList = new ArrayList<>();
    	
    	myList.forEach(new Consumer<Integer>() {
    		public void accept(Integer i) {
    			System.out.println(i);
    		}
    	});
    	
    	if (args.length == 0) {
    		System.out.println("Proper usage is: java -jar swingy.jar [console|gui]");
    		return;
    	}
    	
    	Map<EController, IController> controllers = new HashMap<>();
    	EController currentController = EController.MAIN_MENU;
    	Game game = new Game();
    	
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
    		clearScreen();
    		currentController = controllers.get(currentController).run();
    	}
    	
    	File saveFile = new File("../../heroes.txt");
    	try {    		
    		BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
    		for (Hero hero : game.heroes) {
    			writer.write("");
    			writer.append(
    				String.format(
    					"%s,%s,%d,%d,%d,%d,%d,%s,%s,%s\n",
    					hero.getName(),
    					hero.getHeroClass(),
    					hero.getLevel(),
    					hero.getXp(),
    					hero.getHealth(),
    					hero.getAttack(),
    					hero.getDefense(),
    					hero.weapon != null ? hero.weapon.getId() : "NONE",
    					hero.armour != null ? hero.armour.getId() : "NONE",
    					hero.helmet != null ? hero.helmet.getId() : "NONE"
    				)
    			);
    		}
    		writer.close();
    	} catch (IOException e) {
    		System.out.println("Failed to open save file for writing");
    	}
    	
    	System.out.println("Thank you for playing Swingy!");
    }
    
    private static void clearScreen() {
    	System.out.print("\033[H\033[2J");
    	System.out.flush();
    }
}