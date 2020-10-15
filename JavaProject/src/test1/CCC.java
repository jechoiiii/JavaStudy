package test1;

import test.AAA; // AAA가 public이 아니면 다른 패키지에서 invisible

public class CCC {

	public static void main(String[] args) {
		
//		AAA.n = 0; // n 변수를 public 하면  생성자는 invisible이어도  변수는 visible 
//		
//		AAA a = new AAA();	// 다른 패키지기 때문에 import 필요
//							// AAA() 생성자가 public이 아니면 invisible
//
//		a.num = 10; // default는 같은 패키지까지만. test.BBB에는 visible, test1.CCC에선 invisible

	}

}
