package test;

public class BBB {

	public static void main(String[] args) {
		
		AAA a = new AAA();	// AAA에 default 생성자 자동으로 들어가 있어 접근 가능
							// public클래스 + default생성자 => 동일 패키지 내 인스턴스 생성만 허용
		
		a.num = 10;
		// a.setNum(10);	// private 필드는 setter 메서드로 접근 가능 
		
		
		
		
		
	}
		
	

}
