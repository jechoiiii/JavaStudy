package test;

public class AAA {
	
	// public AAA(){ }	// default 생성자 자동으로 들어가있음. 
	
	//private int num;
	int num;
	
	public static int n = 100;
	
	//static AAA a = new AAA(); // 내부에서 자신의 인스턴스 생성
	
	AAA(){
		
	}
	
	// setter 메서드 => private 변수를 외부에서 사용할 수 있도록 함
	public void setNum(int num) {
		this.num = num;	// 인스턴스변수 = 지역변수
	}
	
	// getter 메서드
	public int getNum() {
		return num;
	}
	
	
	
	
	

}
