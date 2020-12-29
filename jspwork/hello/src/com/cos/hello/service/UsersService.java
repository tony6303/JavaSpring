package com.cos.hello.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.dao.UsersDao;
import com.cos.hello.dto.JoinDto;
import com.cos.hello.dto.LoginDto;
import com.cos.hello.model.Users;
import com.cos.hello.util.Script;

public class UsersService {
	public void 회원가입(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		JoinDto joindto = (JoinDto)req.getAttribute("dto"); // joinFilter 에서 setAttribute 함
		
		// insert 함수 실행 (sql로 데이터베이스에 insert)  
		UsersDao usersDao = new UsersDao();
		int result = usersDao.insert(joindto); //pstmt               // UserDao
		
		if(result == 1) {
//               resp.sendRedirect("auth/login.jsp");
               Script.href(resp, "auth/login.jsp", "회원가입 성공");
            } else {
//               resp.sendRedirect("auth/join.jsp");
               Script.back(resp, "회원가입 실패 -1");
            }
	}
	
	public void 로그인(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		LoginDto logindto = (LoginDto)req.getAttribute("dto"); // loginFilter 에서 setAttribute 함
		
		// login 함수 실행 (sql로 데이터베이스에 select)
//		UsersDao usersDao = new UsersDao();
		//login 의 반환형이 Users
		Users userEntity = UsersDao.getInstance().login(logindto);
		
		if(userEntity != null) {
			// session에는 사용자 패스워드 절대넣지않기
			// 3번 세션 키 발급

			// session 두 줄 이 무슨 역할 하는건가요??
			HttpSession session = req.getSession();
			//setAttribute : name으로 지정한 이름에 value값을 할당합니다.
			session.setAttribute("sessionUser", userEntity); // name , Object(value)
			
			Script.href(resp, "index.jsp", "로그인 성공123");
			//한글처리를 위해 resp객체를 건드린다.
			// mime타입
			// http header 에 context-type
			
//			resp.sendRedirect("index.jsp"); 데이터를 들고 이동하는게 아니고 그냥 페이지이동만하는 기능.(필요없음)
			
		}else {
			Script.back(resp, "로그인실패 -1");
		}
		
	}
	
	public void 유저정보보기(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		HttpSession session = req.getSession();
		
		Users users = (Users)session.getAttribute("sessionUser");
		UsersDao usersDao = new UsersDao();
		if(users != null) {
			Users userEntity = usersDao.selectById(users.getId());          // UserDao
			req.setAttribute("user", userEntity); // name , Object(value)
			
			// xxx.jsp로 이동할겁니다 라는 객체
			RequestDispatcher dis = req.getRequestDispatcher("user/selectOne.jsp");
			
			// 덮어쓰기
			dis.forward(req, resp);
			System.out.println("유저정보보기() 성공");
		}else {
			resp.sendRedirect("auth/login.jsp");
			System.out.println("유저정보보기() 실패");
		}
	}
	
	public void 유저정보수정페이지(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		HttpSession session = req.getSession();
		Users users = (Users)session.getAttribute("sessionUser");
		UsersDao usersDao = new UsersDao();
		if(users != null) {
			Users userEntity = usersDao.selectById(users.getId());           // UserDao
			req.setAttribute("user", userEntity); // name , Object(value)
			
			// xxx.jsp로 이동할겁니다 라는 객체
			RequestDispatcher dis = req.getRequestDispatcher("user/updateOne.jsp");
			
			// 덮어쓰기
			dis.forward(req, resp);
		}else {
			resp.sendRedirect("auth/login.jsp");
			System.out.println("유저정보수정페이지 실패");
		}
	}
	
	public void 유저정보수정(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		Users user = Users.builder()
				.id(id)
				.password(password)
				.email(email)
				.build();
		
		UsersDao usersDao = new UsersDao();
		int result = usersDao.update(user);       // UserDao
		
		if(result == 1) {
			resp.sendRedirect("index.jsp");
			System.out.println("유저정보수정() 성공");
		} else {
			// 실패 했을땐 이전 페이지로 이동
			
			resp.sendRedirect("user?gubun=selectOne");
			System.out.println("유저정보수정() 실패");
		}
	}
	
	public void 유저정보삭제(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UsersDao usersDao = new UsersDao();
		int result = usersDao.deleteById(id);          // UserDao
		
		req.setAttribute("user", result); // name , Object(value)
		if(result == 1) {
			System.out.println("유저정보삭제() 성공");
			
			HttpSession session = req.getSession();
			session.invalidate(); //세션 무효화
			
			resp.sendRedirect("index.jsp");
			// xxx.jsp로 이동할겁니다 라는 객체
//			RequestDispatcher dis = req.getRequestDispatcher("user/selectOne.jsp");
			// 덮어쓰기
//			dis.forward(req, resp);
		}else {
			System.out.println("유저정보삭제() 실패");
			resp.sendRedirect("user?gubun=selectOne");
		}
	}
}
