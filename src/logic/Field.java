package logic;

public class Field {
	
	public int [][] field;
	private int currentPlayer;
	
	// Erstellen eines zweidimensionalen Arrays als Spielfeld
	public void createField(){
		field = new int [6][7];
	}
	
	// Einfuegen eines Steins in der vorgegebenen Spalte (column)
	// Spieler X ist eine 1 im Array
	// Spieler O ist eine 2 im Array
	
	public void dropStone(int column, int current_player){
		
		for (int rowCounter=6; rowCounter>=0; rowCounter--){
			
			// Jede Reihe betrachten ob bereits ein Stein enthalten ist.
			// Ist ein Stein enthalten wird durch die Schleife in die naechste Reihe gesprungen
			if (field [rowCounter-1][column] != 1 && field [rowCounter-1][column] != 2) {
				
				// Ist kein Stein enthalten wird hier das Feld mit dem Stein des aktuellen Spielers gefuellt 
				this.field [rowCounter-1][column] = currentPlayer;
				
				// Beenden der for-Schleife
				rowCounter = 7;
			};
			
			//Operation abfangen wenn Spalte komplett gefuellt
			if (rowCounter == 0) {
				rowCounter--;
				System.out.println("Die Spalte ist bereits voll!");
			}
			System.out.println(field [rowCounter-1][column]);
		};
	}
}
