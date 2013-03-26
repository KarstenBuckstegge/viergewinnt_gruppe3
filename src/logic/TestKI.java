package logic;

public class TestKI {

	private static int [][] field;
	
	public static void createField(){
		field = new int [6][7];
		System.out.println("FIELD CREATED");
	}
	
	public static int checkRow(int tempColumn, int tempRow) {
		
		System.out.println("Los!");
		
		int lempColumn = tempColumn+1;
		int mempColumn = tempColumn+2;
		int kempColumn = tempColumn+3;
		
		field[tempColumn][tempRow] = 1;
		field[lempColumn][tempRow] = 1;
		field[mempColumn][tempRow] = 1;
		field[kempColumn][tempRow] = 2;
		
		int startValue = field[tempColumn][tempRow];
		int leftStartValue = field[tempColumn - 1][tempRow];
		int winCounter = 0;
		int gap = 0;
		int gapPosition = 0;
		
		for (int i = 0; i<4; i++) {
			
			int checkColumn = i+tempColumn;
			int tempValue = field[checkColumn][tempRow];
			System.out.println("checkColumn = " + checkColumn);
			
			// ist der Wert im aktuellen Feld gleich dem Wert aus dem Anfangsfeld?
			if (tempValue == startValue) {
				winCounter++;
				System.out.println("column: " + checkColumn + " value: " + field[checkColumn][tempRow] + " counter: " + winCounter);
			}
			// befindet sich im aktuellen Feld eine Lücke?
			else if (tempValue == 0 && gap == 0) {
				gap++;
				gapPosition = i;
				System.out.println("Gap at "+ gapPosition);
			}
			// befindet sich im aktuellen Feld eine zweite Lücke wird die Schleife unterbrochen
			else if (tempValue == 0 && gap == 1) {
				System.out.println("2nd Gap at "+ checkColumn);
				break;
			}
			// befindet sich im aktuellen Feld ein anderer Stein wird die Schleife unterbrochen
			else {
				System.out.println("column: " + checkColumn + " value: " + field[checkColumn][tempRow] + " BREAK");
				break;
			}
			
			// erkennt Sieg bei offenem Feld an vierter Spalte
			if (winCounter == 3 && tempValue == 0){
				System.out.println("Win at Row " + tempColumn + " + 4");
				return tempColumn + 4;
			}
			
			// erkennt Sieg bei offenem Feld an zweiter oder dritter Stelle
			if (winCounter == 3 && gap == 1){
				System.out.println("Win at Row " + tempColumn + " + " + gapPosition);
				return tempColumn + gapPosition;
			}
			
			// erkennt Sieg bei offenem Feld vor der ersten Stelle
			if (tempColumn > 0 && i == 4 && winCounter == 3 && leftStartValue == 0){
				System.out.println("Win at Row " + tempColumn + " - 1 ");
				return tempColumn - 1;
			}
			
		}
	return -1;
	}

}
