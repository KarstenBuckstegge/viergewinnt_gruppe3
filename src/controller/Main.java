package controller;

import java.io.IOException;

import gui.MainGui;
<<<<<<< HEAD
=======
import connect.Server_Connector;
>>>>>>> - Datenbank hinzugefuegt
import javafx.application.Application;
import javafx.stage.Stage;

import logic.KI;

public class Main extends Application {
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException, IOException {
<<<<<<< HEAD
		MainGui gui = new MainGui(null);
=======
		Server_Connector connect = new Server_Connector();
		MainGui gui = new MainGui(connect);
>>>>>>> - Datenbank hinzugefuegt
		gui.initialize(mainStage);
		
		
		KI ki = new KI();
		ki.createField();
		// Variablen geben Spalte und Spieler an
		
		//ki.calculateNextMove();
	}

}
