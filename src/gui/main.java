package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) throws InterruptedException {
		MainGui gui = new MainGui();
		gui.initialize(mainStage);
		
		gui.setMove(1, 3, 5);
	}
}