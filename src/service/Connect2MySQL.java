package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect2MySQL {
	
	Connection conn = null;

	
    public static void loadDriver() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
    }
    
    public Connection getSQLConnection() {
    	try {
    	    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB?" +
    	                                   "user=root");
//    	    conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_bookmanager?" +
//                    "user=242mxnoxn5&password=0l20x54z5hlmhw11m4jhwhhy2hyikxljzh2143i2");
    	} catch (SQLException ex) {
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	}
    	
    	return conn;
    }
}
