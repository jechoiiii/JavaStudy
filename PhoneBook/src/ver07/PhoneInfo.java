package ver07;

/*
	파일 이름 : ver07.PhoneInfo.java
	내용 : 전화번호 관리 프로그램 ver07
	수정 사항 : 직렬화를 이용해서 데이터를 저장하고, 프로그램 재 실행시 저장된 데이터를 로드해서 사용하도록 처리 
	작성 일시 : 2020.10.27
*/

public abstract class PhoneInfo implements Info {	// extends Object

	// 친구의 이름, 전화번호, 주소, 이메일
	// 캡슐화 : 정보은닉 ( 변수의 직접 접근을 제한 - 보호의 목적 )	
	private String name;			// 이름
	private String phoneNum;		// 전화번호
	private String addr;			// 주소
	private String email;			// 이메일

	// 생성자로 초기화 
	PhoneInfo(String name, String phoneNum, String addr, String email){
		// super();	// Object 클래스의 생성자를 호출	// 기본 생성자를 가지고 있어 초기화 생략 가능
		this.name = name;	
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
	}

	// getter/setter 메서드 : 값을 읽어오거나 설정할 때
	// getter 메서드 : 외부에서 private 변수 값 가져갈 수 있도록 
		// 이름 규칙 : get + 변수와 동일하게, 첫글자는 대문자로
	public String getName() {
		return name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddr() {
		return addr;
	}
	public String getEmail() {
		return email;
	}
	
	// 정보 출력 기능 : 하위 클래스에서 오버라이딩 하는 목적
	@Override
	public void showInfo() {
		System.out.println("이   름 : " +name);
		System.out.println("전   화 : " +phoneNum);
		System.out.println("주   소 : " +addr);
		System.out.println("이메일 : " +email);
	}
	
	// 추상메서드 void showBasicInfo() 를 멤버로 가진다.

	

}
