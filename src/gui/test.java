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
	
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);
		
		Integer[] groundSize = {7, 6};
		Ellipse[][] stones = new Ellipse[groundSize[0]][groundSize[1]];
		
		for (int i = 0; i < groundSize[0]; i++) {
			for (int j = 0; j < groundSize[1]; j++) {
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
		
		stones[0][0].setFill(Color.RED);
		stones[0][1].setFill(Color.BLUE);
	}

	public void setMove(int column, int row) {
		// stones[column][row].setFill(Color.BLUE);
	}
}
