package game.frogger.objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import game.frogger.objects.LaneSettings;

public class Enemies extends GameObjects{
	
	private int lane;
	private boolean didrotate = false;
	
	private LaneSettings spd = new LaneSettings("speed");
	
	public Enemies(float posX, float posY, float lane, String laneNum) {
		super(posX, posY+38+lane*75, 0, 0, laneNum, false);
		this.lane = (int)(lane);
	}

	public void init(GameContainer container) throws SlickException {
		super.init(container);
		
		//Liest die Geschw. aus der datei speed.frog aus
		spdX = spd.getData(lane);			
	}

	public void update(GameContainer container, int delta) throws SlickException {
		float _delta = delta/1000.0F;
		
		if(spdX < 0 && didrotate == false){
			img = img.getFlippedCopy(true, false); // horizontales Spiegeln der Bilder fŸr Ausrichtung.
			didrotate = true;
		}
		
		posX += spdX*_delta;
		
		//Falls Bild aus dem Bild fŠllt taucht es auf der anderen seite wieder auf. (unverzŸglich)
		if(posX >= container.getWidth()+img.getWidth()/2){
			posX = -img.getWidth()/2;
		}else if(posX <= -img.getWidth()/2){
			posX = container.getWidth()+img.getWidth()/2;
		}
		
		super.update(container, delta);
			
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		
		super.render(container, g);
				
	}
	

}
