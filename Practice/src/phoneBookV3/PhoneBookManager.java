package phoneBookV3;

import java.util.Scanner;

/*
	파일 이름 : ver03.java
	내용 : 배열 사용한 메서드 추가
	작성 일시 : 2020.10.14
*/

public class PhoneBookManager {

/*		
	Project : ver 0.30 
	
	배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 아래기능 삽입 
	
	저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장  	
			//	인스턴스 생성 -> 배열에 추가
	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력 
			//	참조변수 직접 비교 equals(), or 배열의 index 찾아 출력
	삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제 
			//	참조변수의 주소값을 null로 초기화, or 다른 주소를 대입, or shift 처리

	데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로 재정리. 
	2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장. 		
*/		 

	// 배열의 정의
	// 배열 : 전화번호 정보 (이름, 전화번호, 생일)를 저장
	PhoneInfo[] phoneBook;	// 정보 저장을 위한 배열 선언 // PhoneInfo타입 [] 배열의 이름;
	int cnt; // 저장된 정보의 개수 
	
//	Scanner sc = new Scanner(System.in);
	
	// 배열 초기화 - 생성자
	PhoneBookManager(int size){	// 생성자는 클래스 이름과 동일, int 타입의 
		// 배열의 저장공간을 생성
		phoneBook = new PhoneInfo[size];	// 배열이름 = new PhoneInfo타입[배열의크기]
	}
	PhoneBookManager() {	// 매개 변수x, 생성자 오버로딩
		// 배열의 저장공간을 100으로 설정
		this(100);
	}
	
	// 메서드 정의 : 저장, 검색, 삭제, 보기

	// 1. 정보 저장
	// 사용자로부터 데이터 받아서
	// 인스턴스를 생성
	// 배열에 생성된 인스턴스의 참조값을 저장
	void insertMember() {	// 반환x void
		
		// 사용자의 데이터 입력
		System.out.println("친구의 정보의 입력을 시작합니다.");
		
		System.out.println("이름 : ");
		String name = Util.sc.nextLine();
		System.out.println("전화번호 : ");
		String pNum = Util.sc.nextLine();		
		System.out.println("생년월일 : ");
		String birthday = Util.sc.nextLine().trim();	// 공백문자열 빼기위해 trim()
		
		// 배열에 저장하기 위한 인스턴스의 참조변수 선언
		PhoneInfo info = null;	// 타입 참조변수 = 기본값;
		
		// 인스턴스 생성 - 분기
		if(birthday != null && birthday.length()>0) {
			info = new PhoneInfo(name, pNum, birthday);
		} else {
			info = new PhoneInfo(name, pNum);
		}
		
		// 인스턴스의 참조값을 저장
		phoneBook[cnt] = info;	// 배열[인덱스] = 참조변수;
		cnt++;
	}
	
	
	// 2. 정보 검색
	// 검색하고 싶은 이름을 사용자로부터 받기
	// PhoneInfo.name 변수의 값과 검색 이름과 동등비교
	// 해당 index 찾는다
	// 찾은 index로 정보 출력
	void searchMember() {
		
		// 사용자의 입력 여부 확인
		if(cnt==0) {
			System.out.println("저장된 데이터 없음");
			return;	// 메서드 종료
		}
		
		// 검색할 이름 받기
		System.out.println("검색할 이름?");
		String name = Util.sc.nextLine();	// Scanner 입력: 타입 변수이름 = 다음줄에 쓰쇼 메서드
		
		// 이름으로 index 찾기
		// index 찾는 메서드 void 밖에서 정의하고, index 선언		
		int index = searchIndex(name); // 이 index는 name 값에 해당하는 index를 찾아주는 메서드. 		
		
		// 검색 결과 출력
		if(index<0) {
			System.out.println("그런거없음");
		} else {
			phoneBook[index].showInfo(); // 그 index에 해당하는 배열의 정보 보여주는 메서드 실행
		}
	}
	
	// index 찾는 메서드 정의: 이름 문자열 받아서, 배열의 정보와 비교하고, index 찾아서 반환
	int searchIndex(String name) {	// 메서드타입 메서드이름(변수타입 변수이름)
		int result = -1;		// index를 -1로 초기화 왜? -> 이름 검색이 안되는 경우도 생각. 못 찾으면 index는 -1이 되는데 그런 거 없음.

		// index 찾기 - 반복돌려
		for(int i=0; i<cnt; i++) {	// i의 범위 : 0 ~ cnt-1
			if(phoneBook[i].name.equals(name)) {
				result = i;
				break;
			}
		}
		return result;
	}

	
	// 3. 정보 삭제
	// 삭제하고 싶은 이름 받기
	// 배열에서 이름으로 검색해서 index 찾기
	// index의 참조값 삭제하기 how?
	// 방법1)참조값에 null 입력하기, 방법2)다른 주소값 입력
	// 방법3) 삭제 대상의 index부터 왼쪽으로 값을 시프트 처리하기 (한칸씩 이동하고 마지막 칸 no count)
	// cnt-1 : 정보 삭제하면서 정보의 개수도 차감하기
	void deleteMember() {
		
		// 삭제하고자 하는 정보 입력 여부 확인
		if(cnt==0) {
			System.out.println("정보 안적음");
			return;
		}
		// 이름 입력받기
		System.out.println("삭제 원하는 이름?");
		String name = Util.sc.nextLine();
		
		// 이름으로 index 찾기 (메서드 재활용)
		int index = searchIndex(name);
	
		// 정보 일치 여부 확인
		if(index<0) {
			System.out.println("그런거 없음");
		} else {
			// 삭제 처리 : 삭제 대상 index부터 왼쪽으로 시프트 처리
			for(int i=index; i<cnt; i++) {
				phoneBook[i] = phoneBook[i+1];	// 한칸 뒤의 값으로 변경
			}
			cnt--;
			
			System.out.println("삭제완료");
		}
	}
	
	// 4. 정보 전체 보기 
	void displayAll() {
		
		// 정보 있는지 확인
		if(cnt==0) {
			System.out.println("정보 없음");
		}
		
		System.out.println("전체 정보 ("+cnt+")개 출력");
		
		for(int i=0; i<cnt; i++) {	// 배열에서 index 0~cnt-1에 해당하는 값 전부 결과 보여주기
			phoneBook[i].showInfo();
		}		
	}
	
	
	
	
	
	
	
}
