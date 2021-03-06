package phoneBookV3;

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
	작성 일시 : 2020.10.14
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
