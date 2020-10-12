package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfo pi1 = new PhoneInfo("손흥민", "010-0000-0000", "1990.10.12");

		pi1.showInfo(); // 참조변수 pi1이 가르키는 PhoneInfo 타입 객체의 메서드 호출 
		
		PhoneInfo pi2 = new PhoneInfo("박지성", "010-1111-1111");
		
		pi2.showInfo();
		
	}

}
