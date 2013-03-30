package logic;

public class TestKI {

	private static int [][] field;
	
	public static void createField(){
		field = new int [6][7];
		System.out.println("FIELD CREATED");
	}
	
	public static int checkLines(int tempColumn, int tempRow, boolean checkRow) {
		
		// ----------- Testwerte -----------------
		System.out.println("Los!");
		
		int lempColumn = tempColumn+1;
		int mempColumn = tempColumn+2;
		int kempColumn = tempColumn+3;
		
		field[tempColumn][tempRow] = 1;
		field[lempColumn][tempRow] = 0;
		field[mempColumn][tempRow] = 1;
		field[kempColumn][tempRow] = 1;
		
		int lempRow = tempRow+1;
		int mempRow = tempRow+2;
		int kempRow = tempRow+3;
		
		field[tempColumn][tempRow] = 1;
		field[tempColumn][lempRow] = 1;
		field[tempColumn][mempRow] = 1;
		field[tempColumn][kempRow] = 0;
		
		// -------- ENDE Testwerte --------------
		
		int startValue = field[tempColumn][tempRow];
		int leftStartValue = field[tempColumn - 1][tempRow];
		int winCounter = 0;
		int gap = 0;
		int gapPosition = 0;
		int winColumn = -1;
		int tempValue;
		int checkPosition = 0;
		
		for (int i = 0; i<4; i++) {
			
			if (checkRow == true) {
				checkPosition = i+tempColumn;
				tempValue = field[checkPosition][tempRow];
				System.out.println("checked Column = " + checkPosition);
			}
			else {
				checkPosition = i+tempRow;
				tempValue = field[tempColumn][checkPosition];
				System.out.println("checked Row = " + checkPosition);
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
			else if (tempValue == 0 && gap == 1 && checkRow == true) {
				break;
			}
			// befindet sich im aktuellen Feld ein anderer Stein wird die Schleife unterbrochen
			else if (winCounter < 3 && tempValue != startValue && tempValue != 0) {
				break;
			}
			
			else if (winCounter < 3 && tempValue == 0 && checkRow == false && gap == 1) {
				break;
			}
			
			// erkennt Sieg bei offenem Feld an zweiter oder dritter Stelle
			if (winCounter == 3 && gap == 1 && checkRow == true){
				winColumn = tempColumn + gapPosition;
				System.out.println("Win at Column " + winColumn);
				return winColumn;
			}
			
			// erkennt Sieg bei offenem Feld vor der ersten Stelle
			if (tempColumn > 0 && i >= 3 && winCounter == 3 && leftStartValue == 0 && checkRow == true){
				winColumn = tempColumn - 1;
				System.out.println("Win at Column " + winColumn);
				return winColumn;
			}
			
			if (winCounter == 3 && gap == 1 && checkRow == false){
				winColumn = tempColumn;
				System.out.println("Win at " + tempColumn + " by Column");
				return winColumn;
			} 
			
		}
	return -1;
	}

}
