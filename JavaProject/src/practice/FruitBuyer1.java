package practice;

public class FruitBuyer1 {

	// 변수와 메서드 정의
	int myMoney = 5000;				// 현재 보유 금액
	int numOfApplesBought = 0;		// 구매자가 보유하는 사과의 개수
	
	// 기능 : 구매, 현재 상태 출력
	/* buyApple 매서드 :
			판매자(객체)와 지불 금액 받아
			판매자의 판매 메서드 호출 -> 구매한 사과의 개수 얻기
			현재 보유 금액 감소
			보유하는 사과의 개수 증가
		현재 상태 출력
	*/
	void buyApple(FruitSeller1 seller, int money) {		// 판매 메서드 호출
		 int num = seller.saleApple(money);				// 구매한 사과의 개수 얻기
		 myMoney -= money;						// 현재 보유 금액 감소
		 numOfApplesBought -= num;	// 보유하는 사과의 개수 증가							
	}
	
	public void showBuyResult ()
	{
		System.out.println("남은 돈: " + myMoney);
		System.out.println("보유하는 사과의 개수: " + numOfApplesBought);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 판매자에게 몇 개의 사과를 얼마를 주고 구매했을 때 구매자와 판매자의 상태 (수익 or 보유 금액, 보유하는 사과의 개수)
	
	// 매서드(행위) : 구매자의 구매, 판매자의 판매  
	
	/* 	구매자의 구매 : 보유 금액, 지불한 금액, 구매한 사과의 개수 -> 보유 금액, 보유하는 사과의 개수
			돈을 주고
				구매한 사과의 개수 구하기
				보유하는 사과의 개수 구하기
				보유하는 금액 구하기
			구매한 사과를 반환받음
	 */
	
/*	// 인스턴스(멤버) 변수 선언
	final int firstMoney = 5000;	// 처음 보유 금액 (변경 불가하도록 상수화)
	int numOfApples = 0;			// 구매한 사과의 개수
	int myMoney = 0;				// 지불한 금액
	
	// 돈을 주고
	int buyApple(int money) {
		
		int num = 0;				// 구매한 사과의 개수
		
		num = myMoney / 
		
		
		
		
		return money; 	
	}
*/	
	
	
}
