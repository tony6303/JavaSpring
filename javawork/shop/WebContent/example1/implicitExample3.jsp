<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String memo = request.getParameter("memo");
	Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>193쪽 예제 3번</title>
</head>
<body>
<h2>메모장</h2>
<table border="1">
	<tr>
		<td>성명</td>
		<td><%=name %></td>
	</tr>
	<tr>
		<td>메모</td>
		<td><%=memo %></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><%=date.toLocaleString() %></td>
	</tr>
</table>
</body>
</html>