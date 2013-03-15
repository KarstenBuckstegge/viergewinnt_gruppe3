package logic;

public class KI {
	public void calcStone() {
		FindRow findrow = new FindRow();
		int column;
		int currentPlayer = 2; //Aus der GUI lesen!!!
		column = (int)(Math.random()*6);
		findrow.setStone (column, currentPlayer);
	}
}
