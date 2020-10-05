package first;

import java.lang.Math; // Math 사용할때 필요!
import java.util.Scanner;

public class OperatorTest {

	public static void main(String[] args) {
		
		// 03. 연산자
		
		// 대입 연산과 산술 연산
		int n1=7;
		int n2=3;
		
		int result = n1+n2;		// 연산 순서: n1+n2 -> int result = n1+n2 
		System.out.println("덧셈 결과: " +result);		// 10		
		result = n1-n2;
		System.out.println("뺄셈 결과: " +result);		// 4 // 변수는 여러번 저장할 수 있다. 변수가 변하지 않길 원하면 상수화(final)		
		System.out.println("곱셈 결과: " +n1*n2);		// 21
		System.out.println("나눗셈 결과: " +n1/n2);		// 2 // 피 연산자가 정수면 정수형 연산 진행. *단 %연산자 제외!
		System.out.println("나머지 결과: " +n1%n2);		// 1
		
		// 나눗셈 연산자와 나머지 연산자에 대한 보충
		int num1 = 10; 
		int num2 = 8;
		
		System.out.println("10/8 = " + num1/num2);		// 1
		System.out.println("10/8 = " + num1%num2);		// 2
		System.out.println("10/8 = " + num1/-8);		// -1
		System.out.println("10/8 = " + num1%-8);		// 2	// %의 경우, x%y에서 연산은 x의 부호를 따라간다. 10%(-)8 -> 2, -10%(-8) -> -2
		System.out.println("10f/8f = " + 10f/8f);		// 1.25	// float/float => float		
		System.out.println("10f/8 = " + 10f/8);			// 1.25 // float/int => float		
		System.out.println("10/8 = " + num1/(float)num2);// 1.25 // int/(float)int => float // 변수 자체가 바뀌지는 않고, 데이터 타입만 바뀌어서 연산됨 	
		System.out.println("정수형 나눗셈: " +7/3);			// 2
		System.out.println("실수형 나눗셈: " +7.0f/3.0f);	// 2.3333333 // float/float => float
		System.out.println("형변환형 나눗셈: " +(float)7/3);	// 2.3333333 // (float)int/int -> float/float => float // 더 큰 데이터 타입으로 형변환한다. int<long<float<double
		
		// 관계(비교) 연산
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println("'A' < 'B' => " + (c1 < c2));	// true	// 비교 연산은 후순이기에 먼저 연산되기 위해서 괄호 필요
		System.out.println("'0' == 0 => " + ('0' == 0));	// false // 48 == 0
		System.out.println("10.0d == 10.0f => " + (10.0d == 10.0f));	// true // 10.0d == 10.0d 자동으로 형변환
		System.out.println("0.1d == 0.1f => " + (0.1d == 0.1f));	// true // 0.1d == 0.1d
		
		double d = (double)0.1f;
		System.out.println("d => " + d);	// 0.1000000~~ //
		System.out.println("(float)d == 0.1f => " + ((float)d == 0.1f));	// true // (float)double = float
		
		int A=10, B=20;
		
		if(true) {
			System.out.println("참입니다.");
		}else {
			System.out.println("거짓입니다.");			// 참입니다.
		}
		if(A>B) {
			System.out.println("A가 더 큽니다.");
		}else {
			System.out.println("A가 더 크지 않습니다.");	// A가 더 크지 않습니다.
		}
		if(A!=B) {
			System.out.println("A와 B는 다릅니다.");
		}else {
			System.out.println("A와 B는 같습니다.");		// A와 B는 다릅니다.
		}
		
		// 논리연산자
		char x = 'j';
		boolean result0 = ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || (x >= 0 && x <= 9));	// 소문자 || 대문자 || 숫자
		System.out.println(result0);	// true
		
		num1 = 10;
		num2 = 20;
		
		boolean result1 = num1 == 10 && num2 == 20;
		 //처리순서 :      4)     1)     3)      2)
		boolean result2 = num1 <= 12 || num2 >= 30;		// Short-Circuit Evaluation: 둘 중 하나 true이면 다른 거 판정 필요 x
		 //처리순서 :      2)    (처리 필요없음)     1)
		System.out.println("num1 == 10 && num2 == 20 => " + result1);
		System.out.println("num1 <= 12 || num2 >= 30 => " + result2);
		
		if(!(num1 == num2)) {
			System.out.println("num1과 num2는 같지 않다");
		} else {
			System.out.println("num1과 num2는 같다");
		}
		
//		===================================================
		
		float pi = 3.141592f;
		
		float sPi = (int)(pi*100)/100f; // /100f 하면 float타입으로 3.14, /100하면 int타입으로 3
		
		System.out.println(sPi);		// 3.0 <- 소수점을 버렸지만 표현되는 이유는 float 타입이라
		
		int price = 11234;
		int price2 = price/1000*1000;
		
		System.out.println(price2);
		
		float sPi2 = Math.round(pi*100)/100f;		// .java.long.Math 공식명칭. 맨 위 package 다음에 import java.lang.Math; 써야 함
		
		System.out.println(sPi2);	// 변수를 메모리에 올리는 과정 = 인스턴스화 = 객체화
		
		
		// 전위형/후위형 증감연산자
		int i = 5; 
		int j = 5;
		
		System.out.println(i++);	// 출력 : 5, i = 6
		System.out.println(++j);	// 출력 : 6, j = 6
		
		System.out.println("i = " + i + ", j = " + j);
		
		
		// 문자열 처리 : String 클래스 이용 -> 객체 생성 -> 클래스가 가지는 변수와 메서드를 메모리에 로드한다
		
		// 참조 변수 : 객체의 메모리 주소값을 저장하는 변수
		String str = null;	// null -> 참조변수가 객체의 주소값을 저장하고 있지 않는다를 의미
		
	//	str = "";  // "" 공백 문자열을 이용한 객체를 생성하고 주소값을 받환
		str = "abc";	// "" 공백 문자열을 이용한 객체를 생성하고 주소값을 받환
		
		System.out.println(str.toString());
		System.out.println(str.equals("abc"));	// "abc" 갖고있는 문자열과 비교하여 반환...huh?
		
		if(str != null && !str.equals("")) {
			System.out.println( str.charAt(1));	// index에 0~3-1 -> 0, 1, 2 들어갈 수 있음
		}
		
		
		num1 = 50;
		num2 = 20;
		
		int big = 0;	// 큰 수
		int diff = 0;	// 두 수의 차이
		
		// 삼항연산자 이용
	//	big = num1>num2 ? num1 : num2 ;		// big = num1 ;		
	//	diff = num1>num2 ? num1-num2 : num2-num1 ;
		
		// 삼항연산자 없이
		if(num1>num2) {
			big = num1;
			diff = num1 - num2;
		} else {
			big = num2;
			diff = num2 - num1;
		}
		
		System.out.println("큰수 : " +big+ ", 큰수와 작은 수의 차이는 "+diff+"입니다.\t");
		
		
		
		// Switch문 
		int n=0;
		
		System.out.println("메뉴를 선택하세요\n1.입력 2.보기 3.수정 4.삭제");
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();		// Console에 빨간 박스는 진행 중이라는 의미. 아직 입력을 안했기 때문에
				
		switch(n) {
			case 1:
				System.out.println("입력 합니다.");
				System.out.println("Simple Java");
				break;
			case 2:
				System.out.println("데이터를 열람합니다.");
				System.out.println("Funny Java");
				break;
			case 3:
				System.out.println("정보를 수정합니다.");
				System.out.println("Fantastic Java");
				break;
			case 4:
				System.out.println("정보를 삭제합니다.");
				System.out.println("Best Java");
				
		/*	default:
				System.out.println("Best Java");
		 */
		}
		

		
		// 과제 : 자바의 정석 문제 풀이
		// 문제 1. int형 변수 num1, num2, num3가 각각 10,20,30 으로 초기화 되어 있다.
		// 다음문장을 실행하면 각각 변수에는 어떠한 값이 저장되겠는가? 확인 하는 코드를 작성하고, 그 결과에 대해 설명.
		// num1=num2=num3 ;
		num1 = 10;
		num2 = 20;
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
						
		result = (num1*num2 + num3 - num4 - num5)/num6;
		System.out.println(result);
		
		// 문제 3. ﻿3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성. 단, 덧셈 연산의 횟수 최소화
		int sum = 3;
		for (i = 2; i < 5; i++) {
			sum = sum + i * 3;
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
		

	}

}
