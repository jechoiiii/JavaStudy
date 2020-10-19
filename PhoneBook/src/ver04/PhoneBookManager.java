package ver04;

public class PhoneBookManager {

	// 정보 저장을 위해 배열로 선언
	private PhoneInfo[] phoneBook;	// PhoneInfo 타입의 배열 phoneBook
	private int numOfPeople;	
	
	// 생성자로 정보 초기화
	public PhoneBookManager(int num){
		phoneBook = new PhoneInfo[num];
		numOfPeople = 0;
	}
	
	// 정보를 배열에 저장 : 다형성 이용
	void addInfo(PhoneInfo p) {
		phoneBook[numOfPeople++] = p;
	}
	
	// 분기 ( 1.지인	2.대학교 친구 	3.회사 동료	4.동호회 회원 )
	void addPhoneInfo(int choice) {
		
		System.out.println("기본 정보 입력을 시작합니다.\n");
		
		System.out.println("이름을 입력해주세요 >> ");
		String name = Util.sc.nextLine();
		System.out.println("전화번호를 입력해주세요 >> ");
		String pNum = Util.sc.nextLine();		
		System.out.println("이메일을 입력해주세요 >> ");
		String email = Util.sc.nextLine();	
	
		
		if(choice==1) { // 일반 지인
			addInfo(new PhoneInfo(name, pNum, email));
			
		} else if(choice==2) { // 대학교 친구 
			System.out.println("전공을 입력해주세요 >> ");
			String major = Util.sc.nextLine();	
			System.out.println("학년을 입력해주세요 >> ");
			String year = Util.sc.nextLine();	
			System.out.println("주소를 입력해주세요 >> ");
			String addr = Util.sc.nextLine();	

//			PhoneInfo p = new PhoneUnivInfo(name, pNum, email, major, year, addr);
//			addInfo(p);
			addInfo(new PhoneUnivInfo(name, pNum, email, major, year, addr));
			
		} else if(choice==3) { // 회사 동료 
			System.out.println("소속 회사를 입력해주세요 >> ");
			String comp = Util.sc.nextLine();	
			addInfo(new PhoneCompanyInfo(name, pNum, email, comp));
			
		} else if(choice==4) { // 동호회 회원
			System.out.println("동호회 내 역할을 입력해주세요 >> ");
			String role = Util.sc.nextLine();
			addInfo(new PhoneCafeInfo(name, pNum, email, role));
			
		} else {
			return;
		}
		
	System.out.println("입력이 완료되었습니다.");
	}
	
	
	// 전체 정보를 출력하는 메서드
	public void showAllData() {
		System.out.println("전체 정보를 출력합니다.");
		for(int i=0; i<numOfPeople; i++) {
			phoneBook[i].showData();
		}
	}

	// 기본 정보를 출력하는 메서드
	public void showAllBasicData() {
		System.out.println("기본 정보를 출력합니다.");
		for(int i=0; i<numOfPeople; i++) {
			phoneBook[i].showBasicInfo();
		}
	}
}
