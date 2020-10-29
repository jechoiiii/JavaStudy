package phoneBookV3;

public class PhoneInfo1 {

/*
	파일 이름 : phoneBookV3.PhoneInfo.java
	내       용 : 전화번호 관리 프로그램 ver03
	수정 사항 : 
			1) 배열을 이용해 사용자 입력 정보 최대 100개까지 유지 
			2) 저장, 검색, 삭제, 출력 기능 추가 
				저장 : 이름, 전화번호, 생년월일 정보 저장  
				검색 : 이름을 입력받아 해당 데이터 출력 
				삭제 : 이름을 입력받아 해당 데이터 삭제 
				삭제 후 데이터 빈 공란 없도록 순차적으로 재정리 (삭제 대상 이후 데이터들의 주소 값이 -1 처리되어 재저장)
	작성 일시 : 2020.10.29
*/		 

	// 변수 설정 
	String name;			// 이름
	String phoneNumber;		// 전화번호
	String birthday;		// 생일
	
	// 생성자 : 세개 데이터를 받아 초기화
	PhoneInfo1(String name, String phoneNumber, String birthday){
		this.name = name;	// 지역변수에 저장
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	// 생성자2  : 두개 데이터 (이름, 전화번호)
	PhoneInfo1(String name, String phoneNumber){
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		//this(name, phoneNumber, "생일정보 없음");
		this(name, phoneNumber, null);
	}
	
	// 저장된 데이터의 적절한 출력 메서드
	void showInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		
		if(birthday == null) {
			System.out.println("생년월일 : 입력 데이터 없음");
		} else {
			System.out.println("생년월일 : "+ birthday);
		}

	}

	
}
