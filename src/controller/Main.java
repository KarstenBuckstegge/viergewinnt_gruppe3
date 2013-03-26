package controller;

import java.io.IOException;

import gui.MainGui;
import connect.Connect;
import javafx.application.Application;
import javafx.stage.Stage;

import logic.KI;

public class Main extends Application {
	private static int tmpColumn;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException, IOException {
		Connect connect = new Connect();
		MainGui gui = new MainGui(null);
		gui.initialize(mainStage);
		
		
		KI ki = new KI(gui, connect);
		ki.createField();
		// Variablen geben Spalte und Spieler an
		ki.setRow(4, 1);
		tmpColumn = ki.calculateNextMove(1);
		System.out.println(tmpColumn);
		ki.setRow(tmpColumn, 2);
	}

}
