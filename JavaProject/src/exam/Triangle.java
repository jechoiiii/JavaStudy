package exam;

public class Triangle {

	// 변수 : 밑변, 높이
	float width;		// 삼각형의 밑변
	float height;		// 삼각형의 높이
	
	
	// 매서드 : 변수의 값을 변경하는 메서드, 삼각형의 넓이를 구하고 반환하는 메서드
	// 변수의 값을 변경하는 메서드
	void setData(float w, float h) {
		width = w;
		height = h;
	}
	
	// 삼각형의 넓이를 구하고 반환하는 메서드 : 밑변 * 높이 /2(f - 변수를 int로 선언했다면) => 결과는 실수 타입으로
	float area() {				// 매개변수는 따로 받아오지 않으니 비워둔다
		float result = 0.0f; 	// 초기화
		result = width * height / 2; 
		return result;
//		return width * height /2;    <- 훨씬 간단한 코드이나 지금은 연습하기 위해 전 과정 거칠 것!
	}
	
	
	public static void main(String[] args) {
		
		Triangle t = new Triangle();		// 상단의 변수, 메서드 메모리에 저장됨
		
		// 밑변과 높이 값을 설정
		t.setData(10, 3);					// API(외부 매서드)를 활용할 때 자동완성에서 어떤 변수 타입인지 확인
		// -> setData: float w = 10 -> 10.0, float h = 3 -> 3.0 
		
		float result = t.area();
		// @메모리 : width (10.0), height (3.0), setData (), area(15.0)
		
		System.out.println(result);
		
		t.setData(5, 1);	
		float result1 = t.area();
		System.out.println(result1);
	}
	
	
	
	// 정은 Version: 나(객체)는 삼각형의 밑변과 높이(데이터)로 삼각형의 넓이(객체)를 구했다(행위).
	// 변수 : 밑변, 높이

	// 매서드 : 변수의 값을 변경하는 메서드, 삼각형의 넓이를 구하는 메서드

	// 변수의 값을 변경하는 메서드
	/*
	 * 변수 정의 클래스 정의
	 */

	// 인스턴스 변수 선언

/*	int w = 0; // 삼각형의 밑변
	int h = 0; // 삼각형의 높이

	// 클래스 정의
	int wtriangle (int w) {
			int num = 0;
			num = w;
			num +=;
			return w; 
		}
*/
	
}
