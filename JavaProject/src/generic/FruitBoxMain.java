package generic;

public class FruitBoxMain {

	public static void main(String[] args) {
	
		AppleBox appleBox = new AppleBox();
		appleBox.store(new Apple(10));
		Apple apple = appleBox.pullOut();
		apple.showWeight();
		
		OrangeBox orangeBox = new OrangeBox();
		//orangeBox.store(new String("오렌지"));	// Orange 타입만 수용 가능해 자료형이 안전하다
		orangeBox.store(new Orange(100));
		Orange orange = orangeBox.pullOut();
		orange.showSugarContent();
	}

}
