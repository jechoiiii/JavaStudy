package phoneBookV3;

/*
	파일 이름 : phoneBookV3.PhoneBookManager.java
	내       용 : 전화번호 관리 프로그램 ver03
	수정 사항 : 
			1) 배열을 이용해 사용자 입력 정보 최대 100개까지 유지 
			2) 저장, 검색, 삭제, 출력 기능 추가 
				저장 : 이름, 전화번호, 생일 정보 저장  
				검색 : 이름을 입력받아 해당 데이터 출력 
				삭제 : 이름을 입력받아 해당 데이터 삭제 
				삭제 후 데이터 빈 공란 없도록 순차적으로 재정리 (삭제 대상 이후 데이터들의 주소 값이 -1 처리되어 재저장)
	작성 일시 : 2020.10.14
*/

public class PhoneBookManager {

	// 정보 저장을 위한 배열 선언 : 이름, 전화번호, 생일 저장
	PhoneInfo pBook[];	// PhoneInfo 타입의 배열 phoneBook
	int cnt;				// 배열의 크기 (요소의 개수)
	
	// 생성자를 이용한 배열 초기화
	PhoneBookManager(int cnt){
		// 배열 저장공간 생성 : 배열이름 = new 배열타입[배열의크기]
		pBook = new PhoneInfo[cnt];	
	}
	
	PhoneBookManager() {
		// 배열 저장공간의 크기 100으로 설정
		this(100);	
	}
	
	
	// 메서드 정의
	// 1. 정보 저장
	// 		사용자로부터 데이터 받기 -> 인스턴스 생성 -> 배열에 생성된 인스턴스의 참조값 저장
	void insertInfo() {
		
		// 사용자로부터 데이터 받기
		System.out.println("전화번호부 정보 입력을 시작합니다.");
		
		System.out.println("이름  >>> ");
		String name = Util.sc.nextLine(); 
		
		System.out.println("전화번호  >>> ");
		String phoneNum = Util.sc.nextLine();		
		
		System.out.println("생일  >>> ");
		String birthday = Util.sc.nextLine().trim(); // 공백문자열 제외하기 위해 trim()

		// 인스턴스의 참조변수 선언 & 초기화
		PhoneInfo info = null;
		
		// 인스턴스 생성
		if( birthday!=null || birthday.length()!=0 ) { 
			info = new PhoneInfo(name, phoneNum, birthday);
		} else {
			info = new PhoneInfo(name, phoneNum);
		}	
		
		// 인스턴스의 참조값 저장
		pBook[cnt++] = info;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
