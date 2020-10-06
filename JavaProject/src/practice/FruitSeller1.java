package practice;

public class FruitSeller1 {

	// 구매자에게서 몇 개의 사과를 판매했을 때 구매자와 판매자의 상태 (수익 or 보유 금액, 보유하는 사과의 개수)

	// 인스턴스 변수 정의
	final int APPLE_PRICE = 1000; // 사과의 가격 - 변경 불가하도록 상수화
	int numOfApple = 20; // 판매자가 현재 보유하는 사과의 개수
	int myMoney = 0; // 수익금
	
	// 기능 : 판매, 정산 출력
	/* 판매자의 판매 : 사과의 가격, 보유하는 사과의 개수, 수익금 -> 보유하는 사과의 개수 
	 	돈을 받고 
	 		반환하는 사과의 개수 구하기 
	 		수익금 증가 
	 		보유하는 사과의 개수 감소 
	 	사과를 반환
	 */
	
	// saleApple 메서드 정의
	int saleApple(int money) {			// 돈을 받고
	
		int num = 0;					// 반환하는 사과의 개수 선언 & 초기화
		num = money / APPLE_PRICE;		// 반환하는 사과의 개수 구하기		
		myMoney = myMoney + money;		// 수익금 증가		
		numOfApple = numOfApple - num;	// 보유하는 사과의 개수 감소
				
		return num;						// 사과를 반환
	}
	
	public void showSaleResult ()
	{
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("수익금 : " + myMoney);
	}
		
		
		
		
		
		
		
}
