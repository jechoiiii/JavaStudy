package ver04;

import java.util.Scanner;

/*
	파일 이름 : ver04.java
	내용 : 전화번호부 프로그램 흐름
	작성 일시 : 2020.10.19
*/

public class PhoneBookMain {

	public static void main(String[] args) {
				
		PhoneBookManager manager = new PhoneBookManager(10);	// 등록할 연락처 최대 10개
				
		while(true) {
		
			System.out.println();
			System.out.println("=======메뉴를 선택하세요=======");
			System.out.println(" 1. 일반 지인 정보 입력 ");
			System.out.println(" 2. 대학교 동기 정보 입력");
			System.out.println(" 3. 회사 동료 정보 입력");
			System.out.println(" 4. 동호회 회원 정보 입력");
			System.out.println(" 5. 전체 정보 출력 ");
			System.out.println(" 6. 기본 정보 출력 ");
			System.out.println(" 7. 프로그램 종료");
			System.out.println("===========================");
			
			int choice = Util.sc.nextInt();
			Util.sc.nextLine();
			
			switch(choice) {
				case 1 : case 2 : case 3 : case 4 :
					manager.addPhoneInfo(choice);
					break;
				case 5 :
					manager.showAllData();
					break;
				case 6 :
					manager.showAllBasicData();
					break;					
				case 7 :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;	
			}
		}		

	}
}
