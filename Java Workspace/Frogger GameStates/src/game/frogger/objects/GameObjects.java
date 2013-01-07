package game.frogger.objects;

import game.frogger.inout.ReadWrite;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;

public class GameObjects {

	protected Image img;
	protected Image imgWater;
	protected String type;
	
	private ReadWrite set = new ReadWrite("set"); // wird sp�ter das set in welchem wir spielen auslesen.
	private ReadWrite water = new ReadWrite("data/sets/set"+set.read(false)+"/","water",null);
	
	protected float posX;
	protected float posY;
	protected float spdX;
	protected float spdY;
	protected boolean collType; //true = good, false = bad (Gute kollision (seerose) und b�se Kollision (Auto))
	
	private String[] waterInGame = water.read(false).trim().split(",");

	protected Shape collisionShape;
	protected Shape collisionShapeWater;
	
	public GameObjects(float posX, float posY, float spdX, float spdY, String type, boolean collType){
		this.posX = posX;
		this.posY = posY;
		this.spdX = spdX;
		this.spdY = spdY;
		this.type = type;
		this.collType = collType;
		
	}
	
	public void init(GameContainer container) throws SlickException {
		img = new Image("data/sets/set"+set.read(false)+"/" + type + ".png");
		collisionShape = new Rectangle(posX, posY, img.getWidth()-5, img.getHeight()-5);//-5px damit man etwas Spielraum hat
				
		//if(waterInGame[0].toUpperCase().equals("YES")){
			imgWater = new Image("data/sets/set"+set.read(false)+"/hopper_water.png");
		//}
	}

	public void update(GameContainer container, int delta) throws SlickException {
		
			collisionShape.setCenterX(posX); 
			collisionShape.setCenterY(posY);
		
	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		if(type == "hopper" && waterInGame[0].toUpperCase().equals("YES")){
			if(posY>=Float.parseFloat(waterInGame[1]))
				img.drawCentered(posX, posY);
			else
				imgWater.drawCentered(posX, posY);		
		}else{
			img.drawCentered(posX, posY);
		}
		
		//g.draw(collisionShape);
	}
	
	public void setCollType(boolean bool){
		this.collType = bool;
	}
	
	public boolean getCollType(){
		return this.collType;
	}
	
	public boolean collidesWith(GameObjects other) {	
		if(this == other){
			return false;
		}
		return (collisionShape.contains(other.collisionShape) || collisionShape.intersects(other.collisionShape)); 
	}
}
