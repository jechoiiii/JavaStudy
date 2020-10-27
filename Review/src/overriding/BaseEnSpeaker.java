package overriding;

public class BaseEnSpeaker extends Speaker{

	private int baseRate;	// 베이스 크기
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	// 오버라이딩
	@Override
	public void showCurrentState() {
		super.showCurrentState(); // 상위클래스 메서드 호출
		System.out.println("베이스 크기 : " +baseRate); // 상위클래스 메서드 재구성. 
													// 상위클래스가 하위클래스를 참조하면, 오버라이딩된 매서드가 적용.
	}
	
	
}
