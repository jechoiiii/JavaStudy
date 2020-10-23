package friend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FriendInfoMain {

	public static void main(String[] args) {
	
		//Friend f = new Friend();
		
		FriendInfoHandler handler = new FriendInfoHandler(10);	// 하나만 만들어서 사용한다. 
		
		Scanner s = new Scanner(System.in);
				
		while(true) {
			System.out.println("*** 메뉴 선택하세요 ***");
			System.out.println(Menu.INSERT_HIGH+ ". 고교 친구 정보 저장");
			System.out.println(Menu.INSERT_UNIV+ ". 대학 친구 정보 저장");
			System.out.println(Menu.SHOW_ALL+ ". 전체 정보 출력");
			System.out.println(Menu.SHOW_BASIC+ ". 기본 정보 출력");
			System.out.println(Menu.EXIT+ ". EXIT");
			System.out.println("선택하세요 >>");
		
// 2020.10.23 수정 : 예외 처리
			
			int choice =0;

			try {
				choice = s.nextInt();
				
				if( !(choice>=Menu.INSERT_HIGH && choice<=Menu.EXIT) ) {
					BadMenuException e = new BadMenuException("잘못된 메뉴 입력");
					throw e;
				}
			} catch (InputMismatchException | BadMenuException e) { // 연습용 예외처리 (필요x), Exception만 import 해도 충분
				System.out.println("잘못된 메뉴 입력입니다. \n다시 선택해주세요.");
				s.nextLine();
				continue;	// 맨 마지막 블록으로 감. switch문 실행 X
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다. \n다시 선택해주세요.");
				s.nextLine();
				continue;
			}
			
			switch(choice) {
				case Menu.INSERT_HIGH : case Menu.INSERT_UNIV : 
					handler.addFriend(choice);
					break;
				case Menu.SHOW_ALL :
					handler.showAllData();
					break;
				case Menu.SHOW_BASIC :
					handler.showAllSimpleData();
					break;
				case Menu.EXIT :
					System.out.println("프로그램을 종료합니다");
					return;	// 메서드에서 종료 
			}
			
		}
		
	}

}
