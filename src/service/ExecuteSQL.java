package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSQL {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public ExecuteSQL() {
		Connect2MySQL.loadDriver();
		conn = new Connect2MySQL().getSQLConnection();
	}

	public ResultSet executeQuery(String sql) {
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int rs = 1;
		try {
		    stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			rs = 0;
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;
	}
}
