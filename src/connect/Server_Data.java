package connect;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import logic.KI;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Server_Data {

	/*
	 * @author Christian Samide
	 * @param args
	 * http://www.rgagnon.com/javadetails/java-0490.html
	 */
	
	// Initialisierung von enemyMove
	
	
	// Reserviert eine Objektinstanz für Server_Connector	
//	Server_Connector connect = null;
//	
//	// Konstruktor ermöglicht Übergabe
//	
//	Server_Connector connect = new Server_Connector();
//	
//	public Server_Data(Server_Connector uebergabe) {
//		connect = uebergabe;
//	}
//	
	int enemyMove;
	String fileNameFromServer;
	String fileName2Server;
	String transferDirectory;
	
	public Server_Data(String fileNameFromServer, String fileName2Server, String transferDirectory) throws InterruptedException
	{
		this.fileNameFromServer = fileNameFromServer;
		this.fileName2Server = fileName2Server;
		this.transferDirectory = transferDirectory;
		
		readFile();
		
	}

	
		public void readFile() throws InterruptedException
	{
		
		boolean ok = false;
			
		
		do{
		
			Document doc = null;
			File f = new File(transferDirectory+fileNameFromServer+"");
			System.out.println("Prüfe ob File da ist...");

				if (f.exists())
			{
				System.out.println("File ist da. Beginne lesen...");

					try { 
			        	
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
			            ok=true;
			                
			            // Sieger lesen
			            Element sieger = element.getChild("gegnerzug"); 
			            System.out.println("Sieger: " + sieger.getValue());       
			            	
			   
			          
			        } catch (JDOMException e) { 
			            e.printStackTrace(); 
			        } catch (IOException e) { 
			            e.printStackTrace(); 
			        }
					
			}//if
			else {
			
					ok=false;
					Thread.sleep(300);
					System.out.println("300 ms warten...");
			}//else
		
		}while (ok==false);
		
	/*	KI give = new KI();
		give.setRow(column, player)*/
		
	}// do
		

	

	
	public int getEnemyMove()

	{
		return enemyMove;
	}
	
	public void setStoneWriteFile(int column) throws IOException, InterruptedException
	{
		System.out.println("WriteFile aufgerufen!");
		System.out.println(fileName2Server);
		int move = column;
		FileWriter fw = new FileWriter(transferDirectory+fileName2Server);
	    BufferedWriter bw = new BufferedWriter(fw);	    
	    bw.write(String.valueOf(move));
	    bw.close();
	    readFile();
	}
	
	
}
