package first;

public class ExceptionCase {

	public static void main(String[] args) {

		try {
			int[] arr = new int[3]; // index 0~2
			arr[10]=20;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		try {
			int[] arr = new int[-10];
		} catch(NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Object obj = new int[10];
			String str = (String)obj;	// 형변환 불가
		} catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String str = null;
			int len = str.length();	// null로 초기화된 참조변수. 메서드 호출
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("메서드가 종료됩니다.");
	}
	
}
