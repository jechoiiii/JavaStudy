package phoneBookV1;

/*
	Version 0.1 전화번호 관리 프로그램
	
	PhoneInfor 라는 이름의 클래스를 정의해 보자. 
	클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의 
		• 이름		name	        String 
		• 전화번호	phoneNumber	 	String 
		• 생년월일	birthday    	String 
	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
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
	public void ShowInfo() {
		System.out.println("이      름 : "+ name);
		System.out.println("전화번호 : "+ phoneNum);
		
		if(birthday==null) {
			System.out.println("생      일 : 입력 데이터 없음");
		} else {
			System.out.println("생      일 : "+ birthday);
		}
	
		
	}

}
