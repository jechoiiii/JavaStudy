package exam;

/*
	파일 이름 : ExamString.java
	내용 : 자바의 정석 String 문제 풀이
	작성 일자 : 2020.10.13
 */

public class ExamString {

	public static void main(String[] args) {
			
/*
	 	문제 1. 다음 형태로 String 인스턴스를 생성.
	 	String str = “ABCDEFGHIJKLMN”;
		그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.
 */
		String str = "ABCDEFGHIJKLMN";
		int numOfStr = str.length();
		int index = numOfStr-1;		// 배열이나 문자열의 위치 index는 0~N-1
		
		String result = "";
		StringBuffer sb = new StringBuffer(); 
			// StringBuffer는 새로운 인스턴스 생성 없이 기존의 String을 수정할 수 있다. (넣을 공간을 만들어준다)  
		
		// (1) String 클래스의 charAt() 메서드를 이용해서  역순으로 출력
		for(int i=index; i>=0; i--) {
			// result += str.charAt(i);	// result = result + String => 계속 새로운 인스턴스를 생성해 메모리 소모
			sb.append(str.charAt(i));	// 
		}
		
		System.out.println(str);
		System.out.println(new String(sb));
		System.out.println("==============================");

		
		// (2) StringBuffer reverse() 메서드 이용
		// sb = new StringBuffer(str).reverse;
		sb = new StringBuffer(str);		// "ABCDEFGHIJKLMN"	
		// sb = sb.reverse();
		System.out.println(sb.reverse());
		
		
	/*
		문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
		String str = “990929-1010123”
		이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.	
	 */	
		str = "990929-1010123";
		sb = new StringBuffer();	// 16개 문자 저장
		
		// (1) String charAt()
		for(int i=0; i<str.length(); i++) {
			// '-' 가 아닌 경우, '0'~'9'일때 문자열을 추가
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				sb.append(c);
			}
		}
		System.out.println(sb);
		
		// (2) String replace() => 새로운 문자열 반환
		result = str.replace("-", "");
		System.out.println(result);
		
		// (3) StringBuffer deleteCharAT() => 기존 문자열 수정
		sb = new StringBuffer(str);
		System.out.println(sb.deleteCharAt(6));
		
	
	
	
	}
	
	
}
