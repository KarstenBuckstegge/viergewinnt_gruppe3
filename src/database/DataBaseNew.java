package database;

//Importe
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseNew {
public static void main(String[] args)
throws SQLException, ClassNotFoundException
{
//Erstellung der Variable f�r die Verbindung
Connection con;

//Laden der Treiber
Class.forName("org.hsqldb.jdbcDriver");

//Verbindungsherstellung
con = DriverManager.getConnection("jdbc:hsqldb:file:../4wins/resources/database/dbNew","sa","");

//Variable zum Ausf�hren von SQL Statements
Statement stmt = con.createStatement();

//Variable f�r SQL Queries
String sqlQuery;

//Metadaten der Datenbank in databaseMetaData schreiben
DatabaseMetaData databaseMetaData = con.getMetaData();

//Vorhandene Tabellen in Variable rs schreiben
ResultSet rs = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});

//Pr�fen ob Tabellen bereits vorhanden, wenn nein, dann Erstellung der Tabelle
if (rs.next())
{	
System.out.println("Eine Tabelle existiert schon.\n");
}
else
{	
//Erstellung der Tabelle game
sqlQuery = "CREATE TABLE game (gameId INTEGER IDENTITY, agentName VARCHAR(255), opponentName VARCHAR(255), startPlayerName VARCHAR(255), winnerName VARCHAR(255), agentPoints INTEGER, opponentPoints INTEGER, setNr INTEGER, moveNr INTEGER, moveColumn INTEGER, moveRow INTEGER);";
stmt.executeUpdate(sqlQuery);
}
//Einf�gen der Inhalte
sqlQuery = "INSERT INTO game VALUES ('11','spieler0','spielerx','spieler0','spielerx',1,2,3,12,1,6)";
stmt.executeUpdate(sqlQuery);

//Auslesen der Inhalte und schreiben des Resultsets in rs
sqlQuery = "SELECT * FROM game";
rs = stmt.executeQuery(sqlQuery);

//Solange ein n�chster Datensatz vorhanden ist, Datensatz zeilenweise ausgeben
while (rs.next())
{
System.out.printf("%s | %s | %s | %s | %s | %s | %s | %s | %s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
}
//Datenbankverbindung schlie�en
stmt.execute("SHUTDOWN");
con.close();
} // main
} // Klasse DataBaseNew