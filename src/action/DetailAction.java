package action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import model.Author;
import model.Book;
import service.ExecuteSQL;

public class DetailAction extends ActionSupport {
	
	private static final long serialVersionUID = 1345L;
	private Book bookBean;
	private Author authorBean;
	
	public String execute() {
		ExecuteSQL mysql = new ExecuteSQL();
		//
        String sql = "SELECT * FROM Book b INNER JOIN Author a ON a.AuthorID = b.AuthorID WHERE ISBN = '"
        		+ bookBean.getIsbn() + '\'';
        ResultSet rs = mysql.executeQuery(sql);
        try {
        	rs.next();
        	bookBean.setTitle(rs.getString(2));
        	bookBean.setAuthorID(rs.getInt(3));
        	bookBean.setPublisher(rs.getString(4));
        	bookBean.setPublishDate(rs.getString(5));
			bookBean.setPrice(rs.getDouble(6));
			authorBean = new Author(
					rs.getInt(7), 
					rs.getString(8), 
					rs.getInt(9), 
					rs.getString(10) );
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

	public Book getBookBean() {
		return bookBean;
	}

	public void setBookBean(Book bookBean) {
		this.bookBean = bookBean;
	}

	public Author getAuthorBean() {
		return authorBean;
	}

	public void setAuthorBean(Author authorBean) {
		this.authorBean = authorBean;
	}
}
