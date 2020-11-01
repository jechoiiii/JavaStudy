package phoneBookV4;

// Util 클래스 import 
import phoneBookV3.Util;

/*
	파일 이름 : phoneBookV4.PhoneBookMain.java
	내    용 : 전화번호 관리 프로그램 ver04
	수정 사항 : 1) 다음 두 클래스 PhoneUnivInfo, PhoneCompanyInfo와 CafePhoneInfo 추가로 삽입해 상속 구조로 구성
		 
							PhoneUnivInfor								PhoneCompaanyInfor
					이름			name			String			이름			name			String
					전화번호		phoneNumber		String			전화번호		phoneNumber		String
					주소			address			String			이메일		email			String
					이메일		email			String			회사			company			String
					전공			major			String
					학년			year			String
			  2) 입력 --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성
			  3) 변수 캡슐화
			
	작성 일시 : 2020.10.19
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
