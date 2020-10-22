package phoneBookV4;

public class PhoneInfo {

/*
		Project : ver 0.40
		
		다음 두 클래스를 추가로 삽입. 상속 구조로 구성 해보세요. 
		PhoneUnivInfor, PhoneCompaanyInfor, 개인적인 클래스 추가 하세요.
		각 클래스에 정의되어야 하는 인스턴스 변수.
		
				PhoneUnivInfor						PhoneCompaanyInfor
		이름             name			String			이름             name			String
		전화번호       phoneNumber	String			전화번호       phoneNumber	String
		주소             address		String			이메일          email			String
		이메일          email			String			회사             company		String
		전공             major			String
		학년             year			String

		Ex) PhoneCafeInfor 또는 PhoneFamilyInfor 등을 추가로 정의 해 보자
		
		[추가 사항]
		1. 입력    --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성
*/	

	// 변수 캡슐화 : 외부에서 직접참조 못하도록
	private String name;			// 이름
	private String phoneNumber;		// 전화번호
	private String email;			// 이메일
	
	// 생성자로 초기화 
	PhoneInfo(String name, String pNum, String email){
		this.name = name;	
		this.phoneNumber = pNum;
		this.email = email;
	}

	
	// getter 메서드 : 외부에서 private 변수 값 가져갈 수 있도록 
	public String getName() {
		return name;
	}
	public String getPNum() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	
	// 저장된 데이터의 출력 메서드
	public void showData() {

		// 정보 입력 여부 확인
		if(name==null || phoneNumber==null || email==null) {
			System.out.println("정보를 다시 입력해주세요.");
			return;
		} else {
			System.out.println("이름 : " +name);
			System.out.println("전화번호 : " +phoneNumber);
			System.out.println("이메일 : " +email);				
		}	
	}
	
	public void showBasicInfo() {
		System.out.println("이름 : " +name);
		System.out.println("전화번호 : " +phoneNumber);
		System.out.println("이메일 : " +email);		
	}
}
