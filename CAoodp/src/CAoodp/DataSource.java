package CAoodp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

	String dbServer = "jdbc:mysql://52.50.23.197:3306/world";
	String user = "cctstudent";
	String password = "Pass1234!";

	private Connection conn;
	private Statement stmt;

	public DataSource() {

		try {

			// Get a connection to the database
			conn = DriverManager.getConnection(dbServer, user, password);

			// Get a statement from the connection
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet select(String query) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException se) {

			se.printStackTrace();
		}
		return rs;
	}

	public boolean save(String query) {
		try {
			stmt.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

	public void closing() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}