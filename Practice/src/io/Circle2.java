package io;

import java.awt.Point;
import java.io.Serializable;

public class Circle2 implements Serializable {

	// implements Serializable : 직렬화의 대상이다, 인스턴스 저장이 가능하다. 
	// 직렬화 하기 위해선 반드시 implements Serialiable 해야함. 
	
	// transient : 직렬화 대상에서 제외
	Point p;
	double rad;
	
	public Circle2(int xPos, int yPos, double rad) {
		p = new Point(xPos, yPos);
		this.rad=rad;
	}
	
	public void showInfo() {
		System.out.printf("[%d,%d] \n", p.x, p.y);
		System.out.println("rad : "+ rad);
	}
	
	
}
