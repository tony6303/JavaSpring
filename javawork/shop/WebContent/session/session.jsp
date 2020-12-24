<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 만들기</title>
</head>
<body>
<h1>세션 만들기</h1>
<a href="../index.jsp">인덱스로 돌아가기</a><br>
<form action="/shop/session?gubun=loginProc" method="post">
	<input type="text" name="username" placeholder="id"/>
	<input type="password" name="password" placeholder="password"/>
	<button>로그인</button>
</form>
</body>
</html>