package gui;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.paint.Color;

public class PlayerItem {
	private int itemSize = 20;
	private int player = 0;
	private int xPos = 0;
	private int yPos = 0;
	
	private Color emptyPaint = Color.BLACK;
	private Color playerOpaint = Color.BLUE;
	private Color playerXpaint = Color.RED;
	
	private Ellipse playerItem;
	
	public void createItem(int player, int xPos, int yPos) {
		this.playerItem = EllipseBuilder.create()
			.centerX(xPos)
			.centerY(yPos)
			.radiusX(this.itemSize)
			.radiusY(this.itemSize)
			.fill(emptyPaint)
			.build();
	}
}
