package ver07;

public class CompanyPhoneInfo extends PhoneInfo{

	// 회사이름
	private String company;
	
	// 생성자
	CompanyPhoneInfo(String name, String phoneNum, String addr, String email,
					 String company) {
		// 상위클래스의 생성자 호출
		super(name, phoneNum, addr, email);
		// 회사이름 초기화
		this.company = company;
	}
	
	// getter/setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회   사 :" +company);
	}

	@Override
	public void showBasicInfo() {
		super.showInfo();
	}
	

	

	


}
