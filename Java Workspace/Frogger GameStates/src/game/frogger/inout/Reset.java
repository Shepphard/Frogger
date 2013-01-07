package game.frogger.inout;

public class Reset {

	private static ReadWrite resetter = new ReadWrite();
	
	public static void reset(){
		resetter.resetData();
	}
}
