package game.frogger.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import game.frogger.inout.ReadWrite;
import game.frogger.objects.*;
import game.frogger.objects.frog.*;

public class GameStatePlaying extends BasicGameState {
	
	private ReadWrite set = new ReadWrite("set");
	
	private boolean pause = false;
	
	private Image background;
	private Image lifeFrog;
	
	private Ponds pondContainer;
	private EnemyContainer leContainer;
	
	private Frog frog;

	public GameStatePlaying(){
	}
	
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		frog = new ControllableFrog(container.getWidth()/2, container.getHeight()-10, 0, 3);
		pondContainer = new Ponds(frog);
		leContainer = new EnemyContainer(1, 9, frog);

		background = new Image("data/sets/set"+ set.read(false) +"/background.png");
		lifeFrog = new Image("data/sets/set"+set.read(false)+"/hopper.png");
		
		frog.init(container);
		pondContainer.init(container);
		leContainer.init(container);
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		background.draw(0,0,1);

		frog.render(container, g);
		pondContainer.render(container, g);
		leContainer.render(container, g);
		
		if(pause){
			g.drawString("PAUSE", 320, 400);
		}
		// Anzeigen der kleinen Lebensfr�sche
		for(int i = 1;i<=frog.getLive();i++){
			lifeFrog.draw(10+(i-1)*20,770,0.6F);
		}	
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		pondContainer.update(container, delta);
		leContainer.update(container, delta);
		frog.update(container, delta);
		
		if(frog.getLive()<=0){
			frog.totalReset();
			pondContainer.initialisation(container, true);
			state.enterState(GameStates.GameOver);
		}
		if(frog.getFrognum()==5){
			frog.totalReset();
			pondContainer.initialisation(container, true);
			state.enterState(GameStates.Won);
		}
		
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_SPACE)){
			if(pause == false){
				container.pause();
				pause = true;
			}else{
				container.resume();
				pause = false;
			}
		}
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			System.exit(0);
		}
	}

	
	@Override
	public int getID() {
		return GameStates.PlayingState;
	}

	
}
