package action;

import com.opensymphony.xwork2.ActionSupport;
import service.ExecuteSQL;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = 132L;
	private String isbn;

	public String execute() {
		ExecuteSQL mysql = new ExecuteSQL();
		//
        String sql = "DELETE FROM Book WHERE ISBN = '"
        		+ getIsbn() + '\'';
        mysql.executeUpdate(sql);
		return SUCCESS;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
