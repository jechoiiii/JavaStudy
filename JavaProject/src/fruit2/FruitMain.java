package fruit2;

public class FruitMain {

	public static void main(String[] args) {
	
		FruitSeller seller1 = new FruitSeller();		// 인스턴스화
		seller1.initMembers(0, 30, 1500);
		
		FruitSeller seller2 = new FruitSeller();
		seller2.initMembers(0,20,1000);
		
		FruitBuyer buyer = new FruitBuyer();
		buyer.buyApple(seller1, 4500);
		buyer.buyApple(seller2, 3000);
		
		System.out.println("과일 판매자1의 현재 상황");
		seller1.showSaleResult();
		
		System.out.println("과일 판매자2의 현재 상황");
		seller2.showSaleResult();
		
		System.out.println("구매자의 현재 상황");
		buyer.showBuyResult();
		

	}

}
