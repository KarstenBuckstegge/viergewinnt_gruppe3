package connect;

import java.io.IOException;

public class Connect {

	/**
	 * @param args
	 */
	jk
	int opMove = 4; // Simuliert Info aus Server-Datei
	static int move = 3; // Stellvertretend für letzten Zug
	public static void main(String[] args)
	
	{
		System.out.println("Connect gestartet!");
	}
	
	static public void setStone(int column) throws IOException
	{
		move = column;
		WriteFile.main(null);
		System.out.println("Connect.setStone aufgerufen!");
	}
	
     
	
		
	
	
	

}
