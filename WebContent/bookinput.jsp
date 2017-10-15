<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Book Adding</title>
    <s:head />
  </head>
  <body>
    <h3>Add a book by completing this form.</h3>
	<s:if test="noAuthor">
		<a href="<s:url action='authorinput'/>" target="_blank">Click here to add an author.</a>
	</s:if>
    <s:form action="book">
      <s:textfield name="bookBean.isbn" label="ISBN" />
      <s:textfield name="bookBean.title" label="Title" />
      <s:textfield name="bookBean.author" label="Author" />
      <s:textfield name="bookBean.publisher" label="Publisher" />
      <s:textfield name="bookBean.publishDate" label="Publish Date" />
      <s:textfield name="bookBean.price" label="Price" />
      <s:submit/>
    </s:form>
	
	<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
	<hr />
	<s:text name="contact" />
  </body>
</html>