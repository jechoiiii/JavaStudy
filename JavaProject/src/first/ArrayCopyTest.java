package first;

/*
		파일 이름 : ArrayTest2.java
		내용 : 배열의 복사 필기
		작성 일자 : 2020.10.13
*/

public class ArrayCopyTest {

	public static void main(String[] args) {
	
		// 사용할 원본 배열 생성
		char[] abc = {'A', 'B', 'C', 'D'};
		char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		System.out.println(abc);
		System.out.println(new String(number));
		
		// abc 배열과 number 배열을 연결해서 사용할 배열 생성
		char[] result = new char[abc.length + number.length];
		
		// 배열의 복사
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.out.println(result);	// [실행 결과] ABCD"          " -> 비어있는 배열 자리엔 공백문자 들어있음
		System.arraycopy(number, 0, result, abc.length, number.length);
		System.out.println(result);
		
		// abc를 number에 0 index부터 복사
		System.arraycopy(abc, 0, number, 0, abc.length);
		System.out.println("number : " + new String(number));
		
		// number index=6부터 abc index=0 3개를 복사
		System.arraycopy(abc, 0, number, 6, 3);
		System.out.println("number : " + new String(number));
		
		
		
		
		
		
		
		
	}

}
