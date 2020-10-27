package test1;

import test.AAA; // AAA가 public이 아니면 다른 패키지에서 invisible

public class CCC {

//	AAA a = new AAA(); // public 클래스 + default 생성자 => 동일 패키지 내 인스턴스 생성만 허용
	
//	a.num = 10; // default 생성자는 같은 패키지 내에서만
				// test.BBB에선 visible, test1.CCC에선 invisible
	
	
	
	
}
