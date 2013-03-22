package connect;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class Server_Data {

	/**
	 * @param args
	 */
	
	int enemyMove;
	
	public boolean readFile(String fileName)

	{
		
		Document doc = null;
				
        // spielero / spielerx Information aus Datenbank ziehen.
		
        File f = new File(fileName+"");
            
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
                
            // Sieger lesen
            Element sieger = element.getChild("gegnerzug"); 
            System.out.println("Sieger: " + sieger.getValue());       
            	
   
          
        } catch (JDOMException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
		
        return true;
		
	}

	
	public int getEnemyMove()

	{
		return enemyMove;
	}
	
	public void setEnemyMove()
	{
		
	}
	
	
}
