package ver03;

import java.util.Scanner;

/*
	파일 이름 : ver03.java
	내용 : 정보 저장/검색/삭제/보기 메서드 (배열 사용)
	작성 일시 : 2020.10.14
*/

public class PhoneBookManager {

/*		
	Project : ver 0.30 
	
	배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 아래기능 삽입 
	
	저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장  	
			//	인스턴스 생성 -> 배열에 추가
	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력 
			//	참조변수 직접 비교 equals() or 배열의 index 찾아 출력
	삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제 
			//	참조변수의 주소값을 null로 초기화 or 다른 주소를 대입 or shift 처리

	데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로  재정리. 
	2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장. 		
*/		 
	// 배열의 주소값만 배열 변수에 넣어서 저장한다. 

	// 배열 정의
	// 배열 : 전화번호 정보 (이름, 전화번호, 생일)를 저장
	// 저장공 상수화 
	final PhoneInfo[] phoneBook; // 정보 저장을 위한 배열 선언 (PhoneInfo타입 [] 배열의 이름;) 
	int cnt; // 저장된 정보의 개수 : 반복의 횟수로 사용 & 배열에 새로운 데이터 입력 시 index로 사용
	
//	Scanner sc;
	
	// 배열 초기화 (생성자)
	// 생성자는 클래스 이름과 동일, int 타입의 매개변수만 
	PhoneBookManager(int size) { 
		// 배열의 저장공간 생성
		phoneBook = new PhoneInfo[size]; // 배열이름 = new PhoneInfo타입[배열의크기]
	}
	
	PhoneBookManager(){ // 매개 변수x, 생성자 오버로딩
		//phoneBook = new PhoneInfo[100];	// 배열의 저장공간을 100개 생성
		this(100);							// size : 100 으로 설정
	}
	
	
	// 메서드 정의 : 저장, 검색, 삭제, 출력
	
	// [정보 저장]
	// 사용자로부터 데이터를 받아서 -> 
	// 인스턴스를 생성 -> 
	// 배열에 생성된 인스턴스의 참조값을 저장	: 저장 index는 cnt를 이용 , 저장 후에는 cnt++
	void insertMember() { // 반환x void
		
		// 사용자의 데이터 입력
		System.out.println("친구의 정보의 입력을 시작합니다.");
		
		System.out.println("이름 : ");
		String name = Util.SC.nextLine();
		System.out.println("전화번호 : ");
		String pNum = Util.SC.nextLine();		
		System.out.println("생년월일 : ");
		String birthday = Util.SC.nextLine().trim(); // 공백문자열 빼기위해 trim()	
		
		// 배열에 저장하기 위한 인스턴스의 참조변수 선언
		PhoneInfo info = null; // 타입 참조변수 = 기본값;
		
		// 분기 : 생일이 입력되었는지 여부에 따라 인스턴스의 생성을 다르게 처리
		if(birthday != null && birthday.length()>0) {	// .isEmpty()
			info = new PhoneInfo(name, pNum, birthday);
		} else {
			info = new PhoneInfo(name, pNum);
		}
		
		// 인스턴스의 참조값을 저장
		phoneBook[cnt++] = info;	// phoneBook[0] = 0x111; 참조변수의 주소	 
		//cnt++;	// 추가된 정보의 개수를 +1, ++ 후위형
	}
	
	
	// [정보 검색]
	// 검색하고자 하는 이름을 사용자로부터 받는다 ->
	// 배열의 요소(참조 값 -> 인스턴스 참조) PhoneInfo.name 변수의 값과 검색 이름과 동등비교 시,
	// 해당 index를 찾을 수 있다. 
	// 검색된 index로 정보 출력
	void searchMember() {
		
		// 사용자의 입력 여부 확인
		if(cnt==0) {
			System.out.println("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
			return;	// 메서드 종료
		}
		
		// 검색할 이름 받기
		System.out.println("정보 검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력해주세요.");
		String name = Util.SC.nextLine();
		
		// 이름으로 index 찾기
		// index 찾는 메서드 void 밖에서 정의하고, index 선언
		// 이름으로 요소 index 검색(1)
		int index = searchIndex(name);
		
/*		// 이름으로 요소 index 검색(2)
		//int index = -1; // 검색이 안되는 경우 -> 분기** 	// 인덱스는 -1 값을 가질 수 없다. 		

		for(int i=0; i<cnt; i++) {
			// phoneBook[i].name = "park0";	// 직접참조
			if(phoneBook[i].name.equals(name)) {
				index=i;
				break;	// (배열 내 이름이 중복되지 않는다는 가정 하에)
			}
		}	
*/			
		// 검색 결과 출력
			if(index<0) {
				System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");	// 왜 출력 안되지???
			} else {
				phoneBook[index].showInfo();
			}
	}
	
	// index 찾는 메서드 정의
		// 이름 문자열을 받아서, 배열의 정보와 비교하고, index 를 찾아서 반환
	int searchIndex(String name) {
		int result = -1; 
			// index를 -1로 초기화하는 이유? 이름 검색이 안되는 경우도 생각. 못 찾으면 index는 -1이 되는데 그런 거 없음.
	
		// index 를 찾기 (반복)
		for(int i=0; i<cnt; i++) {
			if(phoneBook[i].name.equals(name)) { // i의 범위 : 0 ~ cnt-1
				result=i;
				break;	// (배열 내 이름이 중복되지 않는다는 가정 하에)
			}
		}	
		return result;
	}
	
	
	// [정보 삭제]
	// 삭제하고자 하는 이름을 사용자로부터 받기 -> 
	// 배열에서 이름으로 검색해서 index를 찾기 ->
	// 배열에서 찾은 index의 참조값을 삭제 -> 
	//  	*인스턴스는 참조하는 참조변수가 없으면 삭제 된다
	// 		방법1) 참조값에 null을 입력하기
	// 		방법2) 다른 주소값을 입력 => 이전에 있던 참조값은 없어진다
	// 		방법3) 삭제 대상의 index 부터 왼쪽으로 값을 시프트 처리 (한칸씩 이동하고 마지막 칸 no count)
	// cnt-1 : 정보 삭제하면서 정보의 개수도 차감하기
	void deleteMember() {

		if(cnt==0) {
			System.out.println("등록된 정보가 없습니다");
			return;
		}
		
		System.out.println("정보 삭제를 시작합니다.");
		System.out.println("삭제 하고자 하는 이름을 입력해주세요.");
		String name = Util.SC.nextLine();
		
		// 이름으로 index 찾기 (메서드 재활용)
		int index = searchIndex(name);
		
		// 정보 일치 여부 확인
		if(index<0) {
			System.out.println("삭제 하고자 하는 정보가 존재하지 않습니다.");
		} else {
			// 삭제 처리 : 삭제 해야하는 index부터 왼쪽으로 시프트 처리
			// index = 3;
			// phoneBook[3] = phoneBook[4]
			for(int i=index; i<cnt-1; i++) {
				phoneBook[i] = phoneBook[i+1];
			}
			cnt--;		
			
			System.out.println("정보를 삭제했습니다.");
		}	
	}
	
	
	// 전체 정보 출력
	void displayAll() {
		
		if(cnt==0) {
			System.out.println("등록된 정보가 없습니다");
			return;
		}
				
		System.out.println("전체 정보를 출력합니다. (" +cnt+ ")");
		System.out.println("-------------------------");
		
		// 배열에서 index 0~cnt-1에 해당하는 값 전부 보여주기 (반복문) 
		for(int i=0; i<cnt; i++) { 
			phoneBook[i].showInfo();
			System.out.println("-------------------------");
		}		
	}
	
	
}
