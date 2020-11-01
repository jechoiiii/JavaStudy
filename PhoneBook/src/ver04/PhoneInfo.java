package ver04;

/*
	Project : ver 0.40
	
	1) 다음 두 클래스 PhoneUnivInfo, PhoneCompanyInfo와 CafePhoneInfo 추가로 삽입해 상속 구조로 구성 
	 각 클래스에 정의되어야 하는 인스턴스 변수.
	
			PhoneUnivInfor						PhoneCompaanyInfor
	이름             name			String			이름             name			String
	전화번호       phoneNum	String			전화번호       phoneNum	String
	주소             address		String			이메일          email			String
	이메일          email			String			회사             company		String
	전공             major			String
	학년             year			String
	
	Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가로 정의 해 보자
	
	2) 입력    --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성
*/

public class PhoneInfo { // extends Object

	// 2020.10.19 수정 : 변수 캡슐화 
	// 캡슐화 : 정보은닉 ( 변수 보호의 목적으로 직접 접근을 제한한다. 외부에서 직접참조 못하도록 private화 ) 
	// 공통적으로 사용하는 약어 사용하면서 습관 익힐 것		
	private String name;			// 이름
	private String phoneNum;		// 전화번호
	private String addr;			// 주소 
	private String email;			// 이메일
	
	// 생성자로 초기화 
	PhoneInfo(String name, String pNum, String addr, String email){
		// super();	// Object 클래스의 생성자를 호출	-> 기본 생성자를 가지고 있어 초기화 생략 가능
		this.name = name;	
		this.phoneNum = pNum;
		this.addr = addr;
		this.email = email;
	}

	// getter/setter 메서드 : 외부에서 캡슐화한 변수 값을 읽어오거나 설정할 수 있도록 하는 메서드 
		// 이름 규칙 : 변수와 동일하게, 첫글자는 대문자로
	public String getName() {
		return name;
	}
	public String getPNum() {
		return phoneNum;
	}
	public String getAddr() {
		return addr;
	}
	public String getEmail() {
		return email;
	}
	// setter 메서드 생략 (변수 참조 불필요하기 때문에)
	//	public void setName (String name) {	
	//	this.name = name;
	//	}
	
	
	// 저장된 데이터의 출력 메서드 => 하위 클래스에서 오버라이딩 하는 목적 
	public void showInfo() {

		// 정보 입력 여부 확인
		if(name==null && phoneNum==null && addr==null && email==null) {
			System.out.println("정보를 다시 입력해주세요.");
			return;
		} else {
			System.out.println("이   름 : " +name);
			System.out.println("전   화 : " +phoneNum);
			System.out.println("주   소 : " +addr);			
			System.out.println("이 메 일 : " +email);				
		}	
	}
	
//	public void showBasicInfo() {
//		System.out.println("이름 : " +name);
//		System.out.println("전화번호 : " +phoneNum);
//		System.out.println("이메일 : " +email);		
//	}
}
