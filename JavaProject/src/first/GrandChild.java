package first;

public class GrandChild extends Child2 {

	GrandChild(String name){
		// 조상 클래스의 생성자 호출 : super(매개변수)
		// 생성자는 상속하지 않는다. 
		super(name); 
	}
	
	
}
