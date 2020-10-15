package test;

public class AAA {
	
	// public AAA(){ // default 생성자 자동으로 들어가있음. 
	//}	
	
	//private int num;	// num 변수 자체는 외부에서 접근 불가
	int num;
	
	public static int n = 100;
	
	static AAA a = new AAA(); // 내부에서 자신의 인스턴스 생성
	
	AAA(){
		
	}
	// setter getter => 필드를 지키면서 외부에서 사용할 수 있도록 함
	// setter 메서드  : 매개값을 검증하고 유효한 값만 데이터로 저장
	public void setNum(int num) {
		this.num = num;	// 인스턴스변수 = 지역변수
	}
	
	// getter 메서드 : 필드값을 가공하여 외부로 전달
	public int getNum() {
		return num;
	}
	
	
	
	
	

}
