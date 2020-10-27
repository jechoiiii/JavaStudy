package generic;

public class FruitBoxMain {

	public static void main(String[] args) {
				
		AppleBox aB = new AppleBox();	// AppleBox 인스턴스 생성
		aB.store(new Apple(10));	// AppleBox 클래스의 store 메서드에 Apple 10개 참조
				// ?? 사과 10개를 어떻게 다르게 표현할까
		Apple ap = aB.pullOut();	// AppleBox 클래스의 pullOut 메서드 호출
		ap.showWeight();			// Apple 클래스의 showWeight 메서드 호출
		
		OrangeBox oB = new OrangeBox();
		oB.store(new Orange(100));
		Orange or = oB.pullOut();
		or.showSugarContent();
		
		
		
	}
	
}
