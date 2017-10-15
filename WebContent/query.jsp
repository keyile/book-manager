<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
    <h3>The query request has been finished.</h3>
    <s:if test="result.length > 1">
		<p>Here are the books authored by <em><s:property value="author" /></em> : </p>
	</s:if>
	<s:else>
		<p>There is not any recorded book by author <em><s:property value="author" /></em> .</p>
	</s:else>
	<ul>
		<s:iterator value="result">
			<s:url action="detail" var="detailLink">
				<s:param name="bookBean.isbn"><s:property value="isbn" /></s:param>
			</s:url>
			<li><a href="${detailLink}"><s:property value="title" /></a></li>
		</s:iterator>
	</ul>

	<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
	<hr />
	<s:text name="contact" />
</body>
</html>