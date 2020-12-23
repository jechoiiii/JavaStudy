package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() {
		
		Connection conn=null;
		
		// DB 연결 : Connection 객체를 얻어온다.
	 	String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
	 	String user = "aia";
	 	String password = "aia";
	 	
	 	try {
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection 객체 생성 성공 !");
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패 !");
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
