package connect;

import java.io.IOException;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Server_Connector connection = new Server_Connector();
		connection.setPlayerID(1);
		
		System.out.println("Klasse Test");
		System.out.println("Test gestartet!");
		
		Connect connection = new Connect();
		connection.setStone(7);
	
		System.out.println("Test beendet, jetzt die Textdatei im Stammverzeichnis prüfen!");
		
		
		
	}

}
