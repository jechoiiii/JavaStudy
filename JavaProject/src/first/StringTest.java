package first;

public class StringTest {

	public static void main(String[] args) {
		
		// String 클래스의 특징
		
		String str1 = "My String";		// 주소값: 0x100
		String str2 = "My String";		// 0x100에 있는 주소값을 가져와 인스턴스를 새로 만들지 않는다. 
		String str3 = "Your String";
		String str4 = new String("My String");	// 같은 문자열이나 새 인스턴스 생성
		
		
		// 참조변수 값의 동등 비교 : 같은 인스턴스를 참조한다
		if(str1==str2) {
			System.out.println("같은 인스턴스를 참조");
		} else {
			System.out.println("다른 인스턴스를 참조");
		}	

		if(str1==str3) {
			System.out.println("같은 인스턴스를 참조");
		} else {
			System.out.println("다른 인스턴스를 참조");
		}
	
		if(str1==str4) {
			System.out.println("같은 인스턴스를 참조");
		} else {
			System.out.println("다른 인스턴스를 참조");
		}
		
		// 문자열의 내용 비교 
		System.out.println(str1.equals(str4));
		
		
		
	}

}
