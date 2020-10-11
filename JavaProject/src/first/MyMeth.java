package first;

public class MyMeth {	// 사용하고 싶은 메서드를 클래스로 만들어 놓기.

	// 변수 선언
	int num= 10; 
	
	// 정수 2개를 받아 / 덧셈 연산을 하고 / 그 결과를 반환하는 메서드 정의
	long add(long n1, long n2) {	
		long result = n1 + n2;	
		return result;
	}
	
	void sayHello() {
		System.out.println("안녕하세요");
	}
	
//  정수 2개를 받아서 덧셈의 결과를 출력하는 메서드 -> 반환X
	void plus(int num1, int num2) {		// num1은 매개변수이기 때문에 겹치지 x
		int result = num1 + num2;		// result는 지역변수이기 때문에 상단에서 사용했던 변수지만 영향받지 X
		System.out.println(result);
	}
	
	boolean check() {
		boolean result = num > 20;
		return result;
	}
	
	boolean check1() {
		return false;
	}
	
// 정수 2개를 받아서 나눗셈한 결과를 출력하는 메서드
	void div(int num1, int num2) {
		
		// 예외처리 
		if(num2==0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return;		// 메서드의 종료를 의미 
		}
		
		System.out.println("나눗셈의 결과 : " + num1/num2);		// 사칙연산 중 /와 %는 우선되기 때문에 괄호 불필요
	}
	
	
	
}
