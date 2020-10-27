package overriding;

public class OverridingMain {

	public static void main(String[] args) {

//		BaseEnSpeaker bs = new BaseEnSpeaker(); // 하위클래스 인스턴스 생성
		
//		bs.showCurrentState(); // 오버라이딩한 메서드 호출 (volumeRate랑 baseRate 둘 다)
		
//		Speaker s = new Speaker(); // 상위클래스 인스턴스 생성
		
//		s.showCurrentState();
		
		// 다형성
		// 조상타입의 참조변수에 자손타입의 인스턴스 참조할 수 있는 것.
		Speaker sB = new BaseEnSpeaker();	
			// 참조변수 sB는 volumeRate 변수, showCurrentState(), setVolume() 메서드만 사용할 것.
		
		// 상위클래스가 가지는 멤버
		sB.setVolume(10);
		sB.showCurrentState();
			// 하위클래스에서 오버라이딩한 메서드가 호출된다
				// baseRate는 상위클래스 멤버 아닌데도 호출되는 이유? 
				// 오버라이딩한 메서드 내부에서 이미 처리되었기 때문
		
		// 하위클래스가 가지는 멤버 
		//sB.setBaseRate;	// 오류
		
		
		
		
	}

}
