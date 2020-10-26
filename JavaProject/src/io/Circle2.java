package io;

import java.io.Serializable;

public class Circle2 implements Serializable {
	
	// implements Serializable : 직렬화의 대상이다, 인스턴스 저장이 가능하다. 
	// 직렬화를 하기 위해서는 반드시 implements Serializable 을 해줘야 한다. 
	
	// 직렬화 생략
	// transient : 직렬화 대상에서 제외 
	// transient Point p; => null (인스턴스화는 되지만 파일에 저장되지는 않는다)
	Point p;	// 참조변수 p로 설정. p를 저장하고 있지는 않음.
	double rad;
	
	public Circle2(int xPos, int yPos, double rad) {
		p = new Point(xPos, yPos);
		this.rad = rad;
	}
	
	public void showCircleinfo() {
		System.out.printf("[%d,%d] \n", p.x, p.y);
		System.out.println("rad : "+ rad);
	}
	
	
	
}
