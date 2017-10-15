package action;


import com.opensymphony.xwork2.ActionSupport;

import model.Author;
import service.ExecuteSQL;

public class AddAuthor extends ActionSupport{

	private static final long serialVersionUID = 13L;
	private Author authorBean;

	public void validate(){
		if (authorBean.getName().length() == 0) {
			addFieldError("authorBean.name", "Name is required.");
		} 

		if (authorBean.getAge() == 0) {
			addFieldError("authorBean.age", "Age is required.");
		}

		if (authorBean.getCountry().length() == 0) {
			addFieldError("authorBean.country", "Country is required.");
		}
	}
	
	public String execute() {
		ExecuteSQL mysql = new ExecuteSQL();
		//
        String sql = "INSERT INTO Author VALUES (NULL, '"
        		+ authorBean.getName() + "\' , "
        		+ authorBean.getAge() + ", \'"
        		+ authorBean.getCountry() + "\')";
        mysql.executeUpdate(sql);
		return SUCCESS;
	}

	public Author getAuthorBean() {
		return authorBean;
	}

	public void setAuthorBean(Author authorBean) {
		this.authorBean = authorBean;
	}
}
