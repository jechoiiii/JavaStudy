package phoneBookV4;

public class PhoneCafeInfo extends PhoneInfo {	// 동호회

	private String role;
	
	PhoneCafeInfo(String name, String pNum, String email, String role) {
		super(name, pNum, email);
		this.role = role;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("역할 : " +role);
	}
	
	public void showBasicInfo() {
		System.out.println("이름 : " +getName());
		System.out.println("전화번호 :" +getPNum());
		System.out.println("이메일 : " +getEmail());
	}
	
}
