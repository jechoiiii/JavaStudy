package exception;

import java.util.InputMismatchException;

import java.util.Scanner;

public class DividedByZero {	// 0으로 나눴을 때의 예외처리

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1=0, num2=0; 
		
		while(true) {
			try {
				System.out.println("두 개의 정수를 입력");
				System.out.println("숫자 1 >>");
				num1 = sc.nextInt();
		
				System.out.println("숫자 2 >>");
				num2 = sc.nextInt();	
			} catch (InputMismatchException e) {
				System.out.println("올바른 메뉴를 다시 선택하세요");
				continue; // 무한 반복
			}	
			break;	// 무한 반복 종료
		}

		try {
			System.out.println("나눗셈의 몫 : "+ num1/num2);
			System.out.println("나눗셈의 나머지 : "+ num1%num2);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기 할 수 없음");
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");

	}

}
