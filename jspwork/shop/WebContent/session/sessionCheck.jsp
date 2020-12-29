<%@page import="com.cos.shop.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 확인하기</title>
</head>
<body>
<h1>세션 확인하기</h1>
<a href="../index.jsp">인덱스로 돌아가기</a><br>
<%
	Users user = (Users) session.getAttribute("sessionUser");
	if(user == null){
		out.print("인증되지 않았습니다");
	}else{
		out.print("인증된 사용자입니다");
	}
%>
</body>
</html>