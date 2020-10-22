package phoneBookV4;

public class PhoneUnivInfo extends PhoneInfo {

	// 변수 캡슐화
	private String major;		// 전공
	private String year;		// 학년
	private String address;		// 주소
	
	// 상위메서드 생성자 호출, 초기화
	PhoneUnivInfo(String name, String pNum,  String email, String major, String year, String addr) {
		super(name, pNum, email);	// 상위메서드 생성자 호출은 반드시 첫번째 문장에
		this.major = major;
		this.year = year;
		this.address = addr;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전공 : " +major);
		System.out.println("학년 : " +year);
		System.out.println("주소 : " +address);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " +getName());
		System.out.println("전화번호 :" +getPNum());
		System.out.println("이메일 : " +getEmail());
	}
	
	
}
