package connect;

import java.io.IOException;

public class testing {

	/**
	 * Klasse zum Testen von Server_Connector (und Server_Data)
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		// Server_Connector-Objekt erzeugen
		Server_Connector connect = new Server_Connector();
		
		
		// Eine PlayerID übergeben (wichtig für GUI)
		connect.setPlayerID(1);
		
		// Beispielwert für "directory":
		String directory = "/Users/Chris/Desktop/";
		
		// Ein Laufwerk übergeben (wichtig für GUI)
		connect.setTransferDirectory(directory);
		
		// Nach Übergabe der Werte das Spiel starten.
		connect.startGame();
		
	//	Server_Data data = new Server_Data();
		//data.setStoneWriteFile(3);
			
	

	}

}
