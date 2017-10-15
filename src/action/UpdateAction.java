package action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import model.Book;
import service.ExecuteSQL;

public class UpdateAction extends ActionSupport{

	private static final long serialVersionUID = 12394453L;
	private Book bookBean;
	private String oldIsbn;
	private boolean noAuthor = false;
	
	public void validate(){
		if (bookBean.getAuthor().length() == 0) {
			addFieldError("bookBean.author", "Author is required.");
		} 
		else {
			ExecuteSQL mysql = new ExecuteSQL();
			String sql = "SELECT AuthorID FROM Author WHERE Name = '" + bookBean.getAuthor() + '\'';
			ResultSet rs = mysql.executeQuery(sql);
			try {
				if (rs.next()) {
					bookBean.setAuthorID(rs.getInt(1));
				} else {
					addFieldError("bookBean.author", "Author is not exsited.");
					noAuthor = true;
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
				}
			}
		}
		if (bookBean.getIsbn().length() == 0) {
			addFieldError("bookBean.isbn", "ISBN is required.");
		}

		if (bookBean.getTitle().length() == 0) {
			addFieldError("bookBean.title", "Title is required.");
		}
		if (bookBean.getPublisher().length() == 0) {
			addFieldError("bookBean.publisher", "Title is required.");
		}
		if (bookBean.getPublishDate().length() == 0) {
			addFieldError("bookBean.publishDate", "Title is required.");
		}
		if (bookBean.getPrice() == 0) {
			addFieldError("bookBean.price", "Title is required.");
		}
	}
	
	public String input() {
		oldIsbn = bookBean.getIsbn();
		return INPUT;
	}
	
	public String execute() {
		ExecuteSQL mysql = new ExecuteSQL();
		//
		String sql = "DELETE FROM Book WHERE ISBN = '"
        		+ oldIsbn + '\'';
		System.out.println(sql);
        mysql.executeUpdate(sql);
        sql = "INSERT INTO Book VALUES ('"
        		+ bookBean.getIsbn() + "\' , \'"
        		+ bookBean.getTitle() + "\' , "
        		+ bookBean.getAuthorID() + ", \'"
        		+ bookBean.getPublisher() + "\' , \'"
        		+ bookBean.getPublishDate() + "\' , "
        		+ bookBean.getPrice() + " )";
		System.out.println(sql);
        mysql.executeUpdate(sql);
		return SUCCESS;
	}

	public Book getBookBean() {
		return bookBean;
	}

	public void setBookBean(Book bookBean) {
		this.bookBean = bookBean;
	}

	public String getOldIsbn() {
		return oldIsbn;
	}

	public void setOldIsbn(String oldIsbn) {
		this.oldIsbn = oldIsbn;
	}

	public boolean isNoAuthor() {
		return noAuthor;
	}

	public void setNoAuthor(boolean noAuthor) {
		this.noAuthor = noAuthor;
	}

}
