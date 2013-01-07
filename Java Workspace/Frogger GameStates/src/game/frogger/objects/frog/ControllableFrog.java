package game.frogger.objects.frog;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

@SuppressWarnings("unused")
public class ControllableFrog extends RandCollision{
	
	public ControllableFrog(int posX, int posY, int frognumber, int lives) {
		super(posX, posY, frognumber, lives);
	}

	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(posX != startPosX || posY != startPosY){
			this.setVulnerable(true);
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			spdX = -150;
			img.setRotation(-90);
			imgWater.setRotation(-90);
			collisionShape = new Rectangle(posX, posY, img.getHeight(), img.getWidth());
			
		}else if(input.isKeyDown(Input.KEY_RIGHT)){
			spdX = 150;
				img.setRotation(90);
				imgWater.setRotation(90);
				collisionShape = new Rectangle(posX, posY, img.getHeight(), img.getWidth());
		}else{
			spdX = 0;
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			spdY = 150;
				img.setRotation(-180);
				imgWater.setRotation(-180);
				collisionShape = new Rectangle(posX, posY, img.getWidth(), img.getHeight());
		}else if(input.isKeyDown(Input.KEY_UP)){
			spdY = -150;
			img.setRotation(0);
			imgWater.setRotation(0);
			collisionShape = new Rectangle(posX, posY, img.getWidth(), img.getHeight());
		}else{
			spdY = 0;	
		}
		
		if(input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_RIGHT)){
			img.setRotation(45);
			imgWater.setRotation(45);
			collisionShape = new Rectangle(posX, posY, img.getWidth(), img.getWidth());
		}else if(input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_LEFT)){
			img.setRotation(-45);
			imgWater.setRotation(-45);
			collisionShape = new Rectangle(posX, posY, img.getWidth(), img.getWidth());
		}else if(input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_RIGHT)){
			img.setRotation(135);
			imgWater.setRotation(135);
			collisionShape = new Rectangle(posX, posY, img.getWidth(), img.getWidth());
		}else if(input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_LEFT)){
			img.setRotation(-135);
			imgWater.setRotation(-135);
			collisionShape = new Rectangle(posX, posY, img.getWidth(), img.getWidth());
		}
		
		super.update(container, delta);
	}

}
