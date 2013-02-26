package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class player_drop {
	private static Integer dropSize = 50;
	private static Color highlightColor = new Color(1, 0.95, 0.66, 1);
	private Color playerColor = new Color(0.62, 0.15, 0.58, 1);
	
	public void setColor(int r, int g, int b) {
		this.playerColor.rgb(r, g, b);
	}
	
	Stop[] playerStops = new Stop[] { new Stop(0, playerColor), new Stop(1, highlightColor)};
	LinearGradient playerGradient = new LinearGradient(0.25, 1, 0.75, 0, true, CycleMethod.NO_CYCLE, playerStops);
	
	public void start(Stage stage) {
		InnerShadow innerShadow = new InnerShadow();
		innerShadow.setOffsetX(0);
		innerShadow.setOffsetY(0);
		innerShadow.setColor(new Color(1, 0.95, 0.66, 0.8));
		innerShadow.setRadius(30);
		
		// Purple Drop
		Ellipse colorCircle = new Ellipse(dropSize, dropSize);
		colorCircle.setEffect(innerShadow);
		colorCircle.setTranslateX(200);
		colorCircle.setTranslateY(200);
		colorCircle.setFill(playerGradient);
	}
}
