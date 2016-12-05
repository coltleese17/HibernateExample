<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.leese.hibernate1.Book"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
</head>
<body>
	<h1>You added this book: </h1>

	<P>Title: "${title }"</P>
	<p>Author: "${author }" </p>
	<p>Publisher: "${publisher }" </p>
	<p>Sales: "${sales }" </p>
	<ol>
	</ol>
	</p>
<a href="./list">Back to List</a> |
<a href="./">Back to home</a> |
<a href="./resources/BookForm.html"> add another book?</a>
</body>
</html>