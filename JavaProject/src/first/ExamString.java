package first;

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
	// 인스턴스 생성
	String str = "ABCDEFGHIJKLMN";
	String result = "";
	
	for(int i=str.length()-1; i>=0; i--) {
		result += str.charAt(i);	
	}	
	System.out.println(result);
	

/*
	문제 2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
	String str = “990929-1010123”
	이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.	
 */	
	// 인스턴스 생성
	str = "990929-1010123";
	result = "";
	
	for(int i=0; i<str.length(); i++) {
		
	}
	
	
	
	
	}
	
	
}
