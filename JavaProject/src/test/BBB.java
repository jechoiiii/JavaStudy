package test;

public class BBB {

	public static void main(String[] args) {
		
		AAA a = new AAA();	// public 클래스
							// AAA() 생성자가 private이면 같은 패키지여도 다른 클래스에선 invisible
		
		a.num = 10;			// private 변수
		
//		final class FinalTest {
//			final int MAX_SIZE = 10;	// 멤버변수
//			final void getMaxSize() {
//				final LV = MAX_SIZE;	// 지역변수
//				return MAX_SIZE;
//			}
//		}
//		class Child extends FinalTest {
//			void getMaxSize() {			// 오버라이딩
//				
//			}
//		}
		
		
	}

}
