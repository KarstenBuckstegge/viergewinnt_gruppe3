package gui;

import connect.Server_Connector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.DirectoryChooser;

public class MainGui {
	private final int COLUMNS = 7;
	private final int ROWS = 6;
	private final int HOLE_SPACING = 90;
	private final int PLAYER_XOFFSET = 37;
	private final int PLAYER_YOFFSET = 38;
	
	private final Image PLAYERO_IMG = new Image("/images/playerO.png", true);
	private final Image PLAYERX_IMG = new Image("/images/playerX.png", true);
	
	private int homePlayer = 0;
	
	private Server_Connector connect = null;
	
	// Liste aller gesetzten Spielsteine erstellen
	private ArrayList<ImageView> playerItems = new ArrayList<ImageView>();
	
	private Pane gamefield = new Pane();
	
	private Color bgColor = Color.rgb(31, 31, 31);
	
	// Entscheidungs Gruppe fuer Spielerentscheidung erstellen
	final ToggleGroup togglePlayerGroup = new ToggleGroup();
	
	// Klassenkonstruktor
	public MainGui(Server_Connector connect) {
		this.connect = connect;
	}
	
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
		playerO.setUserData(1);
		playerO.setTextFill(Color.WHITE);
		userInputVBox.getChildren().add(playerO);
		
		// RadioButton fuer Spieler X erstellen
		RadioButton playerX = new RadioButton("Spieler X");
		playerX.setToggleGroup(togglePlayerGroup);
		playerX.setUserData(2);
		playerX.setTextFill(Color.WHITE);
		userInputVBox.getChildren().add(playerX);
		
		// Eventlistener fuer Spielerauswahl erstellen
		togglePlayerGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (togglePlayerGroup.getSelectedToggle() != null) {
					setSelectedPlayer();
				}
			}
		});
		
		/*
		// Eingabefeld fuer Verzeichnisangabe erstellen
		TextField directoryInput = new TextField();
		userInputVBox.getChildren().add(directoryInput);
		*/
		controlGroup.getChildren().add(userInputVBox);
		
		// Verzeichnisauswahl Button erstellen
		Button chooseFolderButton = new Button("Verzeichnis waehlen");
		chooseFolderButton.setPrefSize(200, 50);
		chooseFolderButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				chooseTransferDirectory();
			}
		});
		controlGroup.getChildren().add(chooseFolderButton);
		
		// Neuer Satz Button erstellen
		Button resetButton = new Button("Neuer Satz");
		resetButton.setPrefSize(200, 50);
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				resetGame();
			}
		});
		controlGroup.getChildren().add(resetButton);
		
		// Start Button erstellen
		Button startButton = new Button("Spielen");
		startButton.setPrefSize(200, 50);
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					connect.startGame();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setMove(homePlayer, 5, 5);
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
		playerItems.add(playerXview);
	}
	
	/**
	 * Setzt den ausgewaehlten Spieler und uebergibt ihn dem Connect
	 */
	private void setSelectedPlayer() {
		this.homePlayer = (Integer) togglePlayerGroup.getSelectedToggle().getUserData();
		connect.setPlayerID(this.homePlayer);
	}
	
	/**
	 * Transfverzeichnis auswaehlen 
	 */
	private void chooseTransferDirectory() {
		File transferDirectory = null;
		
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		//Show open file dialog
		transferDirectory = directoryChooser.showDialog(null);
		
		connect.setTransferDirectory(transferDirectory.getPath());
	}
	
	/**
	 * setzt das Spielfeld zurueck
	 */
	private void resetGame() {
		gamefield.getChildren().removeAll(playerItems);
	}
}
