package ver0402;

import ver03.Util;

public class PhoneBookManager {

	// 전화번호 정보를 저장할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 검색, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계이기 때문에 PhoneInfo 타입으로 선언
	private PhoneInfo[] pBook;	// 전화번호 정보를 저장할 배열
	private int cnt;			// 배열에 저장된 요소의 개수, 배열의 index
	
	// 생성자
	PhoneBookManager(int num){
		pBook = new PhoneInfo[num];		// 생성자의 매개변수의 인자를 전달 받아 배열 생성
		cnt = 0;
	}
	
	// 정보 저장 기능
	// 	 1. 배열에 저장 메서드 : 다형성을 이용해서 하나의 메서드로 정의  addInfo(상위클래스타입의 매개변수)
	//   2. 사용자에게 받은 데이터를 인스턴스 생성 메서드
	//		입력의 구분 -> 구분에 따라 인스턴스 생성도 구분 -> addInfo() 메서드를 이용해서 정보 저장
	
	// 배열에 전화번호 정보를 저장하는 메서드
	private void addInfo(PhoneInfo info) {
		pBook[cnt++] = info;
	}
	
	// 전화번호 정보를 인스턴스 생성하고 배열에 저장
	public void  insertInfo() {

		// 100개 입력	0<=index<=99, cnt=100
		// pBook[100] -> 오류
		// 배열의 개수와 입력된 요소의 개수를 비교
		if(pBook.length==cnt) {
			System.out.println("더이상 정보를 저장할 수 없습니다.");
			System.out.println("일부 정보를 삭제하고 저장 공간을 확보해주세요.");
		}
		
		System.out.println("어떤 정보를 입력하겠습니까");
		System.out.println(" 1. 기본");
		System.out.println(" 2. 대학");
		System.out.println(" 3. 회사");
		System.out.println(" 4. 동호회");
		
		int select = Util.SC.nextInt();
		
		Util.SC.nextLine();
			// nextInt() 에서 사용자가 입력한 숫자 뒤 공백을 입력으로 인식해서 넘어감. 
			// 역할 : 숫자 뒤 공백을 반환. -> 호출할게 없으니 넘어감. 	
		
		if( !(select>0 && select<5) ) {
			System.out.println("메뉴 선택이 올바르지 않습니다.");
			System.out.println("초기 메뉴로 지나갑니다.");
			return;
		}
		
		System.out.println("정보 입력을 시작합니다.");
		System.out.println("이름 >> ");
		String name = Util.SC.nextLine();
		System.out.println("전화번호 >> ");
		String phoneNum = Util.SC.nextLine();
		System.out.println("주소 >> ");
		String addr = Util.SC.nextLine();
		System.out.println("이메일 >> ");
		String email = Util.SC.nextLine();
		
		switch(select) {
			case 1 :
				// 인스턴스 생성 -> 배열에 저장
				addInfo(new PhoneInfo(name, phoneNum, addr, email));
				break;
				
			case 2 :
				// 추가 정보  받고 -> 인스턴스 생성 -> 배열에 저장
				// 전공, 학년
				System.out.println("전공 >> ");
				String major = Util.SC.nextLine();
				System.out.println("학년 >> ");
				int grade = Util.SC.nextInt();
				
				addInfo(new UnivPhoneInfo(name, phoneNum, addr, email, major, grade));
				break;
				
			case 3 :
				// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
				// 회사 이름
				System.out.println("회사 이름 >> ");
				String company = Util.SC.nextLine();
				
				addInfo(new CompanyPhoneInfo(name, phoneNum, addr, email, company));
				break;
				
			case 4 :
				// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
				// 동호회 이름, 닉네임
				System.out.println("동호회 이름 >> ");
				String cafeName = Util.SC.nextLine();
				System.out.println("닉네임 >> ");
				String nickName = Util.SC.nextLine();
				
				addInfo(new CafePhoneInfo(name, phoneNum, addr, email, cafeName, nickName));
				break;
		}
		System.out.println("입력하신 정보가 저장되었습니다. (저장 개수 : " +cnt +")");
	}
	
	// 정보 검색 기능
		// 배열의 index를 찾는 메서드
		// 해당 index의 참조변수로 정보 출력
	
	// 배열의 index를 찾는 메서드
	private int searchIndex(String name) {
		int index = -1;	// 찾는 정보가 없을 때
				
		for(int i=0; i<cnt; i++) {
			// 이름으로 비교
			if(pBook[i].getName().equals(name)) {	// pBook[i].getName() == name
				index = i;
			}
		}
		return index;
	}
	
	// 해당 index의 참조변수로 정보 출력 : 사용자가 입력한 이름으로 검색
	public void searchInfo() {	// ?? ()참조변수에 int index 안쓰는 이유

		if(cnt==0) {	// CPU 할당되지 않도록
			System.out.println("입력된 정보가 없습니다.");
			return;	// 프로그램 종료
		}
		
		Util.SC.hasNextLine();
		System.out.println("검색하실 이름을 입력해주세요.");
		String name = Util.SC.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("검색하신 이름 "+name+"의 정보가 존재하지 않습니다.");
			System.out.println("메뉴로 돌아갑니다.");
		} else {
			System.out.println("검색 결과 ===============");
			pBook[index].showInfo();
		}
	}
	
	// 정보 삭제 기능
		// 사용자에게 이름을 입력 받고 이름으로 검색한 후 정보 삭제
	public void deleteInfo() {
		
		if(cnt==0) {	// CPU 할당되지 않도록
			System.out.println("삭제할 정보가 없습니다.");
			return;	// 프로그램 종료
		}
		
		Util.SC.nextLine();	
		
		System.out.println("삭제하실 이름을 입력해주세요.");
		String name = Util.SC.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름" +name+ "의 정보가 존재하지 않습니다.");
			System.out.println("메뉴로 이동합니다.");
		} else {
			// 배열의 요소를 왼쪽으로 시프트
				// 참조값이 없는 인스턴스는 자바에서 삭제한다.
			for(int i=index; i<cnt-1; i++) {
				pBook[i] = pBook[i+1];
			}
			cnt--;	// 저장된 개수를 감소 *배열의 요소 개수 중 하나를 없애야 한다.
			System.out.println("요청하신 정보를 삭제했습니다.");
		}
	}
	
	// 전체 정보 출력 기능
	public void showAllInfo() {
		
		if(cnt==0) {	// CPU 할당되지 않도록
			System.out.println("입력된 정보가 없습니다.");
			return;	// 프로그램 종료
		}
		
		System.out.println("전체 정보를 출력합니다.================");
		for(int i=0; i<cnt; i++) {
			pBook[i].showInfo();
			System.out.println("--------------------");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
