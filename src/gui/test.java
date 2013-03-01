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


public class test extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	private static Integer[] fieldSize = {7, 6};
	private static Ellipse[][] stones = new Ellipse[fieldSize[0]][fieldSize[1]];
	
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		
		for (int i = 0; i < fieldSize[0]; i++) {
			for (int j = 0; j < fieldSize[1]; j++) {
				stones[i][j] = new Ellipse(25, 25);
				stones[i][j].setTranslateX(100 + 75 * i);
				stones[i][j].setTranslateY(100 + 75 * j);
				stones[i][j].setFill(Color.BLACK);
				
				root.getChildren().add(stones[i][j]);
			}
		}
		
		stage.setTitle("Battelfield Test");
		stage.setScene(scene);
		stage.show();
		
		setMove(0, 5, 2);
		setMove(1, 2, 1);
	}

	public static void setMove(int player, int column, int row) {
		Color stoneColor = Color.BLACK;
		
		if (player == 0) {
			stoneColor = Color.BLUE;
		} else {
			stoneColor = Color.RED;
		}
		
		stones[column][row].setFill(stoneColor);
	}
}