package arr;

/*
	파일 이름 : User.java
	내용 : 사용자 입력 배열 필기  
	작성 일자 : 2020.10.13
*/

public class User {

	// "사용자"의 데이터를 저장 : 이름, 아이디(숫자)
	// 손흥민(1), 박지성(2)
	int id;					// 사용자의 아이디
	String name;		// 사용자의 이름
	
	// 생성자로 초기화
	User(int id, String name){
		this.id=id;				// 인스턴스 변수 id = 지역변수 id
		this.name=name;
	}
	
	void showData() {
		System.out.println(name+ "(" +id+ ")");
	}
	
	
}
