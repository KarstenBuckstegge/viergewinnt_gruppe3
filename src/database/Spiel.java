package database;

public class Spiel {
	private int spiel_id;
	private String gegner;
	
	public int getSpiel_id() {
		return spiel_id;
	}
	
	public void setSpiel_id(int spiel_id) {
		this.spiel_id = spiel_id;
	}
	
	public String getGegner() {
		return gegner;
	}
	
	public void setGegner(String gegner) {
		this.gegner = gegner;
	}
}