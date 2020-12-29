package com.cos.hello.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter{

   
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
	   //web.xml에서 필터를 등록하면 모든 요청과 모든응답에 필터가 실행된다.
   System.out.println("필터 걸림!! doFilter 실행 전");
   request.setCharacterEncoding("UTF-8"); // 니가 [요청]하는 모든 파일을 utf-8로 읽을께

    //response.setHeader("content-type", "text/html; charset=utf-8"); 아래 코드랑 같은것
   response.setContentType("text/html; charset=UTF-8"); // 내가응답하는 모든파일을 UTF-8로 [응답]할께
                   // 다른 페이지에서 Json파일로 응답하려면 해당 페이지에서 Type을 application/json으로 바꿔준다 
   chain.doFilter(request, response); //다음 필터로 이동함, 다음필터가 없다면 원래 이동해야할 곳으로 간다.
   System.out.println("doFilter 실행 후");
   }
}