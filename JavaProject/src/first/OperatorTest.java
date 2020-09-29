package first;

public class OperatorTest {

	public static void main(String[] args) {
		
		int num1 = 10; 
		int num2 = 8;
		
		System.out.println("10/8 = " + num1/num2);
		
		System.out.println("10/8 = " + num1%num2);
		
		System.out.println("10/8 = " + num1/-8);
		
		System.out.println("10/8 = " + num1%-8);
		
		System.out.println("10f/8f = " + 10f/8f);
		
		System.out.println("10f/8 = " + 10f/8);
		
		System.out.println("10/8 = " + num1/(float)num2);	// 변수 자체가 바뀌지는 않고, 데이터 타입만 바뀌어서 연산됨 
		
		
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println("'A' < 'B' => " + (c1 < c2));	// 비교 연산은 후순이기에 괄호쳐줘야 함
		System.out.println("'0' == 0 => " + ('0' == 0));	// 48 == 0
		
		System.out.println("10.0d == 10.0f => " + (10.0d == 10.0f));
		
		
		
		

	}

}
