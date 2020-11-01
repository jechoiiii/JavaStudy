package phoneBookV3;

// Util 클래스 import 
import phoneBookV3.Util;

/*
	파일 이름 : phoneBookV3.PhoneBookMain.java
	내       용 : 전화번호 관리 프로그램 ver03
	수정 사항 : 
			1) 배열을 이용해 사용자 입력 정보 최대 100개까지 유지 
			2) 저장, 검색, 삭제, 출력 기능 추가 
				저장 : 이름, 전화번호, 생년월일 정보 저장  
				검색 : 이름을 입력받아 해당 데이터 출력 
				삭제 : 이름을 입력받아 해당 데이터 삭제 
				삭제 후 데이터 빈 공란 없도록 순차적으로 재정리 (삭제 대상 이후 데이터들의 주소 값이 -1 처리되어 재저장)
	작성 일시 : 2020.10.14
*/	

public class PhoneBookMain extends Util {

	public static void main(String[] args) {
		
		// PhoneBookManager 인스턴스 생성 : 클래스의 변수, 메서드 사용 가능
		PhoneBookManager manager = new PhoneBookManager();
		System.out.println("저장된 정보의 개수 : "+ manager.cnt);
		System.out.println("저장가능한 정보의 개수 : "+ manager.pBook.length);
		
		
		// Scanner 클래스 -> Util 클래스로 대체 
		// Scanner sc = new Scanner(System.in);
		
		// 프로그램 무한반복 돌리기 
		while(true) {
			
			// 프로그램 메뉴
			System.out.println("-- 전화번호 관리 프로그램 MENU --");
			System.out.println("1. 정보 저장");
			System.out.println("2. 정보 검색");
			System.out.println("3. 정보 삭제");
			System.out.println("4. 전체 정보 보기");
			System.out.println("5. 프로그램 종료");
			System.out.println("---------------------------");
			
			// 사용자로부터 메뉴 입력받기 
			char insertMenu = SC.nextLine().charAt(0); 
			
			switch(insertMenu) {
				case 1 :
					manager.insertInfo();
					break; // switch문 종료
				case 2 :
					manager.searchInfo();
					break;
				case 3 : 
					manager.deleteInfo();
					break;
				case 4 : 
					manager.showAllInfo();
					break;
				default : 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);	// System.exit(0) : 정상종료 (0이 아닌 값으로 exit하면 비정상 종료)
					break; 
			}
		}
		
	}	
}
