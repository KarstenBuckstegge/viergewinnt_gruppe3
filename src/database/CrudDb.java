package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Die Verbindung zur Datenbank mit Connection aufbauen.
 * 
 * Öffentliches Objekt "zug" erstellt um später Züge aus der Datenbank herauslesen zu können.
 */

public class CrudDb {
	
	Connection con;
	public Zug zug;
	
	/**
	 * Der Konstruktor:
	 * Die Klasse mit Hilfe von Class.forName(); laden.
	 * Wenn die Klasse nicht geladen werden kann: throws Exception.
	 * 
	 * Treiber Manager: 
	 * Datenbanktreiber, Datenbank-URL sowie Benutzername und Passwort werden hier angegeben.
	 */
	
	public CrudDb(String crud_db) throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");
		con = DriverManager.getConnection(
				"jdbc:hsqldb:" + crud_db,
				"crud",
				"");
	}
	
	/**
	 * Methoden erstellen, die mit der Database kommunizieren.
	 * update: Database füllen
	 * select: Database-inhalte rausziehen
	 * output: Ausgabe von SELECT, Statement schließen
	 * end: Database herunterfahren
	 */	
	
	public synchronized void update(String expression) throws SQLException {
		Statement stmt = null;
		stmt = con.createStatement();
		int i = stmt.executeUpdate(expression);
		if (i == -1) {
			System.out.println("crud_db error : " + expression);
		}
		stmt.close();
	}

	public synchronized void select(String expression) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		stmt = con.createStatement();
		
		rs = stmt.executeQuery(expression);
		output(rs);
		stmt.close();
	}

	public static void output(ResultSet rs) throws SQLException {

		ResultSetMetaData meta = rs.getMetaData();
		int colmax = meta.getColumnCount();
		int i;
		Object o = null;

		while (rs.next()) {
			for (i = 0; i < colmax; ++i) {
				o = rs.getObject(i + 1);
				System.out.print(o.toString() + " ");
			}

			System.out.println(" ");
		}
	}
	
	public void end() throws SQLException {

		Statement stmt = con.createStatement();

		stmt.execute("SHUTDOWN");
		con.close();
	}

	/**
	 * Methode um Zug setzen zu können:
	 * Objekt zug wurde erstellt, um in getZug einen Rückgabewert zu erhalten
	 * Methode um Zug aus Datenbank rekonstruieren zu können
	 */	
	
	public void setZug(int column, int row) throws SQLException {
		zug = new Zug();
		zug.setColumn(column);
		zug.setRow(row);
		this.update("INSERT INTO zug(position_x, position_y) VALUES('" + column + "'," + row + ")");
	}
	
	public Zug getZug(){
		return zug;
	}
	
	/**
	 * Methode um den startspieler setzen zu können
	 */	
	
	public void setStartspieler(char startspieler) throws SQLException {
		this.update("INSERT INTO satz(startspieler) VALUES('" + startspieler + "')");
	}
	
	/**
	 * Methode um den sieger setzen zu können
	 */	
	
	public void setSieger(char sieger) throws SQLException {
		this.update("INSERT INTO satz(sieger) VALUES('" + sieger + "')");
	}
	
	/**
	 * Methode um Gegnername angeben zu können
	 */
	
	public void saveOppName(char name) throws SQLException {
		this.update("INSERT INTO agent(name) VALUES('" + name + "')");
	}
	
	public ArrayList<Agent> getAllAgents()
	{
		ArrayList<Agent> allAgents = new ArrayList<Agent>();

		String selectPlayersSQL = "SELECT agent_id, name FROM agent";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(selectPlayersSQL);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		try {
			for (; rs.next();) {
				Agent agent = new Agent();
				
				int tmpInt = (int) rs.getObject(1);
				agent.setAgent_id(tmpInt);
				
				String tmpString = (String) rs.getObject(2);
				agent.setName(tmpString);
				
				allAgents.add(agent);
				System.out.println(agent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allAgents;
	}
	
	
	public ArrayList<Spiel> getAllSpiele()
	{
		ArrayList<Spiel> allSpiele = new ArrayList<Spiel>();
		String selectSpielSQL = "SELECT spiel_id, gegner FROM spiel";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(selectSpielSQL);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		try {
			for (; rs.next();) {
				Spiel spiel = new Spiel();
				
				int tmpInt = (int) rs.getObject(1);
				spiel.setSpiel_id(tmpInt);
				
				String tmpString = (String) rs.getObject(2);
				spiel.setGegner(tmpString);
				
				allSpiele.add(spiel);
				System.out.println(spiel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allSpiele;
	}
	
	public ArrayList<Zug> getAllZuege(int spiel_id)
	{
		ArrayList<Zug> allZuege = new ArrayList<Zug>();
		String selectZugSQL = "SELECT zug_id, satz_id, agent_id, position_x, position_y " +
				"FROM zug INNER JOIN satz ON zug.satz_id = satz.satz_id " +
				"WHERE  satz.spiel_id = " + spiel_id + ".";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(selectZugSQL);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		try {
			for (; rs.next();) {
				Zug zug = new Zug();
				
				int tmpInt = (int) rs.getObject(1);
				zug.setZug_id(tmpInt);
				
				tmpInt = (int) rs.getObject(2);
				zug.setSatz_id(tmpInt);
				
				tmpInt = (int) rs.getObject(3);
				zug.setAgent_id(tmpInt);
				
				tmpInt = (int) rs.getObject(4);
				zug.setRow(tmpInt);
				
				tmpInt = (int) rs.getObject(5);
				zug.setColumn(tmpInt);
				
				allZuege.add(zug);
				System.out.println(zug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allZuege;
	}
	
	
	/**
	 * Methode zum Tabellen erstellen:
	 * Nach der UML-Datenbanknotation.
	 */	
	
	public void createTables(){

		try {
			this.update("CREATE TABLE agent(" +
					"agent_id INTEGER IDENTITY, " +
					"name CHAR)");
		
			this.update("CREATE TABLE zot_agent_satz( " +
					"agent_id INTEGER, " +
					"satz_id INTEGER, " +
					"PRIMARY KEY(agent_id, satz_id), " +
					"FOREIGN KEY(agent_id) REFERENCES agent(agent_id), " +
					"FOREIGN KEY(satz_id) REFERENCES satz(satz_id))");
		
			this.update("CREATE TABLE satz(" +
					"satz_id INTEGER IDENTITY, " +
					"spiel_id INTEGER, " +
					"startspieler INTEGER" +
					"sieger INTEGER, " +
					"FOREIGN KEY(spiel_id) REFERENCES spiel(spiel_id))");
		
			this.update("CREATE TABLE zug(" +
					"zug_id INTEGER IDENTITY, " +
					"satz_id INTEGER, " +
					"agent_id INTEGER, " +
					"position_x INTEGER, " +
					"position_y INTEGER" +
					"FOREIGN KEY(satz_id) REFERENCES satz(satz_id)" +
					"FOREIGN KEY(agent_id) REFERENCES agent(agent_id))");
		
			this.update("CREATE TABLE zot_agent_spiel(" +
					"agent_id INTEGER," +
					"spiel_id INTEGER," +
					"PRIMARY KEY(agent_id, spiel_id)," +
					"FOREIGN KEY(agent_id) REFERENCES agent(agent_id)," +
					"FOREIGN KEY(spiel_id) REFERENCES spiel(spiel_id))");
		
			this.update("CREATE TABLE spiel(" +
					"spiel_id INTEGER IDENTITY, " +
					"gegner INTEGER)");
		
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
}
