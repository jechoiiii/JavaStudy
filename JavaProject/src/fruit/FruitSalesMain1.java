package fruit;

public class FruitSalesMain1 {

	public static void main(String[] args) {
		
		// FruitSeller 클래스의 참조변수 seller 선언
		FruitSeller seller = null;
		
		// FruitSeller의 객체 생성
		// 객체의 생성은 클래스에 정의된 멤버(변수, 메서드)들을 메모리에 등록하는 것
		seller = new FruitSeller();	// 객체 생성 후 객체의 주소값을 반환
		// FruitSeller seller2 = new FruitSeller();	-> Seller가 두 명인 경우 
		
		// FruitBuyer 타입의 참조변수 선언과 초기화
		FruitBuyer buyer = new FruitBuyer();
		
		// 사과를 구매 : 2000 지불
		buyer.buyApple(seller, 2000); 	// buyer에서 시작하는 이유 : seller는 누구에게 팔 건지 정의하지X (Ctrl+클래스: 참조 클래스로 이동)
		
		System.out.println("판매자의 현재 지표");
		seller.showSaleResult();
		
		System.out.println("구매자의 현재 지표");
		buyer.showBuyResult();
		
		
	}

}
