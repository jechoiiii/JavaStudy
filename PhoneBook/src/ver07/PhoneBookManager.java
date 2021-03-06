package ver07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JOptionPane;

import ver03.Util;

public class PhoneBookManager implements Util, Menu {

	// 전화번호 정보를 저장할 배열을 가지고,
	// 배열을 이용한 정보의 저장, 검색, 삭제, 출력을 하는 기능
	
	// 배열 선언 : 상속 관계이기 때문에 PhoneInfo 타입으로 선언
	// private PhoneInfo[] pBook;	// 전화번호 정보를 저장할 배열
	// private int cnt;				// 배열에 저장된 요소의 개수, 배열의 index

	// 배열을 이용해서 저장하는 방식을 ArrayList<T> 컬렉션을 이용해 구현	
	List<PhoneInfo> pBook;
	
	// 생성자 : 싱글톤 처리 -> 외부에서 인스턴스 생성을 금지
	private PhoneBookManager(int num){
		// pBook = new PhoneInfo[num];		// 생성자의 매개변수의 인자를 전달 받아 배열 생성
		// cnt = 0;
		// List<PhoneInfo> 초기화
		pBook = new ArrayList<PhoneInfo>();
		// 2020.10.27 수정 : 파일에서 인스턴스들을 로드
		load();
	}
	
	// 내부에서 인스턴스 생성
	private static PhoneBookManager manager = new PhoneBookManager(100);
		// 왜 static? static이 아니면 변수 자체가 만들어지지 않는다. 
	
	// 외부에서 참조변수를 받을 수 있는 메서드
	public static PhoneBookManager getInstance() {
		return manager;
	}
	
	
	// 정보 저장 기능
	// 	 1. 배열에 저장 메서드 : 다형성을 이용해서 하나의 메서드로 정의  addInfo(상위클래스타입의 매개변수)
	//   2. 사용자에게 받은 데이터를 인스턴스 생성 메서드
	//		입력의 구분 -> 구분에 따라 인스턴스 생성도 구분 -> addInfo() 메서드를 이용해서 정보 저장
	
	// 배열에 전화번호 정보를 저장하는 메서드
	
	
	private void addInfo(PhoneInfo info) {
		// pBook[cnt++] = info;
		
		// List에 정보 저장
		pBook.add(info);
	} 

	// 전화번호 정보를 인스턴스 생성하고 배열에 저장
	public void insertInfo() throws WrongMenuException {

		// 100개 입력	0<=index<=99, cnt=100
		// pBook[100] -> 오류
		// 배열의 개수와 입력된 요소의 개수를 비교
//		if(pBook.length==cnt) {
//			System.out.println("더이상 정보를 저장할 수 없습니다.");
//			System.out.println("일부 정보를 삭제하고 저장 공간을 확보해주세요.");		
//		}

		int select = 0;		
		
		while(true) {
			System.out.println("어떤 정보를 입력하겠습니까");
			// System.out.println(" 1. 기본"); // 추상클래스 -> 인스턴스 생성 불가
			System.out.println(UNIV +" . 대학");
			System.out.println(COM +" . 회사");
			System.out.println(CAFE +" . 동호회");
			
// 2020.10.23 수정 : 사용자 정보 입력 시 예외 처리 

			try {
				select = SC.nextInt();	
				
				// List는 저장공간이 부족하면 저장공간을 확장 
	//			if(pBook.length==cnt) {
	//			ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException();
	//			throw e;
	//			}			
				
				if( !(select>=0 && select<=3) ) {
				BadInputException mie = new BadInputException(String.valueOf(select));
				throw mie;
				}
				
			} catch(InputMismatchException | BadInputException e) {
				System.out.println("잘못된 입력입니다. 메뉴 번호를 입력해주세요.");
				SC.nextLine();	
				continue;
	//		} catch(ArrayIndexOutOfBoundsException e) {
	//			System.out.println("더이상 정보를 저장할 수 없습니다.");
	//			System.out.println("일부 정보를 삭제하고 저장 공간을 확보해주세요.");			
//			} catch(WrongMenuException e) {
//				System.out.println("메뉴 선택이 올바르지 않습니다. 다시 선택해주세요.");
//				SC.nextLine();		// nextInt() 에서 사용자가 입력한 숫자 뒤 공백을 입력으로 인식해서 넘어감. 
//										// 역할 : 숫자 뒤 공백을 반환. -> 호출할게 없으니 넘어감. 	
			}
			break;	// 예외 없을 시 while문 break
			
		}
		
		SC.nextLine();
		System.out.println("정보 입력을 시작합니다.");
		System.out.println("이름 >> ");
		String name = SC.nextLine();
		System.out.println("전화번호 >> ");
		String phoneNum = SC.nextLine();
		System.out.println("주소 >> ");
		String addr = SC.nextLine();
		System.out.println("이메일 >> ");
		String email = SC.nextLine();
		
		switch(select) {
//			case 1 :
//				// 인스턴스 생성 -> 배열에 저장
//				addInfo(new PhoneInfo(name, phoneNum, addr, email));
//				break;
				
			case Menu.UNIV :
				// 추가 정보  받고 -> 인스턴스 생성 -> 배열에 저장
				// 전공, 학년
				System.out.println("전공 >> ");
				String major = SC.nextLine();
				System.out.println("학년 >> ");
				int grade = SC.nextInt();
				
				addInfo(new UnivPhoneInfo(name, phoneNum, addr, email, major, grade));
				break;
				
			case Menu.COM :
				// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
				// 회사 이름
				System.out.println("회사 이름 >> ");
				String company = SC.nextLine();
				
				addInfo(new CompanyPhoneInfo(name, phoneNum, addr, email, company));
				break;
				
			case Menu.CAFE :
				// 추가 정보 받고 -> 인스턴스 생성 -> 배열에 저장
				// 동호회 이름, 닉네임
				System.out.println("동호회 이름 >> ");
				String cafeName = SC.nextLine();
				System.out.println("닉네임 >> ");
				String nickName = SC.nextLine();
				
				addInfo(new CafePhoneInfo(name, phoneNum, addr, email, cafeName, nickName));
				break;
		}
		System.out.println("입력하신 정보가 저장되었습니다. (저장 개수 : " +pBook.size() +")");
	}
	
	
	
	// 정보 검색 기능
		// 배열의 index를 찾는 메서드
		// 해당 index의 참조변수로 정보 출력
	
	// 배열의 index를 찾는 메서드
	// List의 index 찾기
	private int searchIndex(String name) {
		int index = -1;	// 찾는 정보가 없을 때
				
		for(int i=0; i<pBook.size(); i++) {
			// 이름으로 비교
			if(pBook.get(i).getName().equals(name)) {	// pBook.get(i) List의 요소 참조
				index = i;
			}
		}
		return index;
	}
	
// 2020.10.23 수정 : 저장된 정보가 없을 시 예외 처리	
	
	// 해당 index의 참조변수로 정보 출력 : 사용자가 입력한 이름으로 검색
	public void searchInfo() throws NoInputException {	// ?? ()참조변수에 int index 안쓰는 이유
		
		try {
			if(pBook.size()==0) {	// CPU 할당되지 않도록
				NoInputException nie = new NoInputException();
				throw nie;
			}
		} catch (NoInputException nie) {
			System.out.println("저장되어있는 정보가 없습니다.");
			return;	// 프로그램 종료			
		}

// 2020.10.22 수정 : 예외처리
		SC.hasNextLine();
			System.out.println("검색하실 이름을 입력해주세요.");
			String name = SC.nextLine();			

		try {
			int index = searchIndex(name);
		} catch (NegativeArraySizeException e) {
			System.out.println("검색하신 이름의 정보가 존재하지 않습니다.");
			System.out.println("메뉴로 돌아갑니다.");			
		}
	}		
//			if(index<0) {
//				System.out.println("검색하신 이름 "+name+"의 정보가 존재하지 않습니다.");
//				System.out.println("메뉴로 돌아갑니다.");
//			} else {
//				System.out.println("검색 결과 ===============");
//				pBook[index].showInfo();
//			}


	// 정보 삭제 기능
		// 사용자에게 이름을 입력 받고 이름으로 검색한 후 정보 삭제
	public void deleteInfo() {
		
		try {
			if(pBook.size()==0) {	// CPU 할당되지 않도록
				NoInputException nie = new NoInputException();
				throw nie;
			}
		} catch (NoInputException nie) {
			System.out.println("저장되어있는 정보가 없어 삭제할 수 없습니다.");
			SC.nextLine();	
			return;	// 프로그램 종료			
		}
		
		System.out.println("삭제하실 이름을 입력해주세요.");
		String name = SC.nextLine();
		int index = searchIndex(name);	
		
		// List의 요소 삭제는 인덱스의 시프트로 이루어진다.
//		try {
//			
//			// 배열의 요소를 왼쪽으로 시프트	
//			for(int i=index; i<cnt-1; i++) {
//				pBook[i] = pBook[i+1];
//			
//			}
//			cnt--;	// 저장된 개수를 감소 *배열의 요소 개수 중 하나를 없애야 한다.			
//		} catch(NegativeArraySizeException e) {
//			System.out.println("검색하신 이름의 정보가 존재하지 않습니다.");
//			System.out.println("메뉴로 돌아갑니다.");		
//		}
		pBook.remove(index);
		System.out.println("요청하신 정보를 삭제했습니다.");
	}	
	
//		if(index<0) {
//			IndexInputException iie = new IndexInputException(index);
//			System.out.println("검색하신 이름 "+name+"의 정보가 존재하지 않습니다.");
//			System.out.println("메뉴로 돌아갑니다.");				
//			throw iie;
//		}
//		if(index<0) {
//			System.out.println("찾으시는 이름" +name+ "의 정보가 존재하지 않습니다.");
//			System.out.println("메뉴로 이동합니다.");
//		} 
//		if(index>=0) {
//			// 배열의 요소를 왼쪽으로 시프트
//				// 참조값이 없는 인스턴스는 자바에서 삭제한다.
//			for(int i=index; i<cnt-1; i++) {
//				pBook[i] = pBook[i+1];
//			}
//			cnt--;	// 저장된 개수를 감소 *배열의 요소 개수 중 하나를 없애야 한다.
//			System.out.println("요청하신 정보를 삭제했습니다.");
//		}


	// 전체 정보 출력 기능
	public void showAllInfo() {
		
		if(pBook.size()==0) {	// CPU 할당되지 않도록
			System.out.println("입력된 정보가 없습니다.");
			return;	// 프로그램 종료
		}
		
		System.out.println("전체 정보를 출력합니다.================");
		for(int i=0; i<pBook.size(); i++) {
			pBook.get(i).showInfo();
			System.out.println("--------------------");
		}
	}
	
	
	
	// 2020.10.27 수정 : 직렬화를 통해 데이터 파일에 저장
	// List : pBook에 저장되어 있는 인스턴스들을 저장 
	public void saveAllInfo() {
		
		if(pBook.size()==0) {
			System.out.println("저장된 데이터가 없어 파일의 저장이 되지 않습니다.");
			return;
		}
		
		// 인스턴스를 저장할 수 있는 출력 스트림 생성
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.ser"));
//			for(PhoneInfo pi : pBook) { // 일괄참조 위해 for문 대신 for each구문
//				out.writeObject(pi);
//			}
			// 반복문으로 일일히 저장하지 않고 통채로 저장
			out.writeObject(pBook);
			out.close();
			System.out.println("저장이 완료되었습니다.(phonebook.ser)");
		} catch (IOException e) {
			System.out.println("저장하는 과정에서 오류가 발생했습니다.("+e.getMessage()+") \n다시 시도해주세요.");
		}	
	}
	
	
	// 2020.10.27 수정 : 프로그램으로 파일의 저장 데이터를 로드
	void load() {
		// 파일의 존재여부 확인 : File 
		File file = new File("phonebook.ser");
		if(!(file.exists())) {
			System.out.println("저장된 파일이 존재하지 않습니다. 파일 저장 후 Load됩니다.");
			return;
		}
		
		// 파일에 있는 데이터를 메모리에 저장 : pBook에 저장
		// 파일의 데이터를 읽을 수 있는 스트림 생성
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("phonebook.ser"));
//			while(true) {
//				Object obj = in.readObject();
//				if(obj==null) {
//					break; // while문 break
//				}
//				pBook.add((PhoneInfo)obj);
//			}
			pBook = (List<PhoneInfo>)in.readObject();	// List<PhoneInfo> 타입으로 형변환
			System.out.println("데이터 로드를 완료했습니다.");
		} catch (IOException e) {
//			System.out.println("데이터를 로드하는 과정에 오류가 발생했습니다.");
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("데이터를 로드하는 과정에 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
