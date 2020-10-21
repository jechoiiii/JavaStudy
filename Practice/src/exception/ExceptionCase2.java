package exception;

public class ExceptionCase2 {

	public static void main(String[] args) {

		// 배열의 접근에 잘못된 인덱스 값을 사용하는 예외상황
		// 배열선언 과정에서 배열의 크기를 음수로 지정하는 예외상황
		// 허용할 수 없는 형변환 연산을 진행하는 예외상황
		// 참조변수가 null로 초기화된 상황에서 메서드를 호출하는 예외상황

		// 예외처리 대상과 예외처리의 분리 
		// 하나의 try 블럭에 둘 이상의 catch 블럭 구성 가능
			
		try {
			
			int[] arr = new int[3]; // index 0~2
			arr[6]=0;
			
			arr = new int[-10];			
			
			Object obj = new int[10];
			String str = (String)obj;	// 형변환 불가 why??
			
			str = null;
			int len = str.length();

	
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		} catch(NegativeArraySizeException e) {
//			System.out.println(e.getMessage());
//		} catch (ClassCastException e) {
//			System.out.println(e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println(e.getMessage());
			
		} catch (Exception e) {		// 가장 넓은 범위의 catch문은 가장 하단에 
									// 단독으로 사용해도 OK

		}

		System.out.println("메서드 종료");
	}

}
