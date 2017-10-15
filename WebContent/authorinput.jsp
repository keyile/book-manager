<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Author Adding</title>
    <s:head />
  </head>
  <body>
    <h3>Add an author by fill this form</h3>

    <s:form action="author">
      <s:textfield name="authorBean.name" label="Name" />
      <s:textfield name="authorBean.age" label="Age" />
      <s:textfield name="authorBean.country" label="Country" />
      <s:submit/>
    </s:form>
   	<hr />
	<s:text name="contact" />
  </body>
</html>