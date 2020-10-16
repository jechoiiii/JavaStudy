package product;

public class Tv extends Product {

	// 생성자 필요
	public Tv(int price) {
		super(price);
	
		// System.out.println(참조값);
		// 참조값.toString() 메서드를 호출함 
	}

	@Override
	public String toString() {
		return "Tv [" +price+ "]";
	}

//	@Override
//	public String toString() {
//		return "TV";
//	}
	
	

	
	
	
	
}
