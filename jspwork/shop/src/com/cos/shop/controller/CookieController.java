package com.cos.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.shop.model.Users;

public class CookieController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet실행됨");
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost실행됨");
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CookieController실행됨");
		String gubun = req.getParameter("gubun");
		System.out.println(gubun);

		route(gubun, req, resp);

	}

	private void route(String gubun, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (gubun.equals("cookie")) {
			// new Cookie(name, value)
			// new 쿠키
			Cookie myCookie = new Cookie("CookieName", "Whatadeliciouscookie");
			// 쿠키 세팅 (안해주면 오류나더라 왜지? new하면서 초기화됬는데. 공백들어가면안되는듯)
//			myCookie.setValue("ImaCookie");
			// 쿠키 전달 (클라이언트에 저장됨)
			resp.addCookie(myCookie);

			resp.sendRedirect("cookie/cookie.jsp");
		} else if (gubun.equals("cookieDelete")) {
			// 쿠키 읽기 (클라이언트에 저장된 모든 쿠키를 읽어옴)
//			Cookie[] c = req.getCookies();
//			if (c != null) {
//				for (int i = 0; i < c.length; ++i) {
//					c[i].setMaxAge(0); // 쿠키 유효시간을 0으로 설정하여 만료시킴
//					resp.addCookie(c[i]); // 쿠키 헤더에 추가시킴
//				}
//			}
			//특정 쿠키만 삭제하기
			Cookie ck = new Cookie("CookieName", null); // 특정 이름의 쿠키의 value를 null로 설정시킴
			ck.setMaxAge(0); // 쿠키 유효시간을 0으로 설정하여 만료시킴
			resp.addCookie(ck); //쿠키 헤더에 추가시킴
			
			resp.sendRedirect("cookie/cookie.jsp");
		} else if (gubun.equals("session123")) {
			// 인증이 필요한 페이지
			HttpSession session = req.getSession();
			if (session.getAttribute("sessionUser") != null) {
				// getAttribute : name이란 이름에 해당되는 속성값을 Object타입으로 반환합니다. 없으면 null로 반환
				Users user = (Users) session.getAttribute("sessionUser");
				System.out.println("인증된 사용자입니다.");
				System.out.println(user);
			} else {
				System.out.println("인증되지 않았습니다.");
			}

			resp.sendRedirect("/hello/user/selectOne.jsp");
			// 쿠키 읽기 (클라이언트에 저장된 모든 쿠키를 읽어옴)
			Cookie[] c = req.getCookies();
			if (c != null) {
				for (int i = 0; i < c.length; ++i) {
					if (c[i].getName().equals("CookieName")) {
						System.out.println(c[i].getName());
						System.out.println(c[i].getValue()); // session key
					}
				}
			}

		}else if (gubun.equals("loginProc")) { // form 의 action에서 호출 됨

			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println("=========loginPorc Start=========");
			System.out.println(username);
			System.out.println(password);
			System.out.println("=========loginPorc End=========");
			// 2번 DB값이 있는지 select 해서 확인 (생략)
			Users user = Users.builder().id(1).username(username).build();
			// session에는 사용자 패스워드 절대넣지않기
			// 3번 세션 키 발급
			HttpSession session = req.getSession();

			// setAttribute : name으로 지정한 이름에 value값을 할당합니다.
			session.setAttribute("sessionUser", user); // name , value

//			resp.setHeader("Set-Cookie", "sessionKey=9998");
			// 4번 index.jsp로 이동
			resp.sendRedirect("index.jsp");

		}
	}
}
