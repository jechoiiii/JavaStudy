package card;

public class Number {

	int num;
	
	// 생성자는 초기화 메소드로 초기화를 목적으로 한다. 클래스 이름과 동일, 반환 타입 x 
	
	Number(int number) {	// int 타입의 정수형만 가능 
		num = number;
		System.out.println("생성자가 실행되었습니다.");
	}
	
	Number(){	// 생성자 오버로딩, 매개 변수x 
		num = 10;
		System.out.println("생성자가 실행되었습니다.");
	}
	
	int getNumber() {
		return num;
	}
	
	
}
