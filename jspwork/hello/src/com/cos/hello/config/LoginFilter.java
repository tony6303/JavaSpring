package com.cos.hello.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.cos.hello.dto.LoginDto;

public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("login필터 시작");
		HttpServletRequest req = (HttpServletRequest) request; //다운캐스팅
		String gubun = req.getParameter("gubun");
		
		// 유효성 (validate) 검사
				if(gubun.equals("loginProc")) {
					if(req.getParameter("username") == null ||
						req.getParameter("password") == null ||
						 req.getParameter("username").equals("")||
							req.getParameter("password").equals("")
						 ) {
						chain.doFilter(request, response);
						System.out.println("login필터 null, 공백 종료");
						return;
					} //쓸데없는 노가다 !!!!
					
					String username = req.getParameter("username");
					String password = req.getParameter("password");
					
					System.out.println("=========loginProc Start=========");
					System.out.println(username);
					System.out.println(password);
					System.out.println("=========loginProc End=========");
					
//					Users userRequest = Users.builder()  
//							.username(username)
//							.password(password)
//							.email(email)
//							.build();
					
//					Users userRequest = new Users();
//					userRequest.setUsername(username);
//					userRequest.setPassword(password);
//					request.setAttribute("user",userRequest);
					//데이터베이스에 insert 하기위한 수단
					
					
					LoginDto dto = new LoginDto();
					dto.setUsername(username);
					dto.setPassword(password);
					
					request.setAttribute("dto",dto);
				}
				
				chain.doFilter(request, response);
				System.out.println("login필터 종료");
	}
}
