package phoneBookV4;

/*
	파일 이름 : phoneBookV4.PhoneInfo.java
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

public class PhoneInfo {
	
	// 2020.10.19 수정 : 변수 상수화 
	// 변수 설정
	private String name;		// 이름
	private String phoneNum;	// 전화번호
	private String birthday;	// 생일
	
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
