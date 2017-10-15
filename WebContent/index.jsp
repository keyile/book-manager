<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome To Book Manager System !</h1>
	<p>Start your operation here: </p>
	<ul>
	<li><a href="<s:url action='bookinput'/>">Add a Book</a></li>
	</ul>

	<p>Start your book querying by filling out and submitting this
		form.</p>

	<s:form action="query">
		<s:textfield name="author" label="Author name" />
		<s:submit value="Submit" />
	</s:form>
	<s:url action="info" var="infoLink" />
	<p>
		<a href="${infoLink}">Click here</a> to learn more
		about this system.
	</p>
	<hr />
	<s:text name="contact" />
</body>
</html>
