package friend;

public abstract class Friend {
	
	// 이 클래스를 상속하면 변수/메서드를 모두 구현해야한다. 클래스를 만드는 일종의 규칙이다. 
	
	private String name;			// 이름	// 캡슐화 : 변수를 직접참조하는 것 방지
	private String phoneNumber;		// 전화번호
	private String addr;			// 주소	// 인스턴스 멤버
	
	// 생성자를 통해서 인스턴스 변수들을 초기화
	Friend(String name, String pNum, String addr){	// 매개변수 정의 (지역변수)
		this.name = name;	// 자신을 가르키는 참조값 this. 자바에서 자동으로 추가해준다.
		this.phoneNumber = pNum;
		this.addr = addr;
	}
	
	public String getName() {	// getName 메서드를 통해 name 값을 외부에서 가져갈 수 있다. 
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddr() {
		return addr;
	}
	
	
	// 오버라이딩 처리 : 상속하는 클래스의 추가 속성을 출력
	public void showData() {	// 인스턴스 메서드
		System.out.println("이름 : " + name);	// 인스턴스 멤버라서 직접 참조 가능
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + addr);
	}
	
	// 오버라이딩 : 비어있는 처리부를 기능에 추가
//	public void showBasicInfo() {	
//		
//	}

	public abstract void showBasicInfo();
	
}
