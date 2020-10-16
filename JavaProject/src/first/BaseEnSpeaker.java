package first;

public class BaseEnSpeaker extends Speaker {

	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	// 오버라이딩 : 
	// 상속관계에서 상속받은 메서드를 *선언부는 동일하게* 하고 처리부를 재구성하는 것.
	@Override	// 어노테이션 : 자바의 키워드도 주석도 아니지만, 추가적인 의미를 부여한다. 
				// 컴파일할 때 키워드로 인식하지 않음.
	//private void showCurrentState() { // 상위클래스보다 더 적은 범위의 접근제어자로 변경불가
	public void showCurrentState() {
		super.showCurrentState(); // 상위클래스 메서드 호출
		System.out.println("베이스 크기 : " + baseRate); // 상위클래스 메서드 호출없이는 내용이 제대로 호출되지x
	}
	
	
	
}
