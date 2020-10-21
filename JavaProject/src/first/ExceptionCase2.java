package first;

public class ExceptionCase2 {

	public static void main(String[] args) {

		try {
			int[] arr = new int[3]; // index 0~2
			// arr[10]=20;
			
			//arr = new int[-10];
			
			Object obj = new int[10];
			//String str = (String)obj;	// 형변환 불가
			
			String str1 = null;
			int len = str1.length();	// null로 초기화된 참조변수. 메서드 호출
			
			
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		} catch(NegativeArraySizeException e) {
//			System.out.println(e.getMessage());
//		} catch(ClassCastException e) {
//			System.out.println(e.getMessage());
//		} catch(NullPointerException e) {
//			System.out.println(e.getMessage());
		} catch(Exception e) {	// 가장 넓은 범위의 catch문을 가장 마지막에. 		
		}						// Exception만 단독으로 사용해도 OK. 
		
		System.out.println("메서드가 종료됩니다.");
		
	}
}
