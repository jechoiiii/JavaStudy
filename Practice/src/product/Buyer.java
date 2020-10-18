package product;

public class Buyer {	// 자동으로 Object 클래스 상속한다.

	private int money;
	private int bonusPoint;
	
	// 구매할 제품을 담을 배열 생성
//	Tv[] tv;
//	Computer[] com;
//	Audio[] audio; 보다 간단하게
	Product[] cart = new Product[10];
	
	int cnt = 0;	// 구매한 제품의 개
	
	public Buyer() {	// 생성자 오버로
		this(1000);
	}
	
	public Buyer(int money) {
//		super();	//object 클래스는 초기화 불필요 -> 지워도 무방 
		this.money = money;
		this.bonusPoint = 0;
	}
/*	
	void buy(Tv tv) {
	}
	void buy(Computer com) {
	}
	void buy(Audio audio) {
	}
*/	
	
	// 참조변수의 다형성을 써보자
	void buy(Product p) {
//		Product p1 = new Tv(100);	// 인스턴스 생성 
//		Product p2 = new Computer(100);
//		Product p3 = new Audio(100);
	
		// 보유한 돈과 제품의 가격 비교해서 구매 여부 판단 
		if(money<p.price) {
			System.out.println("돈이 부족해 구매불가");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		
		// 카트에 제품 넣기
		cart[cnt++] = p;
	
		System.out.println(p+ "원 구입");	
	}

	void showData() {
		
		// 구매목록, 구매 총액 
		int sum = 0;
		
		System.out.println("===== 구매 목록 =====");
		for(int i=0; i<cnt; i++) {
			System.out.println(cart[i]);
			sum += cart[i].price;
		}
		System.out.println("===================");
		System.out.println("총 구매 금액 : " +sum);
		System.out.println("보너스포인트 : " +bonusPoint);
		System.out.println("낭은 돈 : " +money);
	}
	
	
	
}
