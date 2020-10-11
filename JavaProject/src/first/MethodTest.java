package first;

public class MethodTest {

	public static void main(String[] args) {

		MyMeth my = new MyMeth(); // 	인스턴스 생성 : MyMeth 메서드가 메모리에 올라감
		
	
		System.out.println(my.add(1, 5));	// add 메서드 호출
		
		my.sayHello();		// sayHello 메서드 호출

		my.plus(10, 20);	// 10, 20 : 매개변수의 인자(값)
		
		System.out.println(my.check()); 	// check 메서드 호출
		
		hiEveryone();
		
		my.div(10, 2);
		my.div(10, 0);	//	-> 0으로 나누면 오
		
		System.out.println(true);
	
	}

	static void hiEveryone() { // MethodTest 클래스가 가지는 멤버
		System.out.println("안녕하세요~"); 
	}

}
