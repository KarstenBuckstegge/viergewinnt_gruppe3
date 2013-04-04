package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import connect.Server_Connector;

public class main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException {
		Server_Connector connect = new Server_Connector();
		MainGui gui = new MainGui(connect);
		
		gui.initialize(mainStage);
		
		gui.setMove(1, 3, 5);
	}
}