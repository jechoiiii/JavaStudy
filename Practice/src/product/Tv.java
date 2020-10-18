package product;

public class Tv extends Product{

	// 생성자
	public Tv(int price) {
		super(price); // 조상클래스 생성자 호출 // 반드시 첫 문장에
	
		// System.out.println(참조값);
		// 참조값.toString();	
		// toString 메서드 : 객체가 가진 값을 문자열로 반환
		
	}
	
	@Override
	public String toString() {
		return "[TV의 가격 : "+price+ "]";
	}
	
	
}
