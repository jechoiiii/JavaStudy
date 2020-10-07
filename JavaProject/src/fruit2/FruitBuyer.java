package fruit2;

public class FruitBuyer {

	int myMoney = 1000; 		// 구매자가 보유하는 금액
	int numOfApple = 0;			// 구매자가 보유하고 있는 사과의 개수
	
	void buyApple(FruitSeller seller, int money)
	{
		numOfApple += seller.saleApple(money);
		myMoney -= money;		// 보유 금액 - 지불 금액		
	}
	
	void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("구매한 사과의 개수 : " + numOfApple);
	}
	
	
	
}
