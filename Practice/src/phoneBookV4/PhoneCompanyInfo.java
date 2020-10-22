package phoneBookV4;

public class PhoneCompanyInfo extends PhoneInfo {

	private String company;	// 회사
	
	PhoneCompanyInfo(String name, String pNum, String email, String comp) {
		super(name, pNum, email);
		this.company = comp;

	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("회사 : " + company);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " +getName());
		System.out.println("전화번호 :" +getPNum());
		System.out.println("이메일 : " +getEmail());
	}
}
