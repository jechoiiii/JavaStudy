package ver04;

public class PhoneUnivInfo extends PhoneInfo {	// 대학 친구 

	// 대학 친구 : 전공, 학년 
	// 변수 캡슐화
	private String major;	// 전공
	private int grade;		// 학년
	
	// 생성자 : 상위 클래스의 생성자 호출, 추가된 변수의 초기화 
	PhoneUnivInfo(String name, String phoneNum,  String addr, String email, 
				  String major, int grade) {
		// 상위메서드 생성자 호출 : 상위클래스의 멤버변수 초기화 (반드시 첫번째 문장에) 
		super(name, phoneNum, addr, email);	
		// 새로 추가된 멤버 변수 초기화
		this.major = major;
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}	
	
	// 출력 기능 오버라이딩
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("전   공 : "+ major);
		System.out.println("학   년 : "+ grade);
	}
	
	
}
