package com.cos.hello.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.hello.dao.UsersDao;
import com.cos.hello.model.Users;

public class UsersJoinService {
	public void 회원가입(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		System.out.println("=========joinPorc Start=========");
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		System.out.println("=========joinPorc End=========");
		// 2번 DB에 연결해서 3가지 값을 INSERT하기
		Users user = Users.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
		
		UsersDao usersDao = new UsersDao();
		int result = usersDao.insert(user); //pstmt
		
		if(result == 1) {
               resp.sendRedirect("auth/login.jsp");
            } else {
               resp.sendRedirect("auth/join.jsp");
            }
	}
}
