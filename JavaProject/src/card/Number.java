package card;

public class Number {

	int num;
	
	// 생성자
	// 생성자는 초기화를 목적으로 만들 때는 Class 이름과 동일하게
	// 반환하지 않아 return x
	Number(int number) {		// int 타입의 정수형만 
		num = number;
		System.out.println("생성자가 실행되었습니다.");
	}
	
	Number(){		// 생성자 오버로딩
		num = 10;
		System.out.println("생성자가 실행되었습니다.");
	}
	
	int getNumber() {
		return num;
	}
	
	
}
