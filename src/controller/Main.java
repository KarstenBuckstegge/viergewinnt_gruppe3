package controller;

import java.io.IOException;

import gui.MainGui;
import javafx.application.Application;
import javafx.stage.Stage;

import logic.KI;

public class Main extends Application {
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException, IOException {
		MainGui gui = new MainGui(null);
		gui.initialize(mainStage);
		
		
		KI ki = new KI();
		ki.createField();
		// Variablen geben Spalte und Spieler an
		
		//ki.calculateNextMove();
	}

}
