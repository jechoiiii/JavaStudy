package ver04;

import ver04.Util;
import ver04.PhoneInfo;

public class PhoneBookManager {

	// 전화번호 정보를 저장할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 검색, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계이기 때문에 PhoneInfo 타입으로 선언
	private PhoneInfo[] phoneBook;	// 전화번호 정보를 저장할 배열
	private int cnt;			// 배열에 저장된 요소의 개수, 배열의 index
	
	// 생성자로 정보 초기화
	public PhoneBookManager(int num){
		phoneBook = new PhoneInfo[num]; // 생성자의 매개변수의 인자를 전달 받아 배열 생성
		cnt = 0;
	}
	
	// 정보 저장 기능
	// 	 1. 배열에 저장 메서드 : 다형성을 이용해서 하나의 메서드로 정의  addInfo(상위클래스타입의 매개변수)
	//   2. 사용자에게 받은 데이터를 인스턴스 생성 메서드
	//		입력의 구분 -> 구분에 따라 인스턴스 생성도 구분 -> addInfo() 메서드를 이용해서 정보 저장

	
	// 정보를 배열에 저장 (캡슐화)
	private void addInfo(PhoneInfo p) {
		phoneBook[cnt++] = p;
	}
	
	// 전화번호 정보를 인스턴스 생성하고 배열에 저장 
	// 분기 ( 1.지인	2.대학교 친구 	3.회사 동료	4.동호회 회원 )
	public void addPhoneInfo(int choice) {
		
		System.out.println("기본 정보 입력을 시작합니다.\n");
		
		System.out.println("이름을 입력해주세요 >> ");
		String name = Util.sc.nextLine();
		System.out.println("전화번호를 입력해주세요 >> ");
		String phoneNum = Util.sc.nextLine();		
		System.out.println("주소를 입력해주세요 >> ");
		String addr = Util.sc.nextLine();	
		System.out.println("이메일을 입력해주세요 >> ");
		String email = Util.sc.nextLine();	
	
		
		if(choice==1) { // 일반 지인
			addInfo(new PhoneInfo(name, phoneNum, addr, email));
			
		} else if(choice==2) { // 대학교 친구 
			System.out.println("전공을 입력해주세요 >> ");
			String major = Util.sc.nextLine();	
			System.out.println("학년을 입력해주세요 >> ");
			int grade = Util.sc.nextInt();	

//			PhoneInfo p = new PhoneUnivInfo(name, phoneNum, email, major, year, addr);
//			addInfo(p);
			addInfo(new PhoneUnivInfo(name, phoneNum, addr, email, major, grade));
			
		} else if(choice==3) { // 회사 동료 
			System.out.println("소속 회사를 입력해주세요 >> ");
			String comp = Util.sc.nextLine();	
			addInfo(new PhoneCompanyInfo(name, phoneNum, addr, email, comp));
			
		} else if(choice==4) { // 동호회 회원
			System.out.println("동호회 내 역할을 입력해주세요 >> ");
			String cafeName = Util.sc.nextLine();
			String nickName = Util.sc.nextLine(); 
			addInfo(new PhoneCafeInfo(name, phoneNum, addr, email, cafeName, nickName));
			
		} else {
			return;
		}
		
	System.out.println("입력이 완료되었습니다.");
	}
	
	
	// 전체 정보를 출력하는 메서드
	public void showAllInfo() {
		System.out.println("전체 정보를 출력합니다.");
		for(int i=0; i<cnt; i++) {
			phoneBook[i].showInfo();
		}
	}



}
