package com.cos.hello.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.cos.hello.dto.JoinDto;
import com.cos.hello.model.Users;

public class JoinFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("join필터 시작");
		HttpServletRequest req = (HttpServletRequest) request; //다운캐스팅
		String gubun = req.getParameter("gubun");
		
		// 유효성 (validate) 검사
		if(gubun.equals("joinProc")) {
			if(req.getParameter("username") == null ||
				req.getParameter("password") == null ||
				 req.getParameter("email") == null ||
				 req.getParameter("username").equals("")||
					req.getParameter("password").equals("") ||
					 req.getParameter("email").equals("")
				 ) {
				chain.doFilter(request, response);

				System.out.println("join필터 null, 공백 종료");
				return;
			} //쓸데없는 노가다 !!!!
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			
			System.out.println("=========joinProc Start=========");
			System.out.println(username);
			System.out.println(password);
			System.out.println(email);
			System.out.println("=========joinProc End=========");
			
//			Users userRequest = Users.builder()  
//					.username(username)
//					.password(password)
//					.email(email)
//					.build();
			
//			Users userRequest = new Users();
//			userRequest.setUsername(username);
//			userRequest.setPassword(password);
//			userRequest.setEmail(email);
//			request.setAttribute("user",userRequest);
			
			JoinDto dto = new JoinDto();
			dto.setUsername(username);
			dto.setPassword(password);
			dto.setEmail(email);
			request.setAttribute("dto",dto);
			//데이터베이스에 insert 하기위한 수단
		}
		
		chain.doFilter(request, response);
		System.out.println("join필터 종료");
	}
	
}
