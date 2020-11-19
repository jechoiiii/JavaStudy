package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptManager {

	// 사용자 입력
	Scanner sc = new Scanner(System.in);
	
	DeptDao dao = DeptDao.getInstance(); // 싱글톤 인스턴스
		
	// 부서 입력 메서드 : 사용자에게 입력 받은 데이터를 DAO를 이용해서 DB 입력
	void insertDept() {
		
		// 부서 정보를 받아서 인스턴스를 생성하고 dao.insertDept()
		
		System.out.println("부서정보 입력 시작");
		System.out.println("부서번호 >> ");
		String deptno = sc.nextLine();
		System.out.println("부서이름 >> ");
		String dname = sc.nextLine();
		System.out.println("부서위치 >> ");
		String loc = sc.nextLine();

		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc); 
							// Integer.parseInt(): int -> 문자로 바꿔줌 // 그렇담 왜 굳이 String으로 받을까?
		
		Connection conn = null;

		// 공통 코드 ConnectionProvider 클래스로 묶기
//		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
//		String user = "bit";
//		String password = "bit";
		
		int resultCnt = 0;
		
		try {
//			conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
			
			resultCnt = dao.insertDept(dept, conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultCnt>0) {
			System.out.println("입력 완료");
		} else {
			System.out.println("입력 실패");
		}
		
		
	}
	
	
	
	// 부서 정보 수정 메서드 : 사용자에게 입력 받고 데이터를 DAO를 이용해서 수정
	void editDept() {

		System.out.println("수정하고자 하는 부서번호를 입력 >> ");
		String deptno = sc.nextLine();
		System.out.println("새로운 부서 이름 >> ");
		String dname = sc.nextLine();
		System.out.println("새로운 지역 이름 >> ");
		String loc = sc.nextLine();

		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		
		// Connection
		Connection conn = null;
		
//		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
//		String user = "bit";
//		String password = "bit";
		
		int resultCnt = 0;
		
		try {
//			conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
						
			resultCnt = dao.updateDept(dept, conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultCnt>0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
				
	}



	// 부서 정보 삭제 메서드
	void deleteDept() {

		System.out.println("삭제 원하는 부서번호 >> ");
		String deptno = sc.nextLine();
				
		// Connection
		Connection conn = null;
		
//		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
//		String user = "bit";
//		String password = "bit";
		
		int resultCnt = 0;
		try {
//			conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
			
			resultCnt = dao.deleteDept(Integer.parseInt(deptno), conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultCnt>0) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("정보가 존재하지 않아 삭제 불가");
		}	
		
	}

	
	
	// 부서 전체 리스트 출력 메서드 : Connection만 받아오면 끝
	void listDept() {
		
		// Connection
		Connection conn = null;
		
//		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
//		String user = "bit";
//		String password = "bit";
		
		List<Dept> list = null;
		
		try {
//			conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
			
			list = dao.listDept(conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(list.isEmpty()) {
			System.out.println("저장된 정보 없음");
		} else {
			
			for(Dept d: list) {
				//System.out.println(d);
				System.out.printf("%5s", d.getDeptno()+"\t");
				System.out.printf("%12s", d.getDname()+"\t");
				System.out.printf("%12s", d.getLoc()+"\n");
				
			}			
		}	
		
	}
	
	
	
	// 부서 하나 검색 메서드
	void searchDept() {
		
		System.out.println("부서 검색 시작");
		System.out.println("찾는 부서 번호 >> ");
		String deptno= sc.nextLine();
		
		// Connection
		Connection conn = null;
		
//		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
//		String user = "bit";
//		String password = "bit";
		
		Dept dept = null;
		
		try {
//			conn = DriverManager.getConnection(jdbcUrl, user, password);
			conn = ConnectionProvider.getConnection();
		
			dept = dao.searchDept(Integer.parseInt(deptno), conn);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(dept!=null) {
			System.out.println(dept);
		} else {
			System.out.println("정보가 존재하지 않아 검색 불가");
		}			
		
	}
	
	
	
	
	
	
}
