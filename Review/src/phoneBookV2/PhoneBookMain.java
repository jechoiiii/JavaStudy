package phoneBookV2;

/*
	파일 이름 : phoneBookV2.PhoneBookMain.java
	내 용 : 전화번호 관리 프로그램 ver02
	수정 사항 : 프로그램 사용자로부터 데이터 입력
				프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스 생성
				프로그램을 종료하지 않는 한 프로그램의 흐름이 유지되도록 반복
	작성 일시 : 2020.10.29
*/

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		// Scanner 클래스 import
		Scanner sc = new Scanner(System.in);
		
		// 사용자의 입력 무한반복
		while(true) {
			
			System.out.println("전화번호부 정보 입력을 시작합니다.");
			
			System.out.println("이름  >>> ");
			String name = sc.nextLine(); 
			
			System.out.println("전화번호  >>> ");
			String phoneNum = sc.nextLine(); 			
			
			System.out.println("생일  >>> ");
			String birthday = sc.nextLine(); 

			// PhoneInfo 인스턴스 생성
			PhoneInfo info = null;
			
			if(birthday.trim().isEmpty()) { // .length()==0
				info = new PhoneInfo(name, phoneNum, birthday);
			} else {
				info = new PhoneInfo(name, phoneNum);
			}	

			info.showInfo();		
			
		}	
		
	}	
}
