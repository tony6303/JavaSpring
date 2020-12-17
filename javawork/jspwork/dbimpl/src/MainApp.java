import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Dept;

public class MainApp {

	

	// 함수로 모듈화
	public static void 추가(int id) {
//		String sql = "INSERT INTO test1(id) VALUES("+id+")"; //이렇게하면 인젝션 뚫림
		String sql = "INSERT INTO test1(id) VALUES(?)";
		Connection conn = DBConnection.getinstance();
		// Byte Stream (?)

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 첫번째 '?' 부분에 id를 넣겠다.
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
			System.out.println("result : " + result);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 함수로 모듈화
	public static void 삭제(int id) {
		String sql = "DELETE FROM test1 WHERE id = ?";
		Connection conn = DBConnection.getinstance();
		// Byte Stream (?)

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 첫번째 '?' 부분에 id를 넣겠다.
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
			System.out.println("result : " + result);
//			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 함수로 모듈화
	public static void 수정(int id) {
		String sql = "UPDATE test1 SET 4 WHERE id = ?";
		Connection conn = DBConnection.getinstance();
		// Byte Stream (?)

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 첫번째 '?' 부분에 id를 넣겠다.
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
			System.out.println("result : " + result);
//			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 함수로 모듈화 , 사용자 scott으로 변경해야함
	// return값 Dept
	public static Dept 찾기(int deptno) {
		String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno=?";
		Connection conn = DBConnection.getinstance();
		// Byte Stream (?)

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // 첫번째 '?' 부분에 id를 넣겠다.
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
				System.out.println(dept);
				return dept;
//				int deptno2 = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				System.out.println(deptno2);
//				System.out.println(dname);
//				System.out.println(loc);
			}

//			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
//			System.out.println("result : " + result);
//			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	// 함수로 모듈화 , 사용자 scott으로 변경해야함
	// return값 Dept
	public static List<Dept> 전체찾기() {
		String sql = "SELECT deptno, dname, loc FROM dept";
		Connection conn = DBConnection.getinstance();
		// Byte Stream (?)

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, deptno); // 첫번째 '?' 부분에 id를 넣겠다.
			ResultSet rs = pstmt.executeQuery();
			
			List<Dept> listDept = new ArrayList<Dept>();
			while(rs.next()) {
				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
				System.out.println(dept); //toString() 작동 ?
				
				//컬렉션에 담기
				listDept.add(dept);
				return listDept;
			}

//			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴, 오류 시 -1를 리턴
//			System.out.println("result : " + result);
//			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
//		추가(9);
//		삭제(1);
//		찾기(10);
//		Dept dept = 찾기(10);
		List<Dept> listDept = 전체찾기();
	}
}
