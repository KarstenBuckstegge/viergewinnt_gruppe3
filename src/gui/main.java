package gui;

import javafx.application.Application;
import javafx.stage.Stage;
//import connect.Connect;

public class main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException {
		Connect connect = new Connect();
		MainGui gui = new MainGui(connect);
		gui.initialize(mainStage);
		
		gui.setMove(1, 3, 5);
	}
}