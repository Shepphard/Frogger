package game.frogger.selector;

import java.util.ArrayList;
import java.util.List;

import game.frogger.inout.ReadWrite;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class SelectorElements {

	private List<TextField> fieldList;
	
	private int x;
	private int y;
	
	private Font font;
	
	private boolean error = false;
	private boolean showLane;
	
	private ReadWrite files;
	
	private String filename;
	private String[] element;
	
	public SelectorElements(int x, int y, String filename){
		this(x,y,filename,true);
	}
	
	public SelectorElements(int x, int y, String filename, boolean showLane){
		this.x = x;
		this.y = y;
		this.filename = filename;
		this.showLane = showLane;
	}
	
	private void getData(){
		files = new ReadWrite(filename);
		this.element = files.read(false).split(",");
	}
	
	public void init(GameContainer container) throws SlickException{
		getData();
		font = container.getDefaultFont();
		fieldList = new ArrayList<TextField>();
		for(int i = 0; i<element.length;i++){
			if(showLane == true)
				fieldList.add(new TextField(container, font, this.x+100, y+(i+1)*20, 60, 20));
			else
				fieldList.add(new TextField(container, font, this.x+30, y+i*20, 20, 20));
		}
		int counter = 0;
		for(TextField obj: fieldList){
			obj.setText(element[counter]);
			counter++;
		}
	}
	
	public boolean setCheck(int number){
		
		for(TextField obj:fieldList){
			if(check(obj.getText()))
				return false;
			if(Integer.parseInt(obj.getText())>number){
				return false;
			}
		}
		return true;
	}
	
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		
		
		g.drawString(filename.toUpperCase(), x, y);
		int counter = 0;
		for(TextField obj : fieldList){
			if(showLane == true)
				g.drawString("Lane"+(counter+1)+": ", x, y+(counter+1)*20);
			
			obj.render(container, g);
			counter++;
			
		}

		
	}
	private boolean check(String s){
		for(char c : s.toCharArray())
		{
			//System.out.println(c);
			checkDigit:
			if(!Character.isDigit(c)){
				if(c=='-')
					break checkDigit;
		    	return true;
			}
		}
		return false;
	}
	
	public boolean getError(){
		return error;
	}
	
	public void setError(boolean err){
		this.error = err;
	}
	
	public void save(){
		String saveData = "";
		boolean first = true;
		error =false;
		outerloop:
		for(TextField obj : fieldList){
			if(!first)
				saveData+=",";
			
			if(check(obj.getText())){
				System.out.println("We got an error! Please check the Textfields.");
				error=true;
				break outerloop;
			}
			saveData += obj.getText();
			first = false;
			
		}
		if(!error){
			files.setText(saveData);
			files.write();
		}
	}
}
