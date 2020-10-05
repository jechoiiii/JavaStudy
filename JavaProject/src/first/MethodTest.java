package first;

public class MethodTest {

	public static void main(String[] args) {

		MyMeth my = new MyMeth();	// => 인스턴스 생성 : MyMeth 메서드가 메모리에 올라감
		
		System.out.println(my.add(1, 5));	// add 메서드 호출
		
		my.sayHello();		// sayHello 메서드 호출

		my.plus(10, 20);	// 10, 20 : 매개변수의 인자(값)
		
		System.out.println(my.check()); 	// check 메서드 호출
		
		System.out.println(my.check1());
		
		my.div(10, 2);
		my.div(10, 0);		// 0으로 나누기 불가 // ArithmeticException 에러 알람보고 알아볼 것
		
		
		
		
		// 과제: 자바의 정석 문제 풀이
		// 문제 1. int형 변수 num1, num2, num3가 각각 10,20,30 으로 초기화 되어 있다.
		// 다음문장을 실행하면 각각 변수에는 어떠한 값이 저장되겠는가? 확인 하는 코드를 작성하고, 그 결과에 대해 설명.
		// num1=num2=num3 ;
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
				
		num1 = num2 = num3;
				
		System.out.println("num1 : " +num1+ ", num2 : " +num2+ ", num3 : " +num3);
		
		// 문제 2. 수학식 {{(25x5)+(36-4)}-72}/5 의 계산결과를 출력하는 프로그램 작성.
		num1 = 25;
		num2 = 5;
		num3 = 36;
		int num4 = 4;
		int num5 = 72;
		int num6 = 5;
		int result;
				
		result = (num1*num2 + num3 - num4 - num5)/num6;
		System.out.println(result);
		System.out.println("================");
		
		// 문제 3. ﻿3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성. 단, 덧셈 연산의 횟수 최소화
		int sum = 3; 
		for(int i=2; i<5; i++) {
			sum = sum + i*3;
			System.out.println(sum);
		}
		
		// 문제 4. ﻿a= {{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
		// a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성
		int a = (25+5+36/4-72)*5;
		int b = (25*5+36-4-71)/4;
		int c = (128/4)*2;
		boolean boo;
		
		if(a>b && b>c) {
			boo = true;
		}
		else {
			boo = false;
		}
		System.out.println("a>b>c : " + boo);
		System.out.println("================");
		
		// [과제] 연산자 추가 문제
		// 1번
		int x = 2;
		int y = 5;
		char ch = 'A'; // 'A'의문자코드는 65

		System.out.println(y += 10 - x++); // y = y+10 -x++(값 대입 후 증가) = 5+10-2 = 13 출력, int x = 3
		System.out.println(x += 2); // x = x+2 = 3+2 = 5 
		System.out.println(!('A' <= ch && ch <= 'Z')); // !(65 <= 65 <= 90) = !(true) = false
		System.out.println('C' - ch); // 67 - 65 = 2
		System.out.println('5' - '0');  // 53 - 48 = 5
		System.out.println(ch + 1);  // 65 + 1 = 66
		System.out.println(++ch);  // ++ch(증가 후 값 대입) -> 65 + 1 = 66 -> char(66) = 'B'
		System.out.println(ch++);  // ch++(값 대입 후 증가) -> B 출력, (int)ch++ = 66 + 1 = 67 -> 'C'
		System.out.println(ch);  // ch -> C
		
		// 2번. 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
		// 만일 사과의수가 123개이고 하나의 바구니에는10개의 사과를 담을 수 있다면,13개의 바구니가 필요할 것이다.(1)에 알맞은 코드를 넣으시오.
		// [실행결과 : 13]

		int numOfApples = 123; // 사과의 개수
		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBucket = (numOfApples%sizeOfBucket==0)? numOfApples/sizeOfBucket : numOfApples/sizeOfBucket +1; 
		// 모든 사과를담는데 필요한 바구니의 수
		
		System.out.println("필요한바구니의 수 :"+numOfBucket);
		
		// 3번. 아래는 변수 num의 값에 따라 ‘양수’,‘음수’,‘0’을 출력하는 코드이다.삼항 연산자를 이용해서(1)에 알맞은 코드를 넣으시오.
		// [Hint] 삼항 연산자 두 번 사용하라.
		// [실행 결과 : 양수]
		int num = 10;
		System.out.println((num>0)? "양수": ((num<0)? "음수" : "0"));

		// 4번. 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
		// 만일 변수 num 의 값이‘456’이라면 ‘400’이 되고,‘111’이라면 ‘100’이 된다.(1)에 알맞은 코드를 넣으시오. 
		// [실행 결과 : 400]﻿
		num = 456;
		System.out.println(num - num%100);
		
		// 5번. 아래는 변수num의 값 중에서 일의 자리를1로 바꾸는 코드이다.
		// 만일 변수 num의값이 333이라면 331이 되고,777이라면 771이 된다.(1)에 알맞은 코드를 넣으시오.
		// [실행 결과 : 331]
		
		
		
		
	}

	void hiEveryone() { // MethodTest 클래스가 가지는 멤버
		System.out.println("안녕하세요~"); // void로 불러오면 부를 수 없음??
	}

}
