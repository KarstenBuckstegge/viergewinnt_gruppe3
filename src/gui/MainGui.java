package gui;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class MainGui {
	private final int COLUMNS = 7;
	private final int ROWS = 6;
	private final int HOLE_SPACING = 90;
	private final int PLAYER_XOFFSET = 37;
	private final int PLAYER_YOFFSET = 38;
	
	private final Image PLAYERO_IMG = new Image("/images/playerO.png", true);
	private final Image PLAYERX_IMG = new Image("/images/playerX.png", true);
	
	private Pane gamefield = new Pane();
	
	private Color bgColor = Color.rgb(31, 31, 31);
	
	// Entscheidungs Gruppe fuer Spielerentscheidung erstellen
	final ToggleGroup togglePlayerGroup = new ToggleGroup();
	
	/**
	 * Baut das Hauptfenster mit Spielfeld und Steuerelementen auf
	 * 
	 * @param mainStage
	 */
	public void initialize(Stage mainStage)
	{
		// Spielfeld definieren
		gamefield.setMaxWidth(HOLE_SPACING * COLUMNS + 50);
		gamefield.setMaxHeight(HOLE_SPACING * ROWS + 50);
		// Soielfeld aufbauen
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				Image holeImage = new Image("/images/hole.png", true);
				ImageView imgView = new ImageView(holeImage);
				imgView.relocate(HOLE_SPACING * i, HOLE_SPACING * j);
				
				gamefield.getChildren().add(imgView);
			}
		}
		// Hauptlayout festelgen (Top, Bottom, Left, Right, Center)
		BorderPane root = new BorderPane();
		BorderPane.setAlignment(gamefield, Pos.TOP_CENTER);
		BorderPane.setMargin(gamefield, new Insets(20, 0, 0, 0));
		root.setCenter(gamefield);
		
		// Neue Spielstandanzeige erstellen
		final ScoreBoard score = new ScoreBoard(root);
		
		// Honrizontale Box fuer Steuerelemente erstellen
		HBox controlGroup = new HBox();
		controlGroup.setSpacing(20);
		
		// Vertikale Box fuer Benutzereingaben erstellen
		VBox userInputVBox = new VBox();
		userInputVBox.setSpacing(10);
		// RadioButton fuer Spieler O erstellen
		RadioButton playerO = new RadioButton("Spieler O");
		playerO.setToggleGroup(togglePlayerGroup);
		playerO.setSelected(true);
		playerO.setUserData(0);
		playerO.setTextFill(Color.WHITE);
		userInputVBox.getChildren().add(playerO);
		// RadioButton fuer Spieler X erstellen
		RadioButton playerX = new RadioButton("Spieler X");
		playerX.setToggleGroup(togglePlayerGroup);
		playerX.setUserData(1);
		playerX.setTextFill(Color.WHITE);
		userInputVBox.getChildren().add(playerX);
		// Eingabefeld fuer Verzeichnisangabe erstellen
		TextField directoryInput = new TextField();
		userInputVBox.getChildren().add(directoryInput);
		
		controlGroup.getChildren().add(userInputVBox);
		
		// Start Button erstellen
		Button startButton = new Button("Start");
		startButton.setPrefSize(200, 50);
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int player = getSelectedPlayer();
				setMove(player, 5, 5);
				score.setHomeScore(score.getHomeScore() + 1);
			}
		});
		controlGroup.getChildren().add(startButton);
		// Beenden Button erstellen
		Button exitButton = new Button("Beenden");
		exitButton.setPrefSize(200, 50);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Beenden");
				System.exit(0);
			}
		});
		controlGroup.getChildren().add(exitButton);
		
		
		// Steuergruppe dem "Center" Bereich zuweisen
		BorderPane.setAlignment(controlGroup, Pos.CENTER);
		BorderPane.setMargin(controlGroup, new Insets(20, 20, 20, 20));
		root.setBottom(controlGroup);
		
		Scene scene = new Scene(root, 1000, 800, bgColor);
		mainStage.setTitle("4wins");
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	/**
	 * Zeichnet einen Spielerstein an die uebergebene Position (Koordinate)
	 * 
	 * @param player Integer
	 * @param column Integer
	 * @param row Integer
	 */
	public void setMove(int player, int column, int row) {
		Image[] playerImages = new Image[3];
		playerImages[1] = PLAYERO_IMG;
		playerImages[2] = PLAYERX_IMG;
		
		ImageView playerXview = new ImageView(playerImages[player]);
		playerXview.relocate(PLAYER_XOFFSET + HOLE_SPACING * column, PLAYER_YOFFSET + HOLE_SPACING * row);
		gamefield.getChildren().add(playerXview);
	}
	
	public int getSelectedPlayer() {
		return (Integer) togglePlayerGroup.getSelectedToggle().getUserData();
	}
}
