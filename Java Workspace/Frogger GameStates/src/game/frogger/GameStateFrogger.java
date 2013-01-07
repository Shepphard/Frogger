package game.frogger;

import game.frogger.gamestates.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameStateFrogger extends StateBasedGame {

	public GameStateFrogger() {
		super("Frogger 1.0");
	}

	public void initStatesList(GameContainer container) throws SlickException {
		//Einlesen der einzelnen GameStates
		addState(new GameStateMenu());
		addState(new GameStatePlaying());
		addState(new GameStateGameOver());
		addState(new GameStateWon());
		addState(new GameStateSelector());
		addState(new GameStateControls());
		addState(new GameStateCredits());
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new GameStateFrogger());
		app.setDisplayMode(640, 800, false);
		app.setShowFPS(false);
	    app.start();
	}
}
