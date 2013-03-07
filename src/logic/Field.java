package logic;

import gui.MainGui;

public class Field {
	
	public static int [][] field; //Zugnummern angeben!!!!!!!!! Dokumentation erstellen!!!!!
	
	// Erstellen eines zweidimensionalen Arrays als Spielfeld
	public static void createField(){
		field = new int [6][7];
		}
	
	// Einfuegen eines Steins in der vorgegebenen Spalte (column)
	// Spieler X ist eine 1 im Array
	// Spieler O ist eine 2 im Array
	
	public static void setStone(int column
			//, int currentPlayer
			){
		
		for (int rowCounter=0; rowCounter < 6; rowCounter++){
			
			int currentRow = 5 - rowCounter;
			
			//Operation abfangen wenn Spalte komplett gefuellt
			if (rowCounter == 5 && field [currentRow][column] != 0) {
				System.out.println("Die Spalte ist bereits voll!");
			}
			
			// Jede Reihe betrachten ob bereits ein Stein enthalten ist.
			// Ist ein Stein enthalten wird durch die Schleife in die naechste Reihe gesprungen
			if (field [currentRow][column] == 0) {
				
				// Ist kein Stein enthalten wird hier das Feld mit dem Stein des aktuellen Spielers gefuellt 
				field [currentRow][column] = currentPlayer;
				//MainGui.setMove(currentPlayer, column, rowCounter);
				
				// Stein check
				System.out.println("Stone droped in row " + currentRow + " and column " + column);
				System.out.println(field [currentRow][column]);
				
				// Beenden der for-Schleife
				rowCounter = 7;
			};
		};
	}
}
