package phoneBookV2;

/*
	파일 이름 : phoneBookV2.PhoneInfo.java
	내       용 : 전화번호 관리 프로그램 ver02
	수정 사항 : 프로그램 사용자로부터 데이터 입력
				프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스 생성
				프로그램을 종료하지 않는 한 프로그램의 흐름이 유지되도록 반복
	작성 일시 : 2020.10.29
*/	

public class PhoneInfo {
	
	// 변수 설정
	String name;		// 이름
	String phoneNum;	// 전화번호
	String birthday;	// 생일
	
	// 생성자 : 3개의 데이터 초기화
	PhoneInfo(String name, String phoneNum, String birthday){
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthday = birthday;
	}

	// 생성자 오버라이딩 : 2개의 데이터 초기화
	PhoneInfo(String name, String phoneNum){
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	// 출력 메서드
	public void showInfo() {
		System.out.println("이      름 : "+ name);
		System.out.println("전화번호 : "+ phoneNum);
		
		if(birthday==null) {
			System.out.println("생      일 : 입력 데이터 없음");
		} else {
			System.out.println("생      일 : "+ birthday);
		}
	
		
	}

}
