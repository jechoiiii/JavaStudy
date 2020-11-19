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

			
//			// 1. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
//			// EMP : empno, ename, job, mgr, hiredate, sal, comm, deptno
//			
//			System.out.println("사원의 이름을 입력해주세요.");
//			String userEname = sc.nextLine();
//			System.out.println("사원의 업무를 입력해주세요.");
//			String userJob = sc.nextLine();
//			System.out.println("상사의 사원번호를 입력해주세요.");
//			int userMgr = sc.nextInt();
//			sc.nextLine();
//			System.out.println("사원의 입사일을 입력해주세요.");
//			String userHireDate = sc.nextLine();
//			System.out.println("사원의 급여를 입력해주세요.");
//			int userSal = sc.nextInt();
//			System.out.println("사원의 커미션을 입력해주세요.");
//			int userComm = sc.nextInt();
//			System.out.println("사원의 부서번호를 입력해주세요.");
//			int userDeptno = sc.nextInt();
//			
//			
//			// PreparedStatement 인스턴스 생성
//			String sqlInsert = "insert into emp values (seq_emp_empno.nextval,?,?,?,?,?,?,?)";		

			PreparedStatement pstmt = null;
			
//			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
//			pstmt.setString(1, userEname);
//			pstmt.setString(2, userJob);
//			pstmt.setInt(3, userMgr);
//			pstmt.setString(4, userHireDate);
//			pstmt.setInt(5, userSal);
//			pstmt.setInt(6, userComm);
//			pstmt.setInt(7, userDeptno);
//			
//			int resultCnt = pstmt.executeUpdate();		
//			if(resultCnt>0) {
//				System.out.println("데이터가 정상적으로 입력되었습니다.");
//			} else {
//				System.out.println("데이터가 입력되지 않았습니다.");
//			}
//			
//	
//			
//			// 2. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
//			
//			String sqlTable = "select * from emp order by empno";			
//			pstmt = conn.prepareStatement(sqlTable);	

			ResultSet rs = null;
			
//			ResultSet rs = pstmt.executeQuery(sqlTable);
//			
//			if(rs.next()) {
//				do {
//					System.out.print(rs.getInt(1)+"\t");
//					System.out.print(rs.getString(2)+"\t");
//					System.out.print(rs.getString(3)+"\t\t");
//					System.out.print(rs.getInt(4)+"\t");
//					System.out.print(rs.getString(5)+"\t");
//					System.out.print(rs.getInt(6)+"\t");
//					System.out.print(rs.getInt(7)+"\t");
//					System.out.print(rs.getInt(8)+"\t");		
//					System.out.println("");
//				} while(rs.next());
//			}

		
		
			// 3. “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램

			String sqlScottSal = "update emp set sal=? where ename='SCOTT'";			
			
			pstmt = conn.prepareStatement(sqlScottSal);
			
			pstmt.setInt(1, 1000);		
			//rs = pstmt.executeQuery(sqlScottSal);

			int resultCnt = pstmt.executeUpdate();		
			if(resultCnt>0) {
				System.out.println("'SCOTT' 사원의 급여를 1000으로 수정 완료");
			} else {
				System.out.println("데이터가 수정되지 않았습니다.");
			}					

			
			// 4. EMP 테이블에서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.

			String sqlScott = "select * from emp where ename='SCOTT'";
			
			pstmt = conn.prepareStatement(sqlScott);	
			rs = pstmt.executeQuery(sqlScott);
			
			if(!rs.next()) {
				System.out.println("'SCOTT' 사원에 대한 정보가 없습니다.");
			} else {
				do {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\t\t");
					System.out.print(rs.getInt(4)+"\t");
					System.out.print(rs.getString(5)+"\t");
					System.out.print(rs.getInt(6)+"\t");
					System.out.print(rs.getInt(7)+"\t");
					System.out.print(rs.getInt(8)+"\t");		
					System.out.println("");
				} while(rs.next());
			}
			
			
			
			// 5. 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
			// empno, ename, job, mgr, hiredate, sal, comm, deptno, deptno_1, dname, loc
				
			String sqlEmpDept = "select * from emp e, dept d where e.deptno=d.deptno";
			
			pstmt = conn.prepareStatement(sqlEmpDept);
			
			rs = pstmt.executeQuery(sqlEmpDept);			
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t\t");
				System.out.print(rs.getInt(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getInt(6)+"\t");
				System.out.print(rs.getInt(7)+"\t");
				System.out.print(rs.getInt(8)+"\t");
				System.out.print(rs.getInt(9)+"\t");
				System.out.print(rs.getString(10)+"\t");
				System.out.print(rs.getString(11)+"\t");
				System.out.println("");				
			}
			
					
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
