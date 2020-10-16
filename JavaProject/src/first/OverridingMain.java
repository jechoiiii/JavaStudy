package first;

public class OverridingMain {

	public static void main(String[] args) {
		
//		BaseEnSpeaker bs = new BaseEnSpeaker();
		
//		bs.showCurrentState();	// 오버라이딩한 메서드를 호출
		
//		Speaker s = new Speaker();
		
//		 s.showCurrentState();
		
		// 다형성
		// 조상클래스 타입의 참조변수에 자손클래스 타입의 인스턴스를 참조할 수 있는 것.
		// 참조변수는 해당 타입의 멤버만 사용하겠다 라고 선언하는 것 -> 조상클래스 타입의 멤버만 쓰겠다
		Speaker sB = new BaseEnSpeaker();
		// 참조변수 s는  volumeRate 변수와 showCurrentState(), setVolume() 메서드에만 사용할 것
		
		// Speaker 클래스가 가지는 멤버
		sB.setVolume(10);
		
		// BaseEnSpeaker 클래스가 가지는 멤버 
		//sB.setBaseRate(20);	// 오류
		
		// BaseEnSpeaker 클래스에서 오버라이딩한 메서드가 호출된다.
		sB.showCurrentState();	// baseRate는 Speaker클래스 멤버 아닌데 왜 오류 안나? 
								// 오버라이딩한 메서드 내부에서 이미 처리되었기 때문. 
		
		

	}

}
