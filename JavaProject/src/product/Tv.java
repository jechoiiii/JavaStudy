package product;

public class Tv extends Product {

	public Tv(int price) {
		super(price); // 조상클래스 생성자 호출 // 반드시 첫 문장에
	
		// System.out.println(참조값);
		// 참조값.toString() 메서드를 호출함 
	}

	@Override
	public String toString() {
		return "Tv [" +price+ "]";
	}
	
	

	
	
	
	
}
