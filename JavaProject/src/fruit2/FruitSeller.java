package fruit2;

public class FruitSeller {

	/*
	과일장수1: 보유하고 있는 사과의 개수는 30개이고, 개당 가격은 1500원 
	과일장수2: 보유하고 있는 사과의 개수는 20개이고, 개당 가격은 1000원
	 */
	
	int numOfApple;		// 보유하고 있는 사과의 개수
	int myMoney;		// 수익
	int applePrice;		// 사과 개당 가격
	
	int saleApple(int money) {		// 받은 돈
		
		int num = money/applePrice; 	// 판매한 사과의 개수
		numOfApple -= num;
		myMoney += num;
		return num;
	}
	
	void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("수익 : "+ myMoney);
	}
	
	void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		applePrice = price;
	}
	
	
}
