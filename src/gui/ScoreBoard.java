package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;
import javafx.scene.effect.DropShadow;


public class ScoreBoard {
	private Font scoreFont = new Font("Impact", 70);
	private Text homeScoreText = new Text("0");
	private Text guestScoreText = new Text("0");

	public ScoreBoard(BorderPane container) {
		// Glanzeffekt (weisse Kante) an oberer Kante erstellen
		InnerShadow edgeHighlight = new InnerShadow();
		edgeHighlight.setOffsetX(0);
		edgeHighlight.setOffsetY(1);
		edgeHighlight.setColor(new Color(1, 1, 1, 0.75));
		edgeHighlight.setRadius(0);
		
		// Schlagschatten erstellen
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(0);
		dropShadow.setOffsetY(1);
		dropShadow.setRadius(10);
		dropShadow.setColor(new Color(0, 0, 0, 0.75));
		// InnerShadow und DropShadow vergetten
		dropShadow.setInput(edgeHighlight);
		
		// Silberfarbverlauf erstellen
		Stop[] playerOneStops = new Stop[] { new Stop(0, new Color(1, 1, 1, 1)), new Stop(1, new Color(0.3, 0.3, 0.3, 1))};
		LinearGradient silverGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, playerOneStops);
		
		// Horizontale Box fuer Spielstandanzeige erstellen
		HBox scoreGroup = new HBox();
		scoreGroup.setEffect(dropShadow);
		
		// Text fuer eigenen Punktestand
		homeScoreText.setFont(scoreFont);
		homeScoreText.setFill(silverGradient);
		
		// Texttrenner ":" erstellen
		Text separator = new Text(":");
		separator.setFill(silverGradient);
		separator.setFont(scoreFont);
		
		// Text fuer gegnerischen Punktestand
		guestScoreText.setFill(silverGradient);
		guestScoreText.setFont(scoreFont);
		
		// Texte der Gruppe hinzufuegen
		scoreGroup.getChildren().add(homeScoreText);
		scoreGroup.getChildren().add(separator);
		scoreGroup.getChildren().add(guestScoreText);
		
		// Score Board zentrieren und dem Container hinzufuegen
		scoreGroup.setAlignment(Pos.CENTER);
		BorderPane.setMargin(scoreGroup, new Insets(20, 0, 0, 0));
		container.setTop(scoreGroup);
	}
	
	/**
	 * Setzt Spielstandanzeige fuer Home Team
	 * 
	 * @param score
	 */
	public void setHomeScore(int score) {
		homeScoreText.setText(String.valueOf(score));
	}
	
	/**
	 * Setzt Spielstandanzeige fuer Gegnerteam
	 * 
	 * @param score
	 */
	public void setGuestScore(int score) {
		guestScoreText.setText(String.valueOf(score));
	}
	
	/**
	 * Setzt gesamte Spielstandanzeige
	 * 
	 * @param homeScore
	 * @param guestScore
	 */
	public void setScore(int homeScore, int guestScore) {
		homeScoreText.setText(String.valueOf(homeScore));
		guestScoreText.setText(String.valueOf(guestScore));
	}
	
	/**
	 * Gibt den Spielstand des Heimatteams zurueck
	 * 
	 * @return
	 */
	public int getHomeScore() {
		return Integer.parseInt(homeScoreText.getText());
	}
	
	/**
	 * Gibt den Spielstand des Gegnerteams zurueck
	 * 
	 * @return
	 */
	public int getGuestScore() {
		return Integer.parseInt(guestScoreText.getText());
	}
	
	/**
	 * Gibt den kompletten Spielstand zurueck
	 * 
	 * @return score
	 */
	public int[] getScore() {
		int[] score = new int[2];
		score[0] = Integer.parseInt(homeScoreText.getText());
		score[1] = Integer.parseInt(guestScoreText.getText());
		
		return score;
	}
	
}
