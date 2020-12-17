package member;

// 데이터를 저장하는 beans 생성
public class Member {

	// 속성 정의 : 변수는 private (필수)  
	private String userid; 			// 회원의 아이디
	private String pw; 				// 회원의 비밀번호
	private String name;			// 회원의 이름 
	private String photo;			// 회원의 프로필 사진 
	
	// 기본 생성자 (필수) 
	public Member() {
		
	}

	public Member(String userid, String pw, String name, String photo) {
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
