package logic;

public class TestKI {

	private static int [][] field;
	
	public static void createField(){
		field = new int [6][7];
		System.out.println("FIELD CREATED");
	}
	
	public static int checkLines(int tempColumn, int tempRow, int checkDir) {
		
		// ----------- Testwerte -----------------
		System.out.println("Los!");
		
		int lempRow = tempRow-1;
		int mempRow = tempRow-2;
		int kempRow = tempRow-3;
		
		if (checkDir != 4){
		int lempColumn = tempColumn+1;
		int mempColumn = tempColumn+2;
		int kempColumn = tempColumn+3;
		
		field[tempColumn][tempRow] = 1;
		field[lempColumn][tempRow] = 0;
		field[mempColumn][tempRow] = 1;
		field[kempColumn][tempRow] = 1;
		
		field[tempColumn][tempRow] = 1;
		field[tempColumn][lempRow] = 1;
		field[tempColumn][mempRow] = 1;
		field[tempColumn][kempRow] = 0;
		
		field[tempColumn][tempRow] = 1;
		field[lempColumn][lempRow] = 0;
		field[mempColumn][mempRow] = 1;
		field[kempColumn][kempRow] = 1;
		}
		
		if (checkDir == 4){
		int sublempColumn = tempColumn-1;
		int submempColumn = tempColumn-2;
		int subkempColumn = tempColumn-3;
		
		field[tempColumn][tempRow] = 1;
		field[sublempColumn][lempRow] = 0;
		field[sublempColumn][lempRow-1] = 1;
		field[submempColumn][mempRow] = 1;
		field[subkempColumn][kempRow] = 1;
		}
		
		// -------- ENDE Testwerte --------------
		
		int startValue = field[tempColumn][tempRow];
		int leftStartValue = field[tempColumn - 1][tempRow];
		int winCounter = 0;
		int gap = 0;
		int gapPosition = 0;
		int winColumn = -1;
		int tempValue = 0;
		int checkPosition = 0;
		int checkRow = 0;
		int checkColumn = 0;
		int diagonalGapCheckRow = 0;
		int diagonalGapCheck = 0;
		
		for (int i = 0; i<4; i++) {
			
			if (checkDir == 1) {
				checkPosition = i+tempColumn;
				tempValue = field[checkPosition][tempRow];
				System.out.println("checked Column = " + checkPosition);
			}
			else if (checkDir == 2) {
				checkPosition = tempRow-i;
				tempValue = field[tempColumn][checkPosition];
				System.out.println("checked Row = " + checkPosition);
			}
			else if (checkDir == 3) {
				checkRow = tempRow - i;
				checkColumn = tempColumn + i;
				diagonalGapCheckRow = checkRow-1;
				tempValue = field[checkColumn][checkRow];
				System.out.println("checked Column " + checkColumn + " and Row " + checkRow);
			}
			else {
				checkRow = tempRow - i;
				checkColumn = tempColumn - i;
				diagonalGapCheckRow = checkRow-1;
				tempValue = field[checkColumn][checkRow];
				System.out.println("checked Column " + checkColumn + " and Row " + checkRow);
			}
			
			// ist der Wert im aktuellen Feld gleich dem Wert aus dem Anfangsfeld?
			if (tempValue == startValue) {
				winCounter++;
			}
			// befindet sich im aktuellen Feld eine Lücke?
			else if (tempValue == 0 && gap == 0) {
				gap++;
				gapPosition = i;
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
			
			diagonalGapCheck = field[checkColumn][diagonalGapCheckRow];
			if (tempValue == 0 && gap == 1 && checkDir != 2 && checkDir != 1 && diagonalGapCheck == 0) {
				System.out.println("NO!");
				break;
			}
			
			// erkennt Sieg bei offenem Feld an zweiter oder dritter Stelle
			if (winCounter == 3 && gap == 1 && checkDir == 4){
				winColumn = tempColumn - gapPosition;
				System.out.println("Win at Column " + winColumn);
				return winColumn;
			}
			
			if (winCounter == 3 && gap == 1 && checkDir != 2){
				winColumn = tempColumn + gapPosition;
				System.out.println("Win at Column " + winColumn);
				return winColumn;
			}
			
			// erkennt Sieg bei offenem Feld vor der ersten Stelle
			if (tempColumn > 0 && i >= 3 && winCounter == 3 && leftStartValue == 0 && checkDir != 2){
				winColumn = tempColumn - 1;
				System.out.println("Win at Column " + winColumn);
				return winColumn;
			}
			
			// erkennt Sieg in einer Spalte
			if (winCounter == 3 && gap == 1 && checkDir == 2){
				winColumn = tempColumn;
				System.out.println("Win at " + tempColumn + " by Column");
				return winColumn;
		}
		} 
	return -1;
	}

}
