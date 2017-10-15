<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail</title>
<style type="text/css">
table.gridtable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</head>
<body>
	<s:url action="updateinput" var="updateLink">
    	<s:param name="bookBean.isbn"><s:property value="bookBean.isbn" /></s:param>
		<s:param name="bookBean.title"><s:property value="bookBean.title" /></s:param>
		<s:param name="bookBean.author"><s:property value="authorBean.name" /></s:param>
		<s:param name="bookBean.publisher"><s:property value="bookBean.publisher" /></s:param>
		<s:param name="bookBean.publishDate"><s:property value="bookBean.publishDate" /></s:param>
		<s:param name="bookBean.price"><s:property value="bookBean.price" /></s:param>
	</s:url>
	<s:url action="delete" var="deleteLink">
    	<s:param name="isbn"><s:property value="bookBean.isbn" /></s:param>
	</s:url>
	
	<script>
		function deleteConfirm() {
			if (confirm("This operation cannot be cancelled. Are you sure to continue?")) {
				window.location.href = "${deleteLink}";
			}
		}
	</script>
	<table>
		<tr>
			<td><h3>Book Information In Detail</h3></td>
			<td><a href="${updateLink}">[Edit]</a></td>
			<td><a href="javascript:void(0)" onclick="deleteConfirm()">[Delete]</a></td>
		</tr>
	</table>
	
	<table class="gridtable">
		<tr>
			<th>Properties</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>ISBN</td>
			<td><s:property value="bookBean.isbn" /></td>
		</tr>
		<tr>
			<td>Title</td>
			<td><s:property value="bookBean.title" /></td>
		</tr>
		<tr>
			<td>Author</td>
			<td><s:property value="authorBean.name" /></td>
		</tr>
		<tr>
			<td>Publisher</td>
			<td><s:property value="bookBean.publisher" /></td>
		</tr>
		<tr>
			<td>Publish Date</td>
			<td><s:property value="bookBean.publishDate" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><s:property value="bookBean.price" /></td>
		</tr>
	</table>
	<br />

	<h3>&nbsp;Author Information In Detail</h3>
	<table class="gridtable">
		<tr>
			<th>Properties</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Name</td>
			<td><s:property value="authorBean.name" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><s:property value="authorBean.age" /></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><s:property value="authorBean.country" /></td>
		</tr>
	</table>

	<p><a href="javascript:void(0)" onclick="javascript:history.back()">Return to the previous page</a></p>

	<hr />
	<s:text name="contact" />
</body>
</html>