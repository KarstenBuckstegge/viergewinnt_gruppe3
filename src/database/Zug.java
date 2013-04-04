package database;

public class Zug {

	/**
	 * Private Attribute erstellt. Kann nur innerhalb der Klasse Zug darauf zugegriffen werden
	 * Brauche ich nur um die zwei Werte zurückgeben zu können
	 */
	
	private int column;
	private int row;
	private int zug_id;
	private int satz_id;
	private int agent_id;
	
	public int getZug_id() {
		return zug_id;
	}
	public void setZug_id(int zug_id) {
		this.zug_id = zug_id;
	}
	public int getSatz_id() {
		return satz_id;
	}
	public void setSatz_id(int satz_id) {
		this.satz_id = satz_id;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	
}
