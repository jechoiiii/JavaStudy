package form;

// LoginForm 에서 전송되는 데이터를 저장하는 beans 정의 
public class MemberData {

	// 속성 정의 : 변수는 private (필수)  
	private String userid; 			// 사용자의 id
	private String pw; 				// 사용자의 pw
	private String name;			// 사용자의 이름 
	private String photo;			// 사용자의 사진 
	
	// 기본 생성자 (필수) 
	public MemberData() {
		
	}

	public MemberData(String userid, String pw, String name, String photo) {
		this.userid = userid;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
	}
	
	// 각 변수들의 getter/setter 메서드 정의
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "MemberData [userid=" + userid + ", pw=" + pw + ", name=" + name + ", photo=" + photo + "]";
	}
	
	
}
