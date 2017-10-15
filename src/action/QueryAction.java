package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;

import model.Book;
import service.ExecuteSQL;

public class QueryAction extends ActionSupport {
 
	private static final long serialVersionUID = 18470275L;
	private String author;
	private List<Book> result;
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Book> getResult() {
		return result;
	}

	public void setResult(List<Book> result) {
		this.result = result;
	}

	public String execute()
    {
        ExecuteSQL mysql = new ExecuteSQL();
        String sql = "SELECT b.ISBN, b.Title FROM Author a "
        		+ "INNER JOIN Book b on a.AuthorID = b.AuthorID "
        		+ "WHERE a.Name = '" + author + '\'';
        ResultSet rs = mysql.executeQuery(sql);
    	result = new ArrayList<>();
    	try {
        	while(rs.next()) {
        		result.add( new Book(rs.getString(1), rs.getString(2)) );
        	}
		} catch (SQLException ex) {
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }
		}
        return SUCCESS;
    }
	
}