package dept;

import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {

		DeptManager manager = new DeptManager(); 
	
		Scanner sc = new Scanner(System.in);
		

		try {

			// DB 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

	
			while(true) {
				System.out.println("부서관리 메뉴 입력해주세요.");
				System.out.println("1. 입력, 2. 수정, 3. 삭제, 4. 전체리스트, 5. 검색, 6. 종료");
				System.out.println("___________________________________________________");
				
				String select = sc.nextLine();
				
				switch(select.charAt(0)) {	// 간단하게 만들기 위해 첫번째 자리 숫자 받기 
					case '1':
						manager.insertDept();
						break;
					case '2':
						manager.editDept();		
						break;
					case '3':
						manager.deleteDept();	
						break;
					case '4':
						manager.listDept();	
						break;
					case '5':
						manager.searchDept();
						break;
					case '6':
						System.out.println("프로그램 종료");
						return;			
				}				
			}
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		

	}
}
