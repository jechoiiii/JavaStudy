package exam;

public class ExamOper1 {

	public static void main(String[] args) {
		
		// 과제: 자바의 정석 문제 풀이
	/* 	문제 1. int형 변수 num1, num2, num3가 각각 10,20,30 으로 초기화 되어 있다.
		다음문장을 실행하면 각각 변수에는 어떠한 값이 저장되겠는가? 확인 하는 코드를 작성하고, 그 결과에 대해 설명.
		num1=num2=num3; */
		System.out.println("문제 1 -----------------------------------");
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;

		num1 = num2 = num3;	// 대입연산자의 연산방향은 오른쪽->왼쪽으로

		System.out.println("num1 : " + num1 + ", num2 : " + num2 + ", num3 : " + num3);
		

	/* 문제 2. 수학식 {{(25x5)+(36-4)}-72}/5 의 계산결과를 출력하는 프로그램 작성. */
		System.out.println("문제 2 -----------------------------------");
		
		num1 = 25;
		num2 = 5;
		num3 = 36;
		int num4 = 4;
		int num5 = 72;
		int num6 = 5;
		int result;

		result = (((num1 * num2) + (num3 - num4)) - num5) / num6;	// {} -> () 자바에서 {} 중괄호는 특정한 의미를 지닌다.
		System.out.println(result);
		
	/* 	문제 3. ﻿3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성. 단, 덧셈 연산의 횟수 최소화 */
		System.out.println("문제 3 -----------------------------------");
		
		int sum = 3;
		for (int i = 2; i < 5; i++) {
			sum = sum + i * 3;
			System.out.println(sum);
		}
		
		int oper1 = 3+6;		
		int oper2 = oper1 + 9;
		int oper3 = oper2 + 12;
		// 연산은 줄이는 것은 CPU에 부담을 줄이는 것 => 최적화

	/* 	문제 4. ﻿a= {{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
	 	a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성 */
		System.out.println("문제 4 -----------------------------------");
		
		int a = ((25 + 5) + (36 / 4) - 72) * 5;
		int b = ((25 * 5) + (36 - 4) - 71) / 4;
		int c = (128 / 4) * 2;

		boolean check = a>b && b>c;
		System.out.println(check);
				
		boolean boo;
		if (a > b && b > c) {
			boo = true;
		} else {
			boo = false;
		}
		System.out.println("a>b>c : " + boo);
		
		

	}

}
