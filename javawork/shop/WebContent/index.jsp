<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    String contextPath = request.getContextPath();
    out.println("contextPath : " + contextPath +"<br>");
    
    Cookie cookieValue[] = request.getCookies();
    if(cookieValue != null){
    	for(int i=0; i<cookieValue.length; ++i){
    		if(cookieValue[i].getName().equals("CookieName")){
    			out.println("Cookie Name : " + cookieValue[i].getName() +"<br>");
    			out.println("Cookie Value : " + cookieValue[i].getValue() +"<br>");
    		}
    	}
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션 실습</title>
</head>
<body>
	<h1>쿠키, 세션 실습</h1>
	</hr>
	<ul>
		<li><a href="<%=contextPath %>/index.jsp">인덱스</a></li>
		<li><a href="<%=contextPath %>/cookie?gubun=cookie">쿠키먹기</a></li>
		<li><a href="<%=contextPath %>/session?gubun=session">세션만들기</a></li>
		<li><a href="<%=contextPath %>/cookie?gubun=cookieDelete">쿠키 지우기</a></li>
		<li><a href="<%=contextPath %>/session?gubun=sessionDelete">세션 지우기</a></li>
	</ul>
</body>
</html>