package game.frogger.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameStateGameOver extends BasicGameState {
	
	private Image background;

	public GameStateGameOver(){
		
	}
	
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		background = new Image("data/settings/LostBG.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		background.draw(0,0);	
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_A)){
			state.enterState(GameStates.MenuState);
		}		
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			System.exit(0);
		}
	}

	public int getID() {
		return GameStates.GameOver;
	}
}
