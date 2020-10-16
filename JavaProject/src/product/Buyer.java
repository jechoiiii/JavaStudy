package product;

public class Buyer {	// 자동으로 Object 클래스를 상속한다.

	private int money;
	private int bonusPoint;
	
	// 구매한 제품을 담을 배열을 생성
//	Tv[] tv;
//	Computer[] com;
//	Audio[] audio;
// 	보다 배열로 해보자
	Product[] cart = new Product[10];
	
	int cnt=0;	// 구매한 제품의 개수
	
	public Buyer() {
		this(1000);
	}
	
	public Buyer(int money) {
//		super();	// Object 클래스는 초기화할 필요 없어 지워도 무방
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
//		Product p1 = new Tv(100); 
//		Product p2 = new Computer(100);
//		Product p3 = new Audio(100);
		
		// 보유한 돈과 제품의 가격을 비교해서 구매 여부 판단
		if(money<p.price) {
			System.out.println("보유한 돈이 부족해서 구매할 수 없습니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		
		// 카트에 제품을 넣는다
		cart[cnt++] = p;
		
		System.out.println(p + "원을 구입했습니다.");		
		
	}
	
	void showData() {
	
		// 구매목록, 구매 총액 출력
		int sum=0;
		
		System.out.println("구매 목록 =========");
		for(int i=0; i<cnt; i++) {
			System.out.println(cart[i]);
			sum += cart[i].price;
		}
		System.out.println("================");
		System.out.println("총 구매 금액 : " +sum);
		System.out.println("보너스포인트 : " + bonusPoint);		
		System.out.println("남은 돈 : " + money);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
