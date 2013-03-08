package controller;

import logic.Field;
import logic.KI;

public class Main {
	public static int stone_x;
	public static int stone_o;
	public static int turn;

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		Field.createField();
		// Variablen geben Spalte und Spieler an
		Field.setStone (3, 1);
		Field.setStone (3, 2);
		Field.setStone (3, 1);
		Field.setStone (3, 2);
		Field.setStone (3, 1);
		Field.setStone (3, 2);
		Field.setStone (3, 1);
		KI.checkThreeRow();
	}

}
