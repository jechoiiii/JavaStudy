package ver0502;

import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {

		// PhoneBookManager manager = new PhoneBookManager(100);	// 최대 100개까지 저장 가능
		PhoneBookManager manager = PhoneBookManager.getInstance();	// 싱글톤 -> 참조값 인스턴스 생성
		
		while(true) {
			System.out.println("메뉴를 입력해주세요. ==============");
			System.out.println(Menu.INSERT +". 저장");
			System.out.println(Menu.SEARCH +". 검색");
			System.out.println(Menu.DELETE +". 삭제");
			System.out.println(Menu.DISPLAY_ALL +". 모든 정보 출력");
			System.out.println(Menu.EXIT +". EXIT");
			
			System.out.println("\n>>");

			int select = Util.sc.nextInt();
			
			if( !(select>0 && select<6) ) {
				System.out.println("메뉴의 선택이 올바르지 않습니다. \n다시 선택해주세요.");
				continue;	// 메뉴 선택으로 다시 올리기
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
