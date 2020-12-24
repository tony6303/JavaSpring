<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<h1>userInfo Page</h1>

<%
	String result = (String)request.getAttribute("result");
%>
<%=result %>

<h1>${result}</h1> 
</body>
</html>