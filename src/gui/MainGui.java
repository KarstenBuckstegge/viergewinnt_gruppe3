package gui;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainGui {
	private static final int HOLE_SPACING = 90;
	private static final int COLUMNS = 7;
	private static final int ROWS = 6;
	private static final int PLAYER_XOFFSET = 37;
	private static final int PLAYER_YOFFSET = 38;
	
	private static final Image PLAYERO_IMG = new Image("/images/playerO.png", true);
	private static final Image PLAYERX_IMG = new Image("/images/playerX.png", true);
	
	private static Pane gamefield = new Pane();
	
	private static Color bgColor = Color.rgb(31, 31, 31);
	
	public static void initialize(Stage mainStage)
	{
		// create field
		gamefield.setMaxWidth(HOLE_SPACING * COLUMNS + 50);
		gamefield.setMaxHeight(HOLE_SPACING * ROWS + 50);
		
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
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
		mainStage.setTitle("4wins");
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	public static void setMove(int player, int column, int row) {
		Image[] playerImages = new Image[2];
		playerImages[0] = PLAYERO_IMG;
		playerImages[1] = PLAYERX_IMG;
		
		ImageView playerXview = new ImageView(playerImages[player]);
		playerXview.relocate(PLAYER_XOFFSET + HOLE_SPACING * column, PLAYER_YOFFSET + HOLE_SPACING * row);
		gamefield.getChildren().add(playerXview);
	}
}
