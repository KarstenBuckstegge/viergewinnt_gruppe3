package gui;

public class Connect {
	public void setPlayerID(int player) {
		System.out.println("Spieler " + player + " ausgewaehlt");
	}
	
	public void startGame() {
		System.out.println("Spiel gestartet");
	}
	
	public void setTransferDirectory(String folderPath) {
		System.out.println("Transferverzeichnis auf '" + folderPath + "' gesetzt");
	}
}
