package fruit.ver02;

/*
	파일이름 : FruitSeller.java
	설명 : 사과 장수의 객체를 정의
	작성일시 : 2020.10.08
	수정내용 : fruit.FruitSeller.java 를 기반으로 생성자를 추가
 */

public class FruitSeller {
	
	// 클래스에는 변수와 메서드를 정의
	// 성격이 비슷한 변수 메서드를 정의한다
	
	
	// 수정 : 2020.10.08 
	//		변수의 초기화를 생성자에서 처리, 변수 선언시에 초기화 코드 삭제
	// 변수 : 인스턴스 변수, 멤버 변수		
	//int applePrice = 1000;		// 사과의 가격
	final int APPLE_PRICE;			// 사과의 가격, 변경이 되지 않도록 상수로 선언
	private int numOfApple;			// 사과의 보유 개수 (캡슐화)
	private int myMoney;			// 수익 금액 (캡슐화)
	
	
// 2020.10.08 생성자 추가
	FruitSeller(){					// 비어있을 땐 기본 생성자
		this(0, 20, 1000);			// 바로 밑 FruitSeller 호출
	}
	
	FruitSeller(int money, int num, int price){
		APPLE_PRICE=price;
		numOfApple=num;
		myMoney=money;
	}
	
	// 생성자를 이용한 인스턴스의 복사 (논리값은 같지만 물리값(데이터의 주소값)은 다르다.) 
	
	FruitSeller(FruitSeller seller){	
		
		//APPLE_PRICE = seller.APPLE_PRICE;
		//numOfApple = seller.numOfApple;
		//myMoney = seller.myMoney;
		
		// 위 세줄을 아래 한줄로 this 이용하여 바꿀 수 있음.
		this(seller.myMoney, seller.numOfApple, seller.APPLE_PRICE);
		
	}
	
	
	// 	기능 : 판매, 정산 출력
	
	/* 	판매 메서드 : 					// flow chart 순서도 적고 코드 작성하기!
	 		돈을 받고 -> 
	 			반환하는 사과의 개수, 
				수익금 증가, 
				보유하는 사과의 개수 감소 -> 
	 		사과의 개수 반환
	 */
	
	int saleApple(int money) {
		
		int num = 0;	// 반환할 사과의 개수, *지역변수는 반드시 초기화 해주어야 한다.
		
		// 반환할 사과의 개수 구하기
		num = money/ APPLE_PRICE;	// 받은 돈/사과의 가격
		
		// 수익금 증가
		myMoney = myMoney + money;
		
		// 사과의 개수 감소
		numOfApple = numOfApple - num;
		
		return num;
	}
	
	/*  정산 출력 : 보유한 사과의 개수 출력, 보유한 금액 출력 
	 	- 받는 데이터가 없으므로 매개변수 정의하지 않는다.
	 	- 반환하는 데이터가 없음으로 void 타입으로 메서드 정의
	 */ 
	void showSaleResult() {
		System.out.println("현재 보유한 사과의 개수 : " + numOfApple);
		System.out.println("판매 수익 금액 : " + myMoney);
	 }
	

}
