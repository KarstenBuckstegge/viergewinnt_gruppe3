package controller;

import java.io.IOException;

import gui.MainGui;
import connect.Server_Connector;
import connect.Server_Data;
import logic.KI;
import database.CrudDb;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException, IOException {
		Server_Connector connect = new Server_Connector();
		
		MainGui gui = new MainGui(connect);
		gui.initialize(mainStage);
		
		// CrudDB db = new CrudDB();
		CrudDb db = null;
		
		KI ki = new KI(gui, connect, db);
		ki.createField();
		
		// Variablen geben Spalte und Spieler an
		
		//ki.calculateNextMove();
	}
}