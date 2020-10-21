package exception;

public class ExceptionCase {

	public static void main(String[] args) {

		// 배열의 접근에 잘못된 인덱스 값을 사용하는 예외상황
		try {
			int[] arr = new int[3]; // index 0~2
			arr[6]=0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		// 배열선언 과정에서 배열의 크기를 음수로 지정하는 예외상황
		try {
			int[] arr = new int[-10];
		} catch(NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}
		
		// 허용할 수 없는 형변환 연산을 진행하는 예외상황
		try {
			Object obj = new int[10];
			String str = (String)obj;	// 형변환 불가 why??
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
		// 참조변수가 null로 초기화된 상황에서 메서드를 호출하는 예외상황
		try {
			String str = null;
			int len = str.length();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("메서드 종료");

	}

}
