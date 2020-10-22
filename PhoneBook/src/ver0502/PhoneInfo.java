package ver0502;

/*
	파일 이름 : ver0502.java
	내용 : 전화번호 관리 프로그램 ver05 수업 필기
 
	Project ver 0.50
	
	1) ​PhoneBookManager 클래스의 인스턴스수가 최대 하나를 넘지 않도록 코드를 변경
	2) ‘interface’기반의 상수 표현을 바탕으로 
		메뉴 선택과 그에 따른 처리가 이름에 부여된 상수를 기반으로 진행되도록 변경
	3) 현재의 기본 클래스를 interface와 추상클래스를 사용하는 구조로 변경
*/

//2020.10.21 수정 : 추상화
public abstract class PhoneInfo implements Info {	// extends Object

	// 친구의 이름, 전화번호, 주소, 이메일
	// 캡슐화 : 정보은닉 ( 변수의 직접 접근을 제한 - 보호의 목적 )
		// 공통적으로 사용하는 약어 사용하면서 습관 익힐 것	
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
		// 이름 규칙 : 변수와 동일하게, 첫글자는 대문자로
	public String getName() {
		return name;
	}
//	public void setName (String name) {
//		this.name = name;
//	}
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
