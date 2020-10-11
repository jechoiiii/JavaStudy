package fruit;

public class FruitBuyer {
	
	// 	변수와 메서드 정의
	
	// 	구매자의 보유 금액, 보유한 사과의 개수
	int myMoney = 5000;	// 구매자의 보유 금액
	int numOfApple = 0;	// 보유한 사과의 개수
	
	/* 	기능 : 사과 구매, 현재 상태(금액, 사과의 개수) 값을 출력
	 	사과를 구매
		판매자 정보(객체)와 금액 받아							매개변수
		판매자의 판매 메서드 호출 -> 구매하는 사과의 개수를 얻는다	* 왜 판매 메서드 호출? seller-buyer 객체 간의 관계
		보유한 사과의 개수 증가
		보유 금액 감소
	*/
	
	// 참조 변수는 객체의 주소를 저장하고 있다 -> 셀러의 참조값을 받도록 참조변수를 매개변수로 정의
	// FruitSeller seller -> FruitSeller 클래스로 만든 객체의 주소를 저장하는 변수 (FruitSeller 클래스 타입의 변수만 가능)
	
	void buyApple(FruitSeller seller, int money) {			
		
		// 구매할 사과의 개수를 구하기
		int num = seller.saleApple(money);	// seller.myMoney는 판매자의 수익 금액 가져오는 것
											// (buyApple) money -> (saleApple) money -> return으로 saleApple 메서드 종료 -> (Seller)num을 (Buyer)num에 대입
		// 나의 사과의 개수 증가
		numOfApple += num;
		// 나의 보유 금액 감소
		myMoney -= money;
	}
	
	//  현재 상태(금액, 사과의 개수) 값을 출력
	void showBuyResult() {
		System.out.println("보유 금액 : " + myMoney);
		System.out.println("보유한 사과의 개수 : " + numOfApple);
		
	}
	
	
	

}
