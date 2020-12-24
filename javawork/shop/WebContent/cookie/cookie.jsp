<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 먹기</title>
</head>
<body>
<h1>쿠키 확인하기</h1>
<a href="../index.jsp">인덱스로 돌아가기</a><br>
<%
Cookie cookieValue[] = request.getCookies();
    if(cookieValue != null){
    	for(int i=0; i<cookieValue.length; ++i){
    		//if(cookieValue[i].getName().equals("CookieName")){
    			out.println("Cookie Name : " + cookieValue[i].getName() +"<br>");
    			out.println("Cookie Value : " + cookieValue[i].getValue() +"<br>");
    		//}
    	}
    }
    %>
    cccc
</body>
</html>