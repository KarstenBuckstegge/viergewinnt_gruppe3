package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.effect.InnerShadow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		// background color
		Color bgColor = new Color(0.12, 0.12, 0.12, 1);
		
		Color highlightColor = new Color(1, 0.95, 0.66, 1);
		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setOffsetX(0);
		innerShadow.setOffsetY(0);
		innerShadow.setColor(new Color(1, 0.95, 0.66, 0.8));
		innerShadow.setRadius(30);
		// player one color gradient
		Color playerOneColor = new Color(0.62, 0.15, 0.58, 1);
		Stop[] playerOneStops = new Stop[] { new Stop(0, playerOneColor), new Stop(1, highlightColor)};
		LinearGradient playerOneGradient = new LinearGradient(0.35, 1, 0.65, 0, true, CycleMethod.NO_CYCLE, playerOneStops);
		// player one color gradient
		Color playerTwoColor = new Color(0.22, 0.62, 0.55, 1);
		Stop[] playerTwoStops = new Stop[] { new Stop(0, playerTwoColor), new Stop(1, highlightColor)};
		LinearGradient playerTwoGradient = new LinearGradient(0.35, 1, 0.65, 0, true, CycleMethod.NO_CYCLE, playerTwoStops);
		
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, bgColor);
		
		// Purple Drop
		Ellipse circleBlue = new Ellipse(50, 50);
		circleBlue.setEffect(innerShadow);
		circleBlue.setTranslateX(200);
		circleBlue.setTranslateY(200);
		circleBlue.setFill(playerOneGradient);
		
		// Purple Circle
		Ellipse circlePurple = new Ellipse(50, 50);
		circlePurple.setTranslateX(500);
		circlePurple.setTranslateY(200);
		circlePurple.setFill(playerTwoGradient);
		
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
}