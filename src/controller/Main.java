package controller;

import logic.KI;

public class Main {
	public int turn;
	private static int tmpColumn;

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		KI ki = new KI();
		ki.createField();
		// Variablen geben Spalte und Spieler an
		ki.setStone(4, 1);
		tmpColumn = ki.calculateNextMove(1);
		System.out.println(tmpColumn);
		ki.setStone(tmpColumn, 2);
	}

}
