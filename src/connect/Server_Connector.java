package connect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import logic.KI;

/**
 * @author Christian Samide
 *
 */
public class Server_Connector {

	/**
	 * @param args
	 * 
	 */
	
	private int playerID = 0;
	private String  [] fileNameSuffix = {"unknown","x", "0"};
	private String fileName2Server = "";
	private String fileNameFromServer = "";
	private String transferDirectory = ".\\Transfer";
	private int movetime = 2000;
	
	private KI ki = null;
	private Server_Data data = null;
	private int column;
	
	public void setKI(KI ki) {
		
		this.ki=ki;
	}
	
	/**
	 * GUI setzt mit dieser Methode den Spieler (playerID).
	 * Generiert die Datei-Namen zum Lesen und Schreiben der Spielzuege.
	 * 
	 */
	
	public void setPlayerID(int playerID)
	{
		this.playerID = playerID;
		String tmp = fileNameSuffix[playerID];
		fileNameFromServer = "server2spieler" + tmp + ".xml";
		fileName2Server = "spieler" + tmp + "2server.txt";
		
		// Kontroll-Ausgabe in der Konsole
		System.out.println("fileNameSuffix: "+tmp);
		System.out.println("fileNameFromServer: "+fileNameFromServer);
		System.out.println("fileName2Server: "+fileName2Server);
		
		
	} // set PlayerID

	
	// Setzt das Verzeichnis, in dem die Datei gelesen werden soll.
	public void setTransferDirectory(String directory)
	{
		
		this.transferDirectory = directory;
		
		// Kontroll-Ausgabe in der Konsole
		System.out.println("transferDirectory: "+this.transferDirectory);
		
	} // setTransferDirectory
	
	
	// Setzt die Zugzeit
	public void setMoveTime(int movetime)
	{
		this.movetime = movetime;
		System.out.println("movetime: "+this.movetime+" ms");

	} //setMoveTime
	
	
	
	// Startet den ersten Lese-Vorgang
	public void startGame() throws InterruptedException, IOException
	{
		System.out.println("startGame() aufgerufen!");
		this.data = new Server_Data(playerID, fileNameFromServer, fileName2Server, transferDirectory);
		
		data.readFile(ki);
			
		//ki.setEnemyMove(give, playerID);
		
		
	}
	
	
	public void setStone(int column) throws IOException, InterruptedException {
		
		this.column  = column;
		data.writeFile(column);
		
		data.readFile(ki);		
		//ki.setEnemyMove(give, playerID);
	}
		
		/**
		 *  
		 * @param directory
		 */
	
	public int getPlayerID() {
		
		return playerID;
		
	}

	public String getTransferDirectory()
		{
			return this.transferDirectory;
		} // get Transferdirectory
		
	public String getFileName2Server() {
		
		return fileName2Server;
	} // getFileName2Server
	
	public String getFileNameFromServer() {
		
		return fileNameFromServer;
	} // getFileName2Server

} // class Server_Connector
