package ver02;

/*
	파일 이름 : ver02.java
	내용 : 전화번호 관리 프로그램에 사용자의 데이터 입력 메서드 추가
	작성 일시 : 2020.10.12
 */

import java.util.Scanner;

import ver03.*;

public class PhoneBookMain {

	public static void main(String[] args) {
		
/*
  		Project : ver 0.20
  		
  		"프로그램 사용자로부터 데이터 입력"
		프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
		단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
		프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
		
 */
		// 사용자에게 데이터를 받는다.
		Scanner s = new Scanner(System.in);
		
//		Util.sc.nextLine();
		
		while(true) { // 무한반복
		
		// 인스턴스 생성을 위해서는 이름, 전화번호, 생일 데이터를 받는다.
			System.out.println("저장을 위해 데이터를 입력해주세요.");
			
			System.out.println("이름을 입력해주세요.");
			String name = s.nextLine();
			
			System.out.println("전화번호를 입력해주세요.");
			String phoneNumber = s.nextLine();
			
			System.out.println("생년월일을 입력해주세요.");
			String birthday = s.nextLine();	
			
		// 인스턴스 생성
			//PhoneInfo info = new PhoneInfo(name, phoneNumber, birthday);
			PhoneInfo info = null;
		
		// 입력값 없이 enter 인 경우 공백 문자열을 반환
		// 문자열의 길이가 0이면 	=> .length() 또는 .isEmpty()
			//if(birthday.length()==0) {	
		// space enter 한 경우 공백 문자열을 그대로 반환	=> .trim()	
			if(birthday.trim().isEmpty()) {	// length()==0 => true
				info = new PhoneInfo(name, phoneNumber, null);
			} else {
				info = new PhoneInfo(name, phoneNumber, birthday.trim());
			}
			
			/* 
				trim() : 문자열의 앞뒤 공백문자를 지우는 메서드
			 	문자열 간 공백은 지우지 않음
				"  123  ".trim() => "123"
				"   12  4    ".trim() => "12  4"
			*/			
			
			
		// 메서드 호출
			info.showInfo();
			
	
		}

		
	}

}
