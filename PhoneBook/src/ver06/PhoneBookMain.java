package ver06;

import java.util.InputMismatchException;

import ver03.Util;

public class PhoneBookMain implements Util {

	public static void main(String[] args) throws WrongMenuException, NoInputException {

		PhoneBookManager manager = PhoneBookManager.getInstance();	

			while(true) {
				System.out.println("\n메뉴를 입력해주세요. ==============");
				System.out.println(Menu.INSERT +". 저장");
				System.out.println(Menu.SEARCH +". 검색");
				System.out.println(Menu.DELETE +". 삭제");
				System.out.println(Menu.DISPLAY_ALL +". 모든 정보 출력");
				System.out.println(Menu.EXIT +". EXIT");
				
				System.out.println("\n>>");
				
// 2020.10.23 수정 : 사용자 메뉴 입력 시 예외처리
				
				int select = 0;
				
				try {
					select = SC.nextInt();	
					
					if( !(select>=Menu.INSERT && select <=Menu.EXIT) ) {
						BadInputException e = new BadInputException(String.valueOf(select));
						throw e;
					}
		
				} catch(InputMismatchException | BadInputException e) {
					System.out.println("잘못된 입력입니다. 메뉴 번호를 입력해주세요.");
					SC.nextLine();
					continue;
				} catch(Exception e1) {
					System.out.println("메뉴의 선택이 올바르지 않습니다. 다시 선택해주세요.");
					SC.nextLine();
					continue; // 메뉴 선택으로 다시 올리기
				}			
				
				switch (select) {
				case Menu.INSERT :
					manager.insertInfo();
					break;
				case Menu.SEARCH :
					manager.searchInfo();
					break;
				case Menu.DELETE :
					manager.deleteInfo();
					break;
				case Menu.DISPLAY_ALL :
					manager.showAllInfo();
					break;
				case Menu.EXIT :
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				
			}

	}
}
