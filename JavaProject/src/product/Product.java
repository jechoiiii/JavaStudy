package product;

public class Product /* extends Object */ {	
					 // Object: 최상위 클래스 
					 // 상속받지 않는 클래스는 자동으로 Object 클래스 상속받음
	int price;
	 int bonusPoint;
	
	// 생성자
	public Product(int price) {
		this.price = price;
		this.bonusPoint = (int)(price*0.1f);	// price/10
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}
	
	
	
	
	
}
