package game.frogger.gamestates;

import game.frogger.inout.ReadWrite;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

@SuppressWarnings("unused")
public class GameStateWon extends BasicGameState {

	private Image background;
	
	public GameStateWon(){
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame state)
			throws SlickException {
		background = new Image("data/settings/WonBG.png");
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g)
			throws SlickException {
		background.draw(0,0);
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_A)){
			state.enterState(GameStates.MenuState);
		}
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			System.exit(0);
		}
		
	}

	@Override
	public int getID() {
		return GameStates.Won;
	}
}
