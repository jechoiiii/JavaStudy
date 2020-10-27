package test;

public class AAA {
	
	// public AAA(){	// 자동으로 default 생성자 
	// }
	
	//private int num; // num 변수 자체는 외부에서 접근 불가
	int num;
	
	AAA a = new AAA(); // 내부에서 자신의 인스턴스 생성
	
	AAA(){		// public 클래스 + default 생성자 => 동일 패키지 내 인스턴스 생성만 허용
		
	}
	
	
	// setter 메서드 : 메서드로 매개값을 검증하고 유효한 값만 데이터로 저장
	public void setNum(int num) {	
		this.num = num;	// 인스턴스 변수 = 지역변수
	}
	
	// getter 메서드 : 메서드로 필드값을 가공하여 외부로 전달
	public int getNum() {
		return num;
	}
	
	
	
	

}
