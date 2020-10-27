package generic;

public class AppleBox {

	Apple apple;
	
	public void store(Apple apple) {
		this.apple = apple;
	}
	
	public Apple pullOut() {	// Apple 타입 반환
		return apple;
	}
}
