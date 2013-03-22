package controller;

import gui.MainGui;
import javafx.application.Application;
import javafx.stage.Stage;

import logic.KI;

public class Main extends Application {
	private static int tmpColumn;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException {
		MainGui gui = new MainGui();
		gui.initialize(mainStage);
		
		KI ki = new KI(gui);
		ki.createField();
		// Variablen geben Spalte und Spieler an
		ki.setRow(4, 1);
		tmpColumn = ki.calculateNextMove(1);
		System.out.println(tmpColumn);
		ki.setRow(tmpColumn, 2);
	}

}
