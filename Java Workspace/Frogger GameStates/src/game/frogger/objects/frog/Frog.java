package game.frogger.objects.frog;

import game.frogger.objects.GameObjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

@SuppressWarnings("unused")
public class Frog extends GameObjects{
	
	private int frognumber;
	private int lives;
	protected float startPosX;
	protected float startPosY;
	private boolean vulnerable = true;
	
	//Konstruktor
	public Frog(float posX, float posY, float spdX, float spdY, int frognumber, int lives){
		//Ruft GameObjects Konstruktor auf
		super(posX, posY, spdX, spdY, "hopper", true);
		this.startPosX = posX;
		this.startPosY = posY;
		this.frognumber = frognumber;
		this.lives = lives;
	}
	
	public void reset(){
		posX = startPosX;
		posY = startPosY;
	}
	
	public void totalReset(){
		reset();
		this.frognumber = 0;
		this.lives = 3;
	}
	
	public void setVulnerable(boolean vul){
		this.vulnerable = vul;
	}
	
	public boolean getVulnerable(){
		return this.vulnerable;
	}
	
	public void reduceLive(int i){ // reduziere live um i einheiten.
		if(this.vulnerable == true)
			lives -= i;
	}
	
	public int getLive(){
		return lives;
	}
	
	public void upFrognum(int i){ // setze frognum i einheiten hšher.
		frognumber += i;
	}
	
	public int getFrognum(){
		return frognumber;
	}
	
	public void init(GameContainer container) throws SlickException {
		super.init(container);			
	}

	public void update(GameContainer container, int delta) throws SlickException {
		float _delta = delta/1000.0F;

		posX += spdX*_delta;
		posY += spdY*_delta;

		super.update(container, delta);
			
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {		
		super.render(container,g);
		
	}
}
