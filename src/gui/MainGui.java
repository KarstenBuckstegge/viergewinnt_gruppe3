package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class MainGui extends Application {
	private static final int HOLE_SPACING = 90;
	private static final int COLUMNS = 7;
	private static final int ROWS = 6;
	private static final int PLAYER_XOFFSET = 37;
	private static final int PLAYER_YOFFSET = 38;
	
	private static final Image PLAYERO_IMG = new Image("/images/playerO.png", true);
	private static final Image PLAYERX_IMG = new Image("/images/playerX.png", true);
	
	private Pane gamefield = new Pane();
	
	private Color bgColor = Color.rgb(31, 31, 31);
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage mainStage) {
		// create field
		gamefield.setMaxWidth(HOLE_SPACING * COLUMNS + 50);
		gamefield.setMaxHeight(HOLE_SPACING * ROWS + 50);
		
		for (int i = 0; i < this.COLUMNS; i++) {
			for (int j = 0; j < this.ROWS; j++) {
				Image holeImage = new Image("/images/hole.png", true);
				ImageView imgView = new ImageView(holeImage);
				imgView.relocate(HOLE_SPACING * i, HOLE_SPACING * j);
				
				gamefield.getChildren().add(imgView);
			}
		}
		
		BorderPane root = new BorderPane();
		BorderPane.setAlignment(gamefield, Pos.TOP_CENTER);
		BorderPane.setMargin(gamefield, new Insets(20, 0, 0, 0));
		root.setCenter(gamefield);
		
		/*
		ImageView playerXview = new ImageView(PLAYERX_IMG);
		playerXview.relocate(PLAYER_XOFFSET + HOLE_SPACING * 2, PLAYER_YOFFSET + HOLE_SPACING * 2);
		gamefield.getChildren().add(playerXview);
		
		ImageView playerOview = new ImageView(PLAYERO_IMG);
		playerOview.relocate(PLAYER_XOFFSET + HOLE_SPACING * 5, PLAYER_YOFFSET + HOLE_SPACING * 5);
		gamefield.getChildren().add(playerOview);
		*/
		Scene scene = new Scene(root, 1000, 800, bgColor);
		mainStage.setTitle("C. R. U. Destroy");
		mainStage.setScene(scene);
		mainStage.show();
		
		setMove(0, 3, 5);
		setMove(1, 6, 5);
	}
	
	public void setMove(int player, int column, int row) {
		Image[] playerImages = new Image[2];
		playerImages[0] = PLAYERO_IMG;
		playerImages[1] = PLAYERX_IMG;
		
		ImageView playerXview = new ImageView(playerImages[player]);
		playerXview.relocate(PLAYER_XOFFSET + HOLE_SPACING * column, PLAYER_YOFFSET + HOLE_SPACING * row);
		gamefield.getChildren().add(playerXview);
	}
}
