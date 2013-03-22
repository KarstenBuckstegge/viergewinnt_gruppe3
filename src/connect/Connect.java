package connect;

import java.io.IOException;

public class Connect {

  /**
   * Klasse Connect stellt die Schnittstelle zwischen Server und Agent dar.
   * Hauptprogramm für alle Kommunikationsabläufe
   * 
	 * @param args
	 */

	
	// 1. Parameter holen
	// - Von GUI-Dropdown ermitteln ob man spielero oder spielerx ist.
	// - Laufwerk aus GUI-Browsing-Dialog ziehen.	

	// 2. Funktion: Serverfile von Kontaktpfad lesen.
	
	
	// 3. Funktion: Agentfile auf Kontaktpfad schreiben.
		
	int move = 3; // Stellvertretend fuer letzten Zug
	public static void main(String[] args)
	
	{
		System.out.println("Connect gestartet!");
	}
	
	public void setStone(int column) throws IOException
	{
		move = column;
		WriteFile.main(null);
		System.out.println("Connect.setStone aufgerufen!");
	}
	
     
	
		
	
	
	

}
