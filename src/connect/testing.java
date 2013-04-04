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
		
		
		// Eine PlayerID �bergeben (wichtig f�r GUI)
		connect.setPlayerID(1);
		
		// Beispielwert f�r "directory":
		String directory = "/Users/Chris/Desktop/";
		
		// Ein Laufwerk �bergeben (wichtig f�r GUI)
		connect.setTransferDirectory(directory);
		
		// Nach �bergabe der Werte das Spiel starten.
		connect.startGame();
		
	//	Server_Data data = new Server_Data();
		//data.setStoneWriteFile(3);
			
	

	}

}
