package gui;

import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

public class PlayerItem {
	private int itemSize = 20;
	private int player = 0;
	private int xPos = 0;
	private int yPos = 0;
	
	private Color[] playerPaints = new Color
	
	playerPaints[0] = Color.BLUE;
	playerPaints[1] = Color.RED;
	
	private Ellipse playerItem = new Ellipse();
	playerItem.setTranslateX(100 + 75 * i);
	playerItem.setTranslateY(100 + 75 * j);
	playerItem.setFill(this.playerOcolor);
	
	public void setItem(int player, int xPos, int yPos) {
		this.player = player;
		this.xPos = xPos;
		this.yPos = yPos;
	}
}
