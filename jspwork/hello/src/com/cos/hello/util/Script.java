package com.cos.hello.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(HttpServletResponse resp, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset=utf-8"); //UTF-8로 응답하겠다
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
	}
	
	public static void href(HttpServletResponse resp, String url, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
//		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8"); //UTF-8로 응답하겠다
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("location.href = '"+url+"';");
		out.println("</script>");
		out.flush();
	}
}
