package logic;

public class Field {
	private int [][] field;
	
	// Erstellen des Spielfeldes
	public void createField(){
		field = new int [6][7];
		System.out.println("FIELD CREATED");
	}
	
	// Einen Stein im Feld platzieren
	public void setStone(int column, int row, int player) { // player: 0 = leer, 1 = x, 2 = o 
		this.field[column][row] = player;
	}
	
	// Auslesen welcher Stein an entsprechender Position liegt
	public int getPlayer(int column, int row) { // player: 0 = leer, 1 = x, 2 = o 
		System.out.println("column: " + column + " row: " + row);
		int test = this.field[column][row];
		System.out.println(test);
		return this.field[column][row];
	}
	
	// Das komplette Feld inclusive Steine ausgeben
	public int [][] getField() {
		int [][] tmp_field = new int[6][7];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				tmp_field[i][j] = this.getPlayer(i, j);
			};
		};
		return tmp_field;
	}
	
}
