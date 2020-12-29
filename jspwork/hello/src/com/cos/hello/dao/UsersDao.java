package com.cos.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cos.hello.config.DBConnMySQL;
import com.cos.hello.dto.JoinDto;
import com.cos.hello.dto.LoginDto;
import com.cos.hello.model.Users;

public class UsersDao {
	
	private static UsersDao instance = new UsersDao();

	public static UsersDao getInstance() {
		return instance;
	}
	//(String username,String password,String email)
	public int insert(JoinDto joindto) throws SQLException {// 회원가입수행해줘
		// 1번 form의 input태그에 있는 3가지 값 username, passeword, email받기
			
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO users(username, password, email)");
		sb.append("VALUES(?,?,?)");
		String sql = sb.toString();
		Connection conn = DBConnMySQL.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, joindto.getUsername());
			pstmt.setString(2, joindto.getPassword());
			pstmt.setString(3, joindto.getEmail());
			int result2 = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
			
//			pstmt.executeUpdate();
			 
//			return pstmt.executeUpdate();
			if(result2 == 1) {
				System.out.println("result2 : " + result2);
				System.out.println("회원가입 성공");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3번 INSERT가 정상적으로 되었다면 index.jsp
		
		return -1;
	}
	
	public Users login(LoginDto loginDto) throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, username, password, email FROM users WHERE username = ? AND password = ?");
		String sql = sb.toString();
		Connection conn = DBConnMySQL.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginDto.getUsername());
			pstmt.setString(2, loginDto.getPassword());
//			int result2 = pstmt.executeQuery(sql); // 변경된 row count를 리턴, 오류 시 -1를 리턴
//			System.out.println("result2 : " + result2);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { //출력할 행이 여러개면 while
				Users userEntity = Users.builder()
						.id(rs.getInt("id"))  //Resultset rs 에서 가져오는중 = DB에서 가져오는중
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.build();
				System.out.println("로그인 성공");
				return userEntity;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("로그인 실패");
		return null;
	}
	
	public Users selectById(int id) throws SQLException {
		StringBuffer sb = new StringBuffer(); //간단한 문장은 String 으로 , 복잡한 문장은 Buffer로
		sb.append("SELECT id, username, password, email FROM users WHERE id = ?");
		String sql = sb.toString();
		
		Connection conn = DBConnMySQL.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);			
//			int result2 = pstmt.executeQuery(sql); // 변경된 row count를 리턴, 오류 시 -1를 리턴
//			System.out.println("result2 : " + result2);		
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Users userEntity = Users.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.email(rs.getString("email"))
						.build();
				System.out.println("SelectById 성공");
				return userEntity;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SelectById 실패");
		return null;
	}
	
	
	public int update(Users users) throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE users SET password = ? , email = ?");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConnMySQL.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getPassword());
			pstmt.setString(2, users.getEmail());
			pstmt.setInt(3, users.getId());
			int result2 = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
			if(result2 == 1) {
				System.out.println("result2 : " + result2);
				System.out.println("update 성공");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("update 실패");
		return -1;
	}
	
	
	public int deleteById(int id) throws SQLException {
		StringBuffer sb = new StringBuffer(); //간단한 문장은 String 으로 , 복잡한 문장은 Buffer로
		sb.append("Delete FROM users WHERE id = ?");
		String sql = sb.toString();
		
		Connection conn = DBConnMySQL.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("deleteById 실패");
		return -1;
	}
}
