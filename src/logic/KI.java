package logic;

import gui.MainGui;
import connect.Server_Connector;
import java.io.IOException;
import java.util.Random;
import database.CrudDb;

public class KI {
	 /**
	   * KI stellt ein Spielfeld(Array) her. 
	   * Kann erkennen welcher Stein an welcher Stelle liegt, das Feld auslesen, 
	   * einen Stein in eine Spalte werfen und einen neuen Zug generieren.
	   * 
	   * @param args
	   */
	
//------------------------------ Initialisierung ------------------------------------
	
	// Variablen deklarieren
	private int [][] field;
	private int homePlayer = 0;
	private boolean firstMove = true;
	private MainGui gui = null;
	private Server_Connector connect = null;
	
	// Erstellen des Spielfeldes.
	public void createField(){
		/**
		 * 
		 * createField initialisiert das Array in welchem die Logik agiert
		 */
		field = new int [7][6];
		System.out.println("FIELD CREATED");
	}
	
	// Das komplette Feld inclusive Steine ausgeben
	public int [][] getField() {
		return field;
	}
	
	// Constructor
	public KI(MainGui gui, Server_Connector connect, CrudDb db) {
		this.gui = gui;
		this.connect = connect;
	}
//------------------------------ Berechnung der Zeile ------------------------------------

	public void setEnemyMove(int column, int player) throws IOException, InterruptedException {
		/**
		 * 
		 * setEnemyMove verwertet den Gegnerzug der vom Server ausgelesen wurde 
		 * und definiert ein mal ob der Agent Spieler X oder O ist
		 */
		System.out.println("erfolgreich übergeben");
		setRow(column, player, true);
		
		if (firstMove == true) {
			homePlayer = player;
			firstMove = false;
		}
		
	} 
	
	public int setRow(int column, int player, boolean enemyMove) throws IOException, InterruptedException{
		/**
		 * 
		 * setRow berechnet in welcher Zeile ein Stein angelegt werden muss, wenn die Spalte vorgegeben ist
		 * und gibt den Zug an die entsprechenden Stellen weiter
		 */
		
		// Falls erster Zug, starte Zugberechnung
		if (column == -1){
			column = 3;
		}
		
		int returnRow = -1;
		int currentValue = -1;
		
		// step backwords from lower row up to top
		for (int rowCounter = 5; rowCounter > 0; rowCounter--)
		{
			currentValue = field[column] [rowCounter];
			
			// prüfen ob diese Zeile noch frei ist
			if ( currentValue == 0 )
			{
				returnRow = rowCounter;
				field[column] [rowCounter] = player;
				System.out.println("Stone droped in row " + returnRow + " and column " + column + " with value " + field [column][returnRow]);
				gui.setMove(player, column, returnRow);
				
				if (enemyMove){
<<<<<<< HEAD
					connect.writeFile(column);
=======
					server_data.setStoneWriteFile(column);
>>>>>>> neuster stand
				}
				
				break; // beendet for-schleife
			}
		}
		
		if (returnRow == -1)
		{
			System.out.println(String.format("Die Spalte %d ist bereits voll!", column));
			int randomColumn = randomMove();
			setRow(randomColumn, homePlayer, false);
		}
		
		return returnRow;
	}

//------------------------------ Berechnung der eigenen Züge ------------------------------------
	
	public void calculateNextMove() throws IOException, InterruptedException{
		/**
		 * 
		 * calculateNextMove durchläuft die einzelnen Zeilen und Spalten auf der Suche nach Vierer-Chancen
		 */
		
		int returnedValues[] = {-1, -1};
		boolean winLoose = false;
		
		
		//Durchlauf der Reihen
		for (int i = 5; i >= 0; i--){
			//Durchlauf der Spalten
			for (int j = 0; j <= 6; j++) {
				
				// Suche nach Vierer-Chancen nach Zeilen, Spalten und rechten Diagonalen
				if (j < 4 && i > 2){
					returnedValues = getWinningColumn(j, i, 1);
					winLoose = checkMove(returnedValues);
					if (winLoose == true){
						i = -1;
						break;
					}
					returnedValues = getWinningColumn(j, i, 2);
					winLoose = checkMove(returnedValues);
					if (winLoose == true){
						i = -1;
						break;
					}
					
					returnedValues = getWinningColumn(j, i, 3);
					winLoose = checkMove(returnedValues);
					if (winLoose == true){
						i = -1;
						break;
					}
				}
				// Suche nach Vierer-Chancen nur Zeilen
				else if (j < 4 && i <= 2){
					returnedValues = getWinningColumn(j, i, 1);
					winLoose = checkMove(returnedValues);
					if (winLoose == true){
						i = -1;
						break;
					}
				}
				else if (j == 5 && i == 0){
					int randomColumn = randomMove();
					setRow(randomColumn, homePlayer, false);
				}

				
				// Suche nach Vierer-Chancen nach Spalten und linken Diagonalen
				if (j > 3 && i > 2){
					returnedValues = getWinningColumn(j, i, 4);
					winLoose = checkMove(returnedValues);
					if (winLoose == true){
						i = -1;
						break;
					}
				}
			}
		}
	}
	
	private boolean checkMove(int returnedValues[]) throws IOException, InterruptedException{
		
		/**
		 * 
		 * checkMove betrachtet ob eine Vierer-Chance erkannt wurde 
		 * und setzt diese Falls vorhanden in die GUI ein 
		 */

		int checkColumn = returnedValues[0];
		int player = returnedValues[1];
		
//		if (player == homePlayer) {
//			System.out.println("Winner");
//		}
//		else
//		{
//			System.out.println("Escaped death");
//		}
		
		// betrachtet ob der Wert in der Zurückgegebenen Spalte ein Spieler ist und gibt falls vorhanden eine Sieg-/Niederlagenchance aus
		if (checkColumn >= 0){
			setRow(checkColumn, homePlayer, false);
			System.out.println("Sieg-/Niederlagenchance in Spalte " + checkColumn + " von Spieler " + player);
			return true;
		}
		else {
			return false;
		}
	}
	
	private int[] getWinningColumn(int tempColumn, int tempRow, int checkDir) throws IOException{
		/**
		 * 
		 * getWinningColumn durchsuch das Array field[][] nach Chancen auf Viererreihen
		 */
		// ----------- Testwerte -----------------
//				
//				int lempRow = tempRow-1;
//				int mempRow = tempRow-2;
//				int kempRow = tempRow-3;
//				
//				if (checkDir != 4){
//				int lempColumn = tempColumn+1;
//				int mempColumn = tempColumn+2;
//				int kempColumn = tempColumn+3;
//				
//				field[tempColumn][tempRow] = 1;
//				field[lempColumn][tempRow] = 0;
//				field[mempColumn][tempRow] = 1;
//				field[kempColumn][tempRow] = 1;
//				
//				field[tempColumn][tempRow] = 1;
//				field[tempColumn][lempRow] = 1;
//				field[tempColumn][mempRow] = 1;
//				field[tempColumn][kempRow] = 0;
//				
//				field[tempColumn][tempRow] = 1;
//				field[lempColumn][lempRow] = 0;
//				field[mempColumn][mempRow] = 1;
//				field[kempColumn][kempRow] = 1;
//				}
//				
//				if (checkDir == 4){
//				int sublempColumn = tempColumn-1;
//				int submempColumn = tempColumn-2;
//				int subkempColumn = tempColumn-3;
//				
//				field[tempColumn][tempRow] = 1;
//				field[sublempColumn][lempRow] = 0;
//				field[sublempColumn][lempRow-1] = 1;
//				field[submempColumn][mempRow] = 1;
//				field[subkempColumn][kempRow] = 1;
//				}
				
				// -------- ENDE Testwerte --------------
				
				int startValue = field[tempColumn][tempRow];
				int leftStartValue = -1;
				int winCounter = 0;
				int [] winArray = new int [2];
				int gap = 0;
				int gapPosition = 0;
				int winColumn = -1;
				int tempValue = 0;
				int checkRow = 0;
				int checkColumn = 0;
				int gapCheckRow = 6;
				int gapCheck = -1;
				
				for (int i = 0; i<4; i++) {
					
					// checken in der Zeile
					if (checkDir == 1) {
						checkColumn = i+tempColumn;
						checkRow = tempRow;
						tempValue = field[checkColumn][checkRow];
					}
					// checken in der Spalte
					else if (checkDir == 2) {
						checkRow = tempRow-i;
						tempValue = field[tempColumn][checkRow];
					}
					// checken in der Diagonal rechts
					else if (checkDir == 3) {
						checkRow = tempRow - i;
						checkColumn = tempColumn + i;
						tempValue = field[checkColumn][checkRow];
					}
					// checken in der Diagonal links
					else {
						checkRow = tempRow - i;
						checkColumn = tempColumn - i;
						tempValue = field[checkColumn][checkRow];
					}
					
					if (startValue == 0){
						break;
					}
					// ist der Wert im aktuellen Feld gleich dem Wert aus dem Anfangsfeld?
					else if (tempValue == startValue) {
						winCounter++;
					}
					// befindet sich im aktuellen Feld eine Lücke?
					else if (tempValue == 0 && gap == 0) {
						gap++;
						gapPosition = i;
						gapCheckRow = checkRow + 1;
					}
					// befindet sich im aktuellen Feld eine zweite Lücke wird die Schleife unterbrochen
					else if (tempValue == 0 && gap == 1 && checkDir == 1) {
						break;
					}
					// befindet sich im aktuellen Feld ein anderer Stein wird die Schleife unterbrochen
					else if (winCounter < 3 && tempValue != startValue && tempValue != 0) {
						break;
					}
					// befinden sich weniger als drei Steine aufeinander wird die Schleife unterbrochen
					else if (winCounter < 3 && tempValue == 0 && checkDir == 2 && gap == 1) {
						break;
					}
					
					// befindet sich unter einer Lücke kein Stein wird die Schleife unterbrochen
					if (gapCheckRow > 5){
						gapCheck = -1;
					}
					else{
						gapCheck = field[checkColumn][gapCheckRow];
					}
					
					if (tempValue == 0 && gap ==1 && gapCheck == 0 && checkDir != 2) {
						break;
					}
					
					// erkennt Sieg bei offenem Feld für Diagonale nach links
					if (winCounter == 3 && gap == 1 && checkDir == 4){
						winColumn = tempColumn - gapPosition;
						System.out.println("1Win at Column " + winColumn);
						winArray[0] = winColumn;
						winArray[1] = startValue;
						return winArray;
					}
					
					// erkennt Sieg bei offenem Feld für Zeile und Diaglonale rechts
					if (winCounter == 3 && gap == 1 && checkDir != 2){
						winColumn = tempColumn + gapPosition;
						System.out.println("2Win at Column " + winColumn);
						winArray[0] = winColumn;
						winArray[1] = startValue;
						return winArray;
					}
					
					// Wert links von der Startposition erkennen
					if (tempColumn > 0){
						leftStartValue = field[tempColumn - 1][tempRow];
					}
					
					// erkennt Sieg bei offenem Feld vor der ersten Stelle
					if (tempColumn > 0 && i >= 3 && winCounter == 3 && leftStartValue == 0 && checkDir != 2){
						winColumn = tempColumn - 1;
						System.out.println("3Win at Column " + winColumn);
						winArray[0] = winColumn;
						winArray[1] = startValue;
						return winArray;
					}
					
					// erkennt Sieg in einer Spalte
					if (winCounter == 3 && gap == 1 && checkDir == 2){
						winColumn = tempColumn;
						System.out.println("Win at " + tempColumn + " by Column");
						winArray[0] = winColumn;
						winArray[1] = startValue;
						return winArray;
					}
				} 
				winArray[0] = -1;
				winArray[1] = -1;
				return winArray;
	}
	
	public int randomMove() throws IOException{
		/**
		 * 
		 * randomMove berechnet einen zufälligen Zug des Agents
		 */
		int newValue = -1;
		//int tmp = 0;
		Random generator = new Random();
		newValue = generator.nextInt(6);
		//newValue = ctrlclass.COLUMNS - tmp - 1;
		//connect.setStone(newValue);
		return newValue;
	}
}
