package phoneBookV3;

import java.util.Scanner;

/*
	파일 이름 : phoneBookV3.PhoneBookMain.java
	내       용 : 전화번호 관리 프로그램 ver03
	수정 사항 : 
			1) 배열을 이용해 사용자 입력 정보 최대 100개까지 유지 
			2) 저장, 검색, 삭제, 출력 기능 추가 
				저장 : 이름, 전화번호, 생년월일 정보 저장  
				검색 : 이름을 입력받아 해당 데이터 출력 
				삭제 : 이름을 입력받아 해당 데이터 삭제 
				삭제 후 데이터 빈 공란 없도록 순차적으로 재정리 (삭제 대상 이후 데이터들의 주소 값이 -1 처리되어 재저장)
	작성 일시 : 2020.10.14
*/	

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
			
			if( !(birthday.trim().isEmpty()) ) { // .length()==0
				info = new PhoneInfo(name, phoneNum, birthday);
			} else {
				info = new PhoneInfo(name, phoneNum);
			}	

			info.showInfo();		
			
		}	
		
	}	
}
