package game.frogger.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameStateControls extends BasicGameState {
	
	private Image background;

	public GameStateControls(){
		
	}
	
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		background = new Image("data/settings/ContBG.png");
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
	}

	public int getID() {
		return GameStates.Controls;
	}
}
