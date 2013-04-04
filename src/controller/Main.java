package controller;

import java.io.IOException;

import gui.MainGui;
import connect.Server_Connector;
import javafx.application.Application;
import javafx.stage.Stage;

import logic.KI;

public class Main extends Application {
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException, IOException {
		Server_Connector connect = new Server_Connector();
		MainGui gui = new MainGui(null);
		gui.initialize(mainStage);
		
		
		KI ki = new KI(gui, connect);
		ki.createField();
		// Variablen geben Spalte und Spieler an
		ki.setRow(6, 2);
		ki.setRow(6, 2);
		ki.setRow(5, 2);
		ki.setRow(5, 1);
		ki.setRow(5, 1);
		ki.setRow(4, 2);
		ki.setRow(4, 2);
		ki.setRow(4, 1);
		ki.setRow(3, 1);
		ki.setRow(3, 1);
		ki.setRow(2, 2);
		ki.setRow(2, 1);
		ki.setRow(2, 2);
		ki.setRow(2, 2);
		
		ki.setRow(0, 2);
		ki.setRow(0, 2);
		
		ki.calculateNextMove();
	}

}
