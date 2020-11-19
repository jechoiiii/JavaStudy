package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	// 공통 코드 줄이기 위해 Connection 가져오는 새로운 클래스 생성
	
	public static Connection getConnection() throws SQLException {

		Connection conn = null;
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String user = "bit";
		String password = "bit";		

		conn = DriverManager.getConnection(jdbcUrl, user, password);	
			// 예외처리 불필요 Why? Manager에서 예외 처리 하고 있기 때문에 
		
		return conn;
		
	}

}
