package game.frogger.inout;

import java.io.*;

public class ReadWrite {
	
	private String mainUrl;
	private String filename;
	private String text;
	
	public ReadWrite(String mainUrl, String filename, String text){
		this.mainUrl = mainUrl;
		this.filename = filename;
		this.text = text;
	}
	
	public ReadWrite(String filename){
		this("data/settings/",filename, "");
	}
	
	public ReadWrite(){
		this(null, null, null);
	}
	
	public void resetData(){ //Die Dateien werden auf ihre initialwerte zurückgesetzt.
		this.mainUrl= "data/settings/";
		this.filename = "objects"; // Auswählen der Datei
		this.text = "0,2,3,2,3,0,2,3,2,3"; //Stanarddaten
		write(); // schreiben
		this.filename = "speed";
		this.text = "0,200,-100,150,-160,0,130,-110,170,-120";
		write();
		this.filename = "distance";
		this.text = "0,200,250,300,150,0,400,250,250,200";
		write();
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void write(){
		try{
			FileWriter fstream = new FileWriter(this.mainUrl + this.filename + ".frog"); // erstellt eine verbindung zu einer datei zum schreiben
			BufferedWriter out = new BufferedWriter(fstream); // das zu schreibende element
			out.write(""); // zuerst leeren.
			out.write(this.text); // schreibe text durch den buffer in die datei
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public String read(boolean withBreak){
		String s = "";
		
		try{
			FileInputStream fstream = new FileInputStream(this.mainUrl + this.filename + ".frog"); // Erstellt eine eVErbinsung zu einer Datei zum lesenden zugriff
			
			DataInputStream in = new DataInputStream(fstream); // stellt Routinen zur Verfügung, mit denen Werte der Standarddatentypen aus einem Stream gelesen werden können.
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); // das zu lesende element wir in br gebuffert
			String strLine;
			
			while((strLine = br.readLine()) != null){
				s += strLine;
				if(withBreak == true)
					s += "\n";
				
			}
			
			in.close();
			
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return s;
	}
}
