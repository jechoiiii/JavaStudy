package product;

public class ProductMain {

	public static void main(String[] args) {
	
//		System.out.println(new Product(100).toString());
//		System.out.println(new Tv(50).toString());
//		System.out.println(new Computer(20).toString());

		// 구매자 인스턴스 생성	
		Buyer b = new Buyer();
		
		// 제품 인스턴스 생성 
		Tv tv = new Tv(200);
		Computer com = new Computer(180);
		Audio audio = new Audio(150);
		
		b.buy(tv);		// Product p = new Tv();	// p : Buyer의 참조변
		b.buy(com);		// Product p = new Computer();
		b.buy(audio);	// Product p = new Audio();

		b.showData();
		
		
	}

}
