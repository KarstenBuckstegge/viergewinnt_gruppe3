package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;

public class player_drop {
	private static Color highlightColor = new Color(1, 0.95, 0.66, 1);
	private Color playerColor = new Color(0.62, 0.15, 0.58, 1);
	
	public void setColor(int r, int g, int b) {
		playerColor.rgb(r, g, b);
	}
	
	Stop[] playerStops = new Stop[] { new Stop(0, playerColor), new Stop(1, highlightColor)};
	LinearGradient playerGradient = new LinearGradient(0.25, 1, 0.75, 0, true, CycleMethod.NO_CYCLE, playerStops);
	
	// Purple Drop
	Ellipse colorCirc = new Ellipse(50, 50);
	//colorCircle.setEffect(innerShadow);
	//colorCirc.setTranslateX(200);
	//colorCirc.setTranslateY(200);
	//colorCirc.setFill(playerGradient);

}
