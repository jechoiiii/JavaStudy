package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOracleEMP {

	public static void main(String[] args) {

/*
		1. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
		2. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
		3. EMP 테이블에서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
		4. EMP 테이블에서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
		5. 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
 */

		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 연결 
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스에 접속했습니다.");
			
			// Statement 인스턴스 생성
			Statement stmt = conn.createStatement();
			
			System.out.println("사원의 이름을 입력해주세요.");
			String userEname = sc.nextLine();
			System.out.println("사원의 업무를 입력해주세요.");
			String userJob = sc.nextLine();
			System.out.println("상사의 사번을 입력해주세요.");
			int userMgr = sc.nextInt();
			sc.nextLine();
			System.out.println("사원의 입사일을 입력해주세요.");
			String userHireDate = sc.nextLine();
			System.out.println("사원의 급여를 입력해주세요.");
			int userSal = sc.nextInt();
			System.out.println("사원의 커미션을 입력해주세요.");
			int userComm = sc.nextInt();
			System.out.println("사원의 부서번호를 입력해주세요.");
			int userDeptno = sc.nextInt();
			
			
			// PreparedStatement 인스턴스 생성
			String sqlInsert = "insert into dept values (seq_emp_empno.nextval,?,?,?,?,?,?,?)";
			
			// 1. EMP 테이블에 새로운 사원 정보 입력
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, userEname);
			pstmt.setString(2, userJob);
			pstmt.setInt(3, userMgr);
			pstmt.setString(4, userHireDate);
			pstmt.setInt(5, userSal);
			pstmt.setInt(6, userComm);
			pstmt.setInt(7, userDeptno);
			
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("데이터가 정상적으로 입력되었습니다. ");
			} else {
				System.out.println("데이터가 입력되지 않았습니다.");
			}
			
			// 2. EMP 테이블의 모든 데이터 출력
			String sql = "select * from emp order by empno";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);

			
			// 3. “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램

			
			
			
			
			
			rs.close();
			pstmt.close();			
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로드 실패");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
