package product;

public class Product { /* extends Object */ 
					   //Object : 최상위 클래스 -> 상속받지 않는 클래스는 자동으로 Object 상속받음

	int price;
	int bonusPoint;
	
	// 생성자
	public Product(int price) {
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
	}
	
	// toString 메서드 : 객체가 가진 값을 문자열로 반환
	@Override
	public String toString() {
		return " 제품 [가격 : "+price+", 보너스포인트 : "+bonusPoint+"]";
	}
	
	
}
