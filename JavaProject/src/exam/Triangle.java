package exam;

public class Triangle {

	// 변수 : 밑변, 높이
	float width;		// 삼각형의 밑변
	float height;		// 삼각형의 높이
	
	
	// 매서드 : 변수의 값을 변경하는 메서드, 삼각형의 넓이를 구하고 반환하는 메서드
	// 변수의 값을 변경하는 메서드
	void setData(float w, float h) {	// 매개변수값 받아야 함 
		width = w;
		height = h;
	}
	
	// 삼각형의 넓이를 구하고 반환하는 메서드 : 밑변*높이/2(f)(int로 선언 시) => 결과는 실수 타입으로
	float area() {						// 매개변수는 따로 받아오지 않았기에 비워 둠 
		float result = 0.0f;
		result = width * height / 2; 
		return result;
		// return width * height /2; 
	}
	
	
	public static void main(String[] args) {
		
		Triangle t = new Triangle();		// 상단의 변수, 메서드가 메모리에 저장됨
		
		// 밑변과 높이 값을 설정
		t.setData(10, 3);			// -> setData: float w = 10 -> 10.0, float h = 3 -> 3.0 
		
		// 넓이를 구하고 변수를 담는다 
		float result = t.area();	// @메모리: width(10.0), height(3.0), setData(), area(15.0)
		
		System.out.println(result);

	}

	
}
