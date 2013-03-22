package connect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Chris
 *
 */
public class Server_Connector {

	/**
	 * @param args
	 */
	
	private String  [] fileNameSuffix = {"unknown","x", "0"};
	private String fileName2Server = "";
	private String fileNameFromServer = "";
	private String transferDirectory = ".\\Transfer";
	
	public static final String NEWLINE = System.getProperty("line.separator");

//	private Server_Data lastServerFile = new Server_Data();
	
	
	public void setPlayerID(int playerID)
	{
		String tmp = fileNameSuffix[playerID];
		fileNameFromServer = "server2spieler" + tmp + ".xml";
		fileName2Server = "spieler" + tmp + "2server.txt";
		StringBuilder output = new StringBuilder();
		
		System.out.println("Dateiname fuer Info an den Server=" + fileName2Server);
		output.append(NEWLINE);
		System.out.println("Dateiname fuer Info vom Server=" + fileNameFromServer);
		
		File fi = new File(fileNameFromServer);
		
		String absPath = fi.getAbsolutePath();
		System.out.println("FilePath="+absPath);
		
		try {
			fi.createNewFile();
		}
		catch (IOException e) {
			
			e.printStackTrace();	
		}
		
				
		/**
		 * Setzt das Verzeichnis fuer den Datenaustausch mit dem Server
		 * 
		 * @param directory
		 */
	} // set PlayerID

	public boolean setTransferDirectory(String directory)
		{
			boolean isAvailable = true;
			// ToDo: check if the given directory is available
			// if not return false
			this.transferDirectory = directory;
			return isAvailable;
		} // setTransferDirectory
		
		/**
		 *  
		 * @param directory
		 */

	public String getTransferDirectoy()
		{
			return this.transferDirectory;
		} // get Transferdirectory
		

		/**
		 * Startet das Spiel, suchen nach Dateien vom Server
		 * @throws IOException 
		 * @throws FileNotFoundException 
		 * 
		 */
	public void startGame() 
		{
			
		}
		
		
		
		
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
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
