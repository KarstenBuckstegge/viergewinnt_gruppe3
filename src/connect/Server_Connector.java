package connect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	
	
	
	/**
	 * GUI setzt mit dieser Methode den Spieler (playerID).
	 * Generiert die Datei-Namen zum Lesen und Schreiben der Spielzüge.
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
	public void startGame() throws InterruptedException
	{
		System.out.println("startGame() aufgerufen!");
		Server_Data objekt = new Server_Data(fileNameFromServer, fileName2Server, transferDirectory);
//		objekt.readFile();
		
	}
		
		
		
//		StringBuilder output = new StringBuilder();
//		
//		System.out.println("Dateiname fuer Info an den Server=" + fileName2Server);
//		output.append(NEWLINE);
//		System.out.println("Dateiname fuer Info vom Server=" + fileNameFromServer);
		
//		File fi = new File(fileNameFromServer);
		
//		String absPath = fi.getAbsolutePath();
//		System.out.println("FilePath="+absPath);
		
//		try {
//			fi.createNewFile();
//		}
//		catch (IOException e) {
//			
//			e.printStackTrace();	
//		}
		


		
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
	}
public String getFileNameFromServer() {
		
		return fileNameFromServer;
	}
	
		/**
		 * Startet das Spiel, suchen nach Dateien vom Server
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 * 
		 */

		
		
		
/*		public boolean readXMLFile(String fileName) 
		{
			// http://openbook.galileocomputing.de/javainsel9/javainsel_18_007.htm#mja3b868c348f3f738e42cfdbea9cbc8f6
		    Document document;
		    
			try {
				document = new SAXBuilder().build( fileName );
			    String tmpString = "";
			    Element elementContent = document.getRootElement();
				System.out.println( elementContent );  // Test
			    //if (tmp != null)  tmpString = tmp.toString();
			    
				// jetzt alle Werte lesen und im Objekt Server_Data "speichern"
				Element field = elementContent.getChild("freigabe");
			    tmpString = field.getValue();
			    lastServerFile.setFreigabe(tmpString);

			    field = elementContent.getChild("satzstatus");
			    lastServerFile.setSatzstatus(field.getValue());

			    field = elementContent.getChild("gegnerzug");
			    tmpString = field.getValue();
			    lastServerFile.setGegnerzug(Integer.parseInt(tmpString));

			    field = elementContent.getChild("sieger");
			    lastServerFile.setSieger(field.getValue());

			    System.out.println( lastServerFile );  // Test
			    
			    // Package
			    // http://javathreads.de/2010/04/mit-jaxb-einfach-von-xml-daten-zu-java-objekten/
//			    JAXBContext jc;
//				try {
//					jc = JAXBContext.newInstance("srv_Connector");
//				    Unmarshaller unmarshaller = jc.createUnmarshaller();
	//
//				    Server_Data sd = (Server_Data) unmarshaller.unmarshal(new File(fileName));
//				} catch (JAXBException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}


			    
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    
		    return true;
		}
*/		
		
	

}
