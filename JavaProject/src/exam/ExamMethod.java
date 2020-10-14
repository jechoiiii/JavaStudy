package exam;

/*
	파일 이름 : ExamMethod.java
	내용 : 자바의 정석 메서드 예제 풀이
	작성 일시 : 2020.10.13
 */

public class ExamMethod {
	
	public static void main(String[] args) {
	// 이전까진 인스턴스 메서드로 클래스 만들었고, 이번엔 static 메서드로 만들어보자.  
	// 메서드 : 데이터를 받아서, 처리하고, 결과를 반환하는 기능	
		
		// 1번 문제 메서드 호출
		System.out.println("문제 1 =======================");		
		cal(10,3);	// static 메서드는 static 멤버만 불러올 수 있다. 인스턴스 멤버는 x 

		// 2번 문제 메서드 호출
		System.out.println("문제 2 =======================");
		abs(-5,-7);
		
		// 3번 문제 메서드 호출
		System.out.println("문제 3 =======================");
			// 원의 넓이 구하기
		System.out.println(cirArea(4));	// 반환하는 메서드이기에 main클래스에서 출력
			// 원의 둘레 구하기
		System.out.println(circu(4));	
		
		// 4번 문제 메서드 호출
		System.out.println("문제 4 ========================");
		System.out.println(isPrimeNumber(4));
		// 1~100까지의 범위에서 소수 찾기
		for(int i=1; i<101; i++) {
			if(isPrimeNumber(i)) {	
				// ? 왜 isPrimeNumber(i)==true 조건이 아닌데도 true를 반환하는 i만 출력하는지
				// if문은 true를 출력하기 위한 조건이기에 isPrimeNumber(i)==true라고 명시하지 않아도 true만 출력한다.
				System.out.println(i);	
			}
		}		
		
		
	}
	
/*
		문제1. ------------------------------------------
		두 개의 정수를 전달받아서, 
		두수의 사칙연산 결과를 출력하는 메서드와 
		이 메서드를 호출하는 main메서드를 정의해보자.
		단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.
 */		
		// return이 없다. 반환하는 데이터가 없다. 
		// => void 메서드이름 (변수 선언, 변수 선언) <- 매개변수 {
		// 		처리
		// 		}
	
		static void cal(int num1, int num2) {
			// 사칙연산 : +,-,*,/,%
			System.out.println(num1+"+"+num2+"="+(num1+num2));
			System.out.println(num1+"-"+num2+"="+(num1-num2));
			System.out.println(num1+"*"+num2+"="+(num1*num2));
			System.out.println(num1+"/"+num2+"="+(num1/num2));
			System.out.println(num1+"%"+num2+"="+(num1%num2));
		}
	
/*		// 두 개의 정수를 전달받아
		int number1; 
		int number2;
		
		void SetData (int n1, int n2) {
			number1 = n1;
			number2 = n2;
		}	
		
		// 두 수의 사칙연산 결과를 출력하는 메서드
		void plus() {
			int result = 0;
			result = number1 + number2;
		}
		void minus() {
			int result = 0;
			if(number1>number2) {
				result = number1 - number2;
			} else {
				result = number2 - number1;
			}
		}
		void multiply() {
			int result = 0;
			result = number1 * number2;
		}
*/		

		/*
		문제2. ------------------------------------------
		두 개의 정수를 전달 받아서, 
	두수의 절대값을 계산하여 출력하는 메서드와
	이 메서드를 호출하는 main메서드를 정의해 보자. 
	단 메서드 호출 시 전달되는 값의 순서에 상관없이 절대값이 계산되어서 출력되어야 한다.
	
*/

	static void abs(int num1, int num2) {
		System.out.println("num1의 절대값 : " + (num1>0?num1:-num1));
		System.out.println("num1의 절대값 : " + (num2>0?num2:num2*-1));
	}
	

/*
		문제3. ------------------------------------------

		원의 반지름 정보를 전달하면, 
		원의 넓이를 계산해서 반환하는 메서드와  (π*r∧2)
		원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고,	(2*π*r)
		이를 호출하는 main메서드를 각각 정의하자.
 */
		// PI : final 상수, static 클래스 변수, public
		// PI는 double 타입
		
		static double cirArea(double radius) {
			return Math.PI * radius * radius;
		}
		
		static double circu(double radius) {
			return 2 * Math.PI * radius;
		}

/*
		문제4. ------------------------------------------
		전달되는 값이 : 1~100 // 매개변수 int
		소수(prime number)인지 아닌지를 판단하여, 
		소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 	// 반환  boolean
		이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.
 */

		static boolean isPrimeNumber(int num) {
			int cnt = 0;
			// 소수 인지 판별 
			// 자기보다 작은 숫자로 나눴을 때 나머지가 0이 나오는 수의 count가 2보다 많을 때
			for(int i=1; i<=num; i++) {
				if(num%i==0) {
					cnt++;
				}
			}
			return cnt>2?false:true;
		}


}
