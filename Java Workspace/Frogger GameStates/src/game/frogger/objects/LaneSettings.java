package game.frogger.objects;

import game.frogger.inout.ReadWrite;

public class LaneSettings {
	
	private String settings;
	
	public LaneSettings(String settings){
		this.settings = settings;
	}
	
	public float getData(int lane){
		ReadWrite io = new ReadWrite(this.settings);
		
		String[] str = io.read(true).split(","); // read gibt einen einzelnen String zurück und split teilt diesen String in array auf
		float[] data = new float[10];
		for(int i=0; i<str.length;i++){
			data[i] = parser(str[i]);
		}
		
		return data[lane];
	}

	public static float parser(String str){
		float result = Float.valueOf(str.trim()).floatValue(); //trim zum entfernen der whitespaces falls as welchem grund auch immer vorhanden.
		return result;
	}
}

