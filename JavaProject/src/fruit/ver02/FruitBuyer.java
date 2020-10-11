package fruit.ver02;

/*
	파일이름 : FruitBuyer.java
	설명 : 구매자의 객체를 정의
	작성일시 : 2020.10.08
	수정내용 : fruit.FruitBuyer.java 를 기반으로 생성자를 추가
*/

public class FruitBuyer {
	
	// 	변수와 메서드 정의
	
	// 수정 : 2020.10.08, 변수의 초기화 코드 생략	
	
	// 	구매자의 보유 금액, 보유한 사과의 개수
	int myMoney; // 구매자의 보유 금액
	int numOfApple; // 보유한 사과의 개수
	
	/* 	기능 : 사과 구매, 현재 상태(금액, 사과의 개수) 값을 출력
	 	사과를 구매
			판매자 정보(객체)와 금액 받아							// 매개변수
			판매자의 판매 메서드 호출 -> 구매하는 사과의 개수를 얻는다	// why 판매 메서드 호출? seller-buyer 객체 간의 관계
			보유한 사과의 개수 증가
			보유 금액 감소
	*/
	
	// 2020.10.08 : 생성자 정의, 변수의 초기화 목적
	
	public FruitBuyer() {
		this(5000, 0);						// 보유 금액 5000, 보유한 사과 개수 0
	}
	
	public FruitBuyer(int myMoney, int numOfApple) {
		this.myMoney = myMoney;				// this. 인스턴스변수**
		this.numOfApple = numOfApple;		// this -> 자신을 가르키는 참조변수
	}
	
	// 참조 변수는 객체의 주소를 저장하고 있다 
	// 셀러의 참조값을 받도록 참조변수를 매개변수로 정의
	
	// FruitSeller seller -> FruitSeller 클래스로 만든 객체의 주소를 저장하는 변수 
	// FruitSeller 클래스의 타입에 맞는 변수 타입만 가능
	
	void buyApple(FruitSeller seller, int money) {			
		
		// 구매할 사과의 개수를 구하기
		int num = seller.saleApple(money);					
		// 나의 사과의 개수를 증가
		numOfApple += num;
		// 나의 보유 금액을 감소
		myMoney -= money;
	}
	
	//  현재 상태(금액, 사과의 개수) 값을 출력
	void showBuyResult() {
		System.out.println("보유 금액 : " + myMoney);
		System.out.println("보유한 사과의 개수 : " + numOfApple);
		
	}

	
	
	

}
