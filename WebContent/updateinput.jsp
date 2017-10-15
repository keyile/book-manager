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
    <h3>Register for a prize by completing this form.</h3>
    <s:if test="noAuthor">
		<a href="<s:url action='authorinput'/>" target="_blank">Click here to add an author.</a>
	</s:if>
    <s:form action="update">
      <s:textfield name="bookBean.isbn" label="ISBN" />
      <s:textfield name="bookBean.title" label="Title" />
      <s:textfield name="bookBean.author" label="Author" />
      <s:textfield name="bookBean.publisher" label="Publisher" />
      <s:textfield name="bookBean.publishDate" label="Publish Date" />
      <s:textfield name="bookBean.price" label="Price" />
      <s:set name="toTrans" value="oldIsbn"></s:set>
      <s:hidden name="oldIsbn" value="oldIsbn" />
      <s:submit />
    </s:form>
    <s:if test="noAuthor">
		<a href="<s:url action='authorinput'/>" target="_blank">Click here to add an author.</a>
	</s:if>
   	<hr />
	<s:text name="contact" />
  </body>
</html>