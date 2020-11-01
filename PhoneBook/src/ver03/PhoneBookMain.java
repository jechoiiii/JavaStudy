package ver03;

/*
	파일 이름 : ver03.java
	내용 : 전화번호부 프로그램 흐름
	작성 일시 : 2020.10.14
*/

public class PhoneBookMain {

	public static void main(String[] args) {
		
/* 		<전화번호 관리 프로그램 v03의 클래스 구분>
		PhoneInfo : 한 명의 정보 저장
		PhoneBookMain : 프로그램 흐름
		PhoneBookManager : 기능/메서드
*/
		
		// PhoneBookManager 인스턴스 생성 : 배열과 메서드 사용		
			// @메모리 - PhoneBook 배열, (cnt)0, insert/search/delete/displayall 메서드, searchIndex메서드을 위한 공간이 각각 생김
		PhoneBookManager manager = new PhoneBookManager(); // 참조클래스 참조변수 = new 참조클래스();
		System.out.println("현재 저장된 정보의 개수 : " + manager.cnt); // 참조클래스에 있는 변수 cnt 참조한다
		System.out.println("저장이 가능한 정보의 총 개수 : " + manager.phoneBook.length);  // 참조클래스에 있는 phoneBook배열의 길이를 참조한다 
																					// .length : 배열의 길이, .length() : 문자열의 길이
		
//		Scanner sc = new Scanner(System.in); // Scanner는 항상 초기화할 것
		 
		while(true) { // 무한반복
		
			System.out.println();
			System.out.println("전화번호 관리 프로그램 ===================");
			System.out.println("메뉴를 입력하세요.");
			System.out.println(" 1. 정보 저장 ");
			System.out.println(" 2. 정보 검색 ");
			System.out.println(" 3. 정보 삭제 ");
			System.out.println(" 4. 전체 정보 보기 ");
			System.out.println(" 5. 프로그램 종료 ");
			System.out.println("====================================");
			
			
			char insertMenu = Util.SC.nextLine().charAt(0);
				// 0~n까지의 index에 해당하는 문자를 입력하는게 문자형 insertMenu 변수이다
				// 공백이 들어가면 문자열이 변환이 잘 안됨. 
			
			switch(insertMenu) {
				case '1' : // '1' 입력 시 insert메서드 실행
					manager.insertMember();
					break; 
						// 왜 break 걸어줘야할까? 그냥 형식임
				case '2' :
					manager.searchMember();
					break;
				case '3' :
					manager.deleteMember();
					break;
				case '4' :
					manager.displayAll();
					break;
				case '5' :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0); 
						// 왜 0일까? System.exit(0)이 정상종료. 0이 아닌 값으로  exit하면 비정상 종료
					break;	
			}

		}
		
		
		
		
		
		
	}

}
