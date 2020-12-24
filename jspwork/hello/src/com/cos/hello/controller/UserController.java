package com.cos.hello.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
//javax 로 시작하는 패키지는 톰캣이 갖고있는 라이브러리이다.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.config.DBConnMySQL;
import com.cos.hello.config.DBConnOracle;
import com.cos.hello.dao.UsersDao;
import com.cos.hello.model.Users;
import com.cos.hello.service.UsersJoinService;

public class UserController extends HttpServlet {
	// 12월 21알 월요일
	// req , res는 톰캣이 만들어줌. (클라이언트의 요청이 있을 때 마다)
	// req는 Reader 할 수 있는 ByteStream 요청
	// res는 Writer 할 수 있는 ByteStream 응답
	// http://localhost:8000/hello/user?gubun=login

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String gubun = req.getParameter("gubun");
//		route(gubun, req, resp);
		System.out.println("doGet실행됨");
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost실행됨");
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      super.doGet(req, resp);
		System.out.println("UserController 실행됨");

		String gubun = req.getParameter("gubun");
		System.out.println(gubun);
		try {
			route(gubun, req, resp);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void route(String gubun, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {

		if (gubun.equals("login")) {
			resp.sendRedirect("auth/login.jsp");
		} else if (gubun.equals("join")) {
			resp.sendRedirect("auth/join.jsp");
		} else if (gubun.equals("selectOne")) {
			// 인증이 필요한 페이지
			String result;
			HttpSession session = req.getSession();
			if (session.getAttribute("sessionUser") != null) {
				//getAttribute : name이란 이름에 해당되는 속성값을 Object타입으로 반환합니다. 없으면 null로 반환
				Users user = (Users) session.getAttribute("sessionUser");
				result = "인증 되었습니다.";
				System.out.println("인증된 사용자입니다.");
				System.out.println(user);
			} else {
				result = "인증되지 않았습니다.";
				System.out.println("인증되지 않았습니다.");
			}
			
			req.setAttribute("result", result);
			
			// xxx.jsp로 이동할겁니다 라는 객체
			RequestDispatcher dis = req.getRequestDispatcher("user/selectOne.jsp");
			
			// 덮어쓰기
			dis.forward(req, resp);
			
//			resp.sendRedirect("/hello/user/selectOne.jsp");
			//쿠키 읽기 (클라이언트에 저장된 모든 쿠키를 읽어옴)
//			Cookie[] c = req.getCookies();
//			if (c != null) {
//				for (int i = 0; i < c.length; ++i) {
//					if (c[i].getName().equals("CookieName")) {
//						System.out.println(c[i].getName());
//						System.out.println(c[i].getValue()); // session key
//					}
//				}
//			}

		} else if (gubun.equals("updateOne")) {
			resp.sendRedirect("/hello/user/updateOne.jsp");
		} else if (gubun.equals("joinProc")) { 
			UsersJoinService usersJoinService = new UsersJoinService();
			usersJoinService.회원가입(req, resp);			
			
			HttpSession session = req.getSession();
			session.setAttribute("sessionKey", "9990");
			resp.setHeader("Set-Cookie", "sessionKey=9990");
//			resp.sendRedirect("index.jsp");

		} else if (gubun.equals("loginProc")) {
			
			//SELECT id, username, email From users where username = ? and password = ?
			//DAO 함수명 : login() , return -> Users Object
			//정상 -> 세션을 담고 index.jsp , 비정상 -> login.jsp
//					    	  new Cookie(name, value)
			//new 쿠키
			Cookie myCookie = new Cookie("CookieName", "What a delicious cookie");
			//쿠키 세팅 (안해주면 오류나더라 왜지? new하면서 초기화됬는데.) 
			myCookie.setValue("Wow");
			//쿠키 전달 (클라이언트에 저장됨)
			resp.addCookie(myCookie);

			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println("=========loginPorc Start=========");
			System.out.println(username);
			System.out.println(password);
			System.out.println("=========loginPorc End=========");
			// 2번 DB값이 있는지 select 해서 확인 (생략)
			Users user = Users.builder()
					.id(1)
					.username(username)
					.build();
			// session에는 사용자 패스워드 절대넣지않기
			// 3번 세션 키 발급
			HttpSession session = req.getSession();
			
			//setAttribute : name으로 지정한 이름에 value값을 할당합니다.
			session.setAttribute("sessionUser", user); // name , value
			
//			resp.setHeader("Set-Cookie", "sessionKey=9998");
			// 4번 index.jsp로 이동
			resp.sendRedirect("index.jsp");

		}
	}
}
