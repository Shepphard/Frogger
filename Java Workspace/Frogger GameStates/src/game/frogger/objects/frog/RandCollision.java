package game.frogger.objects.frog;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

@SuppressWarnings("unused")
public class RandCollision extends Frog {
	
	private float containerWidth;
	private float containerHeight;
	
	public RandCollision(float posX, float posY, int frognumber, int lives) {
		super(posX, posY, 0, 0, frognumber, lives);
	}

	public void init(GameContainer container) throws SlickException {
		super.init(container);
		
		containerWidth = container.getWidth();
		containerHeight = container.getHeight();

	}

	public void update(GameContainer container, int delta) throws SlickException {
		
		float leftBorder = img.getWidth()/2;
		float rightBorder = containerWidth-img.getWidth()/2;
		float upBorder = img.getHeight()/2;
		float downBorder = containerHeight-img.getHeight()/2;
		
		if (posX < leftBorder){
			spdX = -Math.abs(spdX);
			posX = leftBorder;
		}else if (posX > rightBorder){
			spdX = Math.abs(spdX);
			posX = rightBorder;
		}
		if (posY < upBorder){
			spdY = -Math.abs(spdY);
			posY = upBorder;
		}else if (posY > downBorder){
			spdY = Math.abs(spdY);
			posY = downBorder;
		}
		
		super.update(container, delta);
		
	}
}
