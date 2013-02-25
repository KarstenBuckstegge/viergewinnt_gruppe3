package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class main extends Application {
	@Override
	public void start(Stage stage) {
		Color bgColor = new Color(0.2, 0.2, 0.2, 1);
		Color playerOneColor = new Color(0, 0.5, 0.7, 1);
		Color playerTwoColor = new Color(0.5, 0, 0.7, 1);
		
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, bgColor);
		
		// Blue Circle
		Ellipse circleBlue = new Ellipse(50, 50);
		circleBlue.setTranslateX(200);
		circleBlue.setTranslateY(200);
		circleBlue.setFill(playerOneColor);
		
		// Purple Circle
		Ellipse circlePurple = new Ellipse(50, 50);
		circlePurple.setTranslateX(500);
		circlePurple.setTranslateY(200);
		circlePurple.setFill(playerTwoColor);
		
		// Exit Button
		Button exitButton = new Button("Exit");
		exitButton.setFocusTraversable(false);
		exitButton.setMinWidth(100);
		exitButton.setMinHeight(50);
		exitButton.setTranslateX(200);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Exit");
				System.exit(0);
			}
		});
		
		root.getChildren().add(circleBlue);
		root.getChildren().add(circlePurple);
		root.getChildren().add(exitButton);
		
		/*
		// Start Button
		Button startButton = new Button("Start");
		startButton.setFocusTraversable(false);
		startButton.setMinWidth(100);
		startButton.setMinHeight(50);
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Start");
			}
		});
		
		root.getChildren().add(startButton);
		*/
		
		
		
		stage.setTitle("C. R. U. Destroy");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}