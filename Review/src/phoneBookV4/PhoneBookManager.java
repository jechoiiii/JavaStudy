package phoneBookV4;

import phoneBookV3.Util;

/*
	파일 이름 : phoneBookV4.PhoneBookManager.java
	내    용 : 전화번호 관리 프로그램 ver04
	수정 사항 : 1) 다음 두 클래스 PhoneUnivInfo, PhoneCompanyInfo와 CafePhoneInfo 추가로 삽입해 상속 구조로 구성
		 
							PhoneUnivInfor								PhoneCompaanyInfor
					이름			name			String			이름			name			String
					전화번호		phoneNumber		String			전화번호		phoneNumber		String
					주소			address			String			이메일		email			String
					이메일		email			String			회사			company			String
					전공			major			String
					학년			year			String
			  2) 입력 --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성
			  3) 변수 캡슐화 
			
	작성 일시 : 2020.10.19
*/	

public class PhoneBookManager extends Util {

	// Scanner 클래스 -> Util 클래스 상속으로 대체
	
	// 정보 저장을 위한 배열 선언 : 이름, 전화번호, 생일 저장
	PhoneInfo pBook[];	// PhoneInfo 타입의 배열 phoneBook
	int cnt;				// 배열의 크기 (요소의 개수)
	
	// 생성자를 이용한 배열 초기화
	PhoneBookManager(int cnt){
		// 배열 저장공간 생성 : 배열이름 = new 배열타입[배열의크기]
		pBook = new PhoneInfo[cnt];	
	}
	
	PhoneBookManager() {
		// 배열 저장공간의 크기 100으로 설정
		this(100);	
	}
	
	
	// 메서드 정의
	// 1. 정보 저장
	// 		사용자로부터 데이터 받기 -> 인스턴스 생성 -> 배열에 생성된 인스턴스의 참조값 저장
	void insertInfo() {
		
		// 사용자로부터 데이터 받기
		System.out.println("전화번호부 정보 입력을 시작합니다.");
		
		System.out.println("이름  >>> ");
		String name = SC.nextLine(); 
		
		System.out.println("전화번호  >>> ");
		String phoneNum = SC.nextLine();		
	
		System.out.println("생일  >>> ");
		String birthday = SC.nextLine().trim(); // 공백문자열 제외하기 위해 trim()

		// 인스턴스의 참조변수 선언 & 초기화
		PhoneInfo info = null;
		
		// 인스턴스 생성
		if( birthday!=null || birthday.length()!=0 ) { 
			info = new PhoneInfo(name, phoneNum, birthday);
		} else {
			info = new PhoneInfo(name, phoneNum);
		}	
		
		// 인스턴스의 참조값 저장
		pBook[cnt++] = info;	

	}

	
	// 2. 정보 검색
	// 		사용자로부터 이름 받기 -> pBook 배열 요소와 동등비교해 index 찾기 -> 해당 index로 정보 출력 
	void searchInfo() {
		
		// 데이터 저장 여부 조회 (불필요한 CPU 할당 방지 목적) 
		if(cnt==0) {
			System.out.println("저장된 정보가 없습니다.");
			return; // searchInfo() 메서드 종료
		}
		
		// 사용자로부터 이름 받기
		System.out.println("검색하고자 하는 이름을 입력해주세요.");
		System.out.println("이름 >>> ");
		String name = SC.nextLine();
		
		// searchIndex() 메서드로 index 찾기
		int index = searchIndex(name);
		
		// 검색결과 출력
		if(index<0) {
			System.out.println("검색하신 "+name+"의 정보가 존재하지 않습니다.");
		} else {
			pBook[index].showInfo();
		}
			
	}
	
	// index 찾는 메서드 : 이름 문자열 받아, 배열의 정보와 비교 후, 해당 index 반환 
	int searchIndex(String name) {
		int result = -1; // -1로 초기화하는 이유 : 입력받은 이름이 없을 경우 pBook[0]을 반환하는 것을 방지하기 위해 
		
		for(int i=0; i<cnt; i++) {
			if(pBook[i].name.equals(name)) {
				result=i;
				break;
			}
		}
		return result;
	}
	
	
	// 3. 정보 삭제 
	//		사용자로부터 이름 받기 -> 해당 index 다음의 배열 요소부터 -1씩 자리 이동 (shift 처리)  -> 배열 요소의 크기 -1 
	//		삭제 방법 : 1) null 값 입력, 2) 다른 주소값 입력, 3) 삭제 대상인 index부터 왼쪽으로 shift처리 
	void deleteInfo() {

		// 데이터 저장 여부 조회 (불필요한 CPU 할당 방지 목적) 
		if(cnt==0) {
			System.out.println("저장된 정보가 없습니다.");
			return; // searchInfo() 메서드 종료
		}
		
		// 사용자로부터 이름 받기
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");
		System.out.println("이름 >>> ");
		String name = SC.nextLine();		
		
		// searchIndex() 메서드로 index 찾기 
		int index = searchIndex(name);
		
		// 검색결과 삭제
		if(index<0) {
			System.out.println("검색하신 "+name+"의 정보가 존재하지 않아 삭제할 수 없습니다.");
		} else {
			// 삭제처리 : 삭제 대상인 index부터 왼쪽으로 shift처리 
			for(int i=index; i<cnt; i++) {
				pBook[i] = pBook[i+1];	// 한칸 뒤 값으로 변경 
			}
			cnt--;
			System.out.println("검색하신 "+name+"의 정보를 삭제했습니다.");
		}	
		
	}
	
	
	// 4. 전체 정보 출력
	void showAllInfo() {
		
		// 데이터 저장 여부 조회 (불필요한 CPU 할당 방지 목적) 
		if(cnt==0) {
			System.out.println("저장된 정보가 없습니다.");
			return; // searchInfo() 메서드 종료
		}
		
		System.out.println("전체 정보 ("+cnt+")개 출력-------------");
		for(int i=0; i<cnt; i++) {
			pBook[i].showInfo();
		}
		System.out.println("-----------------------------------");
	
	}
	
	
	
}
