package connect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

import logic.KI;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 * Klasse Server_Data:
 <ul>
  <li>Probieren geht &uuml;ber Studieren</li>
  <li>Liebe geht &uuml;ber Triebe</li>
  <li>Tante f&auml;llt &uuml;ber Kante</li>
</ul>
 * 
 * - Liest Server-File 
 * 
 * - Gibt Gegnerzug an Logik weiter
 * 
 * - Schreibt Agent-File
 * </pre>
 * 
 * @author Christian Samide
 * @param args
 */
public class Server_Data {

	/**
	 * Initialisierungen der Attribute
	 */	
	int enemyMove;
	int playerID;
	String fileNameFromServer;
	String fileName2Server;
	String transferDirectory;
	
	private KI ki = null;
	
	/**
	 *	Konstruktor Server_Data() mit Parameterliste
	 *
	 *	- Ermöglicht Server_Connector die Übergabe der Parameter, die für Lesen und Schreiben der Server- bzw. Agentfiles notwendig sind.
	 *
	 *  - readFile() löst Lese-Vorgang bei Objekterzeugung aus.
	 */
	public Server_Data(int playerID, String fileNameFromServer, String fileName2Server, String transferDirectory) throws InterruptedException, IOException
	{
		this.playerID = playerID;
		this.fileNameFromServer = fileNameFromServer;
		this.fileName2Server = fileName2Server;
		this.transferDirectory = transferDirectory;
		
		// readFile();
		
	}
	
	/**
	 * Alternativer Konstruktor Server_Data() ohne Parameterliste
	 */
	//public Server_Data(){}
	private boolean read_success = false;
	Timer fileListener = new Timer("filelistener");
	
	int timeCounter = 0;
	/**
	 * Methode readFile() steuert alle Abläufe zum Lesen des Server-Files
	 */
	public void readFile(KI ki) throws InterruptedException, IOException
	{
		timeCounter++;
		fileListener = new Timer("filelistener_" + timeCounter);
		
		
		this.ki = ki;
		/**
		 * Initialisierung der Variable read_success.
		 */
		
		/**
		 * Schleife steuert Lese-Vorgang
		 * solange read_success = false
		 * Abbruchbedingung: read_success = true
		 */
		
		TimerTask task = new TimerTask() {
			public synchronized void run() {
				Platform.runLater(this);
				
				File f = new File(transferDirectory+"/"+fileNameFromServer+"");
				System.out.println("Prüfe ob File da ist...");
				
				if (f.exists())
				{
					System.out.println("Datei gefunden");
					parseXmlFile(f);
					continueMove();
				} else {
					// mach nix
				}
			}
		};
		
		this.fileListener.schedule(task, 6000, 6000);
		
	}// do
	
	private void continueMove() {
		try {
			this.ki.setEnemyMove(enemyMove, playerID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int parseXmlFile(File f) {
		this.fileListener.cancel();
		
		System.out.println("File ist da. Beginne lesen...");
		try { 
			Document doc = null;
			
			// Das Dokument erstellen 
			SAXBuilder builder = new SAXBuilder(); 
			doc = builder.build(f);
			
			XMLOutputter fmt = new XMLOutputter();
			Element element = doc.getRootElement();
			
			// Freigabe lesen
			Element freigabe = element.getChild("freigabe"); 
			System.out.println("Freigabe: " + freigabe.getValue());
			
			// Satzstatus lesen
			Element satzstatus = element.getChild("satzstatus"); 
			System.out.println("Satzstatus: " + satzstatus.getValue());
			
			// Gegnerzug lesen
			Element gegnerzug = element.getChild("gegnerzug"); 
			System.out.println("Gegnerzug: " + gegnerzug.getValue());
			
			enemyMove = Integer.parseInt(gegnerzug.getValue());
			System.out.println("Ergebnis ist : "+enemyMove);
			read_success = true;
			f.delete();
			
			// Sieger lesen
			Element sieger = element.getChild("gegnerzug"); 
			System.out.println("Sieger: " + sieger.getValue());
			
		} catch (JDOMException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
		
		System.out.println("Der gelesene Zug ist " + enemyMove);
		return enemyMove;
	}
	
	/**
	 * Übernimmt die von logic berechnete Spalte (den Spielzug) und schreibt das Agentfile.
	 */
	public void writeFile(int column) throws IOException, InterruptedException
	{
		System.out.println("WriteFile aufgerufen!");
		System.out.println(fileName2Server);
		int move = column;
		FileWriter fw = new FileWriter(transferDirectory+"/"+fileName2Server);
	    BufferedWriter bw = new BufferedWriter(fw);	    
	    bw.write(String.valueOf(move));
	    bw.close();
	    // readFile();
	}

	
	
	
}
