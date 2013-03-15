package controller;

import logic.KI;
import logic.FindRow;
import logic.Field;

public class Main {
	public int turn;
	public static Field field;

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		FindRow findrow = new FindRow();
		field = new Field();
		KI ki = new KI();
		field.createField();
		// Variablen geben Spalte und Spieler an
		findrow.getRow (4);
		findrow.getRow (4);
		ki.calcStone();
	}

}
