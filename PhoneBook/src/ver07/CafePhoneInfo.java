package ver07;

public class CafePhoneInfo extends PhoneInfo {

	// 동호회 이름, 닉네임
	private String cafeName;
	private String nickName;
	
	// 생성자
	public CafePhoneInfo(String name, String phoneNum, String addr, String email,
						 String cafeName, String nickName) {
		super(name, phoneNum, addr, email);
		this.cafeName = cafeName;
		this.nickName = nickName;
	}

	// getter/setter
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("동호회이름 : " +cafeName);
		System.out.println("닉네임 : " +nickName);
	}

	@Override
	public void showBasicInfo() {
		super.showInfo();	
	}

	

}
