package generic;

public class FruitBoxMain3 {

	public static void main(String[] args) {

		FruitBox<Apple> box1 = new FruitBox<Apple>(new Apple(100));	// T가 Apple인 FruitBox 인스턴스 생성
		// box1.store(new Apple(100));		// object 타입 => Apple 타입
		Apple apple = box1.pullOut();
		apple.showWeight();
		
		FruitBox<Orange> box2 = new FruitBox<Orange>(new Orange(100));	// T가 Orange인 FruitBox 인스턴스 생성
		box2.store(new Orange(150));	// object 타입 => Orange 타입
		Orange orange = box2.pullOut();
		orange.showSugarContent();

	}

}
