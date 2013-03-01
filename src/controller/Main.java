package controller;

import logic.Field;

public class Main {
	public static Field field;
	public static int stone_x;
	public static int stone_o;
	public static int turn;

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		field = new Field();
		field.dropStone (3, 3);

	}

}
