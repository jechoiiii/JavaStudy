package ver04;

public class PhoneCompanyInfo extends PhoneInfo { // 회사 친구 

	// 회사이름
	private String company;
	
	PhoneCompanyInfo(String name, String pNum, String addr, String email, 
				  String company) {
		// 상위클래스의 생성자 호출
		super(name, pNum, addr, email);
		// 회사이름 초기화
		this.company = company;
	}

	// getter
	public String getCompany() {
		return company;
	}
		
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("역할 : "+ company);
	}
}
