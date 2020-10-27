package ver07;

public class UnivPhoneInfo extends PhoneInfo {

	// 대학친구 : 전공, 학년
	private String major;
	private int grade;
	
	// 생성자 : 상위 클래스의 생성자 호출, 추가된 변수의 초기화 
	public UnivPhoneInfo(String name, String phoneNum, String addr, String email,
						 String major, int grade) {
		// 상위 클래스의 생성자 호출 : 상위클래스의 멤버변수 초기화
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
		System.out.println("전   공 : " +major);
		System.out.println("학   년 : " +grade);
	}

	@Override
	public void showBasicInfo() {
		super.showInfo();
	}


}
