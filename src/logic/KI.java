package logic;

import gui.MainGui;
import connect.Connect;

import java.io.IOException;
import java.util.Random;

public class KI {
	 /**
	   * KI stellt ein Spielfeld(Array) her. 
	   * Kann erkennen welcher Stein an welcher Stelle liegt, das Feld auslesen, 
	   * einen Stein in eine Spalte werfen und einen neuen Zug generieren.
	   * 
	   * @param args
	   */
	
	// Variablen deklarieren
	private int [][] field;
	private MainGui gui = null;
	private Connect connect = null;
	
	// Erstellen des Spielfeldes
	public void createField(){
		field = new int [6][7];
		System.out.println("FIELD CREATED");
	}
	
	// Das komplette Feld inclusive Steine ausgeben
	public int [][] getField() {
		return field;
	}
	
	// Constructor
	public KI(MainGui gui, Connect connect) {
		this.gui = gui;
		this.connect = connect;
	}
	
	public int setRow(int column, int player) throws IOException{
		/**
		 * 
		 * setRow berechnet in welcher Zeile ein Stein angelegt werden muss, wenn die Spalte vorgegeben ist.
		 */
		
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
				System.out.println("Stone droped in row " + returnRow + " and column " + column);
				System.out.println("New Value=" + field [column][returnRow]);
				gui.setMove(player, column, returnRow);
				
				break; // beende for-schleife
			}
		}
		
		if (returnRow == -1)
		{
			System.out.println(String.format("Die Spalte %d ist bereits voll!", column));
		}
		
		return returnRow;
	}
	
	public int calculateNextMove(int playerID) throws IOException{
		/**
		 * 
		 * calculateNextMove berechnet den nächsten Zug des Agents.
		 */
		int newValue = -1;
		//int tmp = 0;
		Random generator = new Random();
		newValue = generator.nextInt(6);
		//newValue = ctrlclass.COLUMNS - tmp - 1;
		Connect.setStone(newValue);
		return newValue;
	}
}
