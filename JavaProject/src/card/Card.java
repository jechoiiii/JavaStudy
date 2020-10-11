package card;

public class Card {

	String kind;		// 카드의 종류
	int number;			// 카드의 숫자
	
	Card(String kind, int number){
		this.kind = kind;	// 지역 변수를 가장 우선시 함. 
		this.number = number;
	}
	
	Card(){
		// this는 다른 생성자를 호출한다. -> 오버로딩 되어 있음 
		this("spade", 1);
	}
	
	
	// 클래스 변수 선언
	// 시작 할 때 딱 한번 생성된다.
	// 클래스 변수는 Card 클래스 안에 있지만 클래스에 종속적이지 않다. 인스턴스와 완전 독립적이다. 
	static int width = 100;		// 카드의 폭   -> static 변수는 공통적으로 쓰이니까 보통 데이터도 변하지 않는다.
	static int height = 250;	// 카드의 높이
	
	static void play() {	// 어디서 사용 가
		System.out.println("카드놀이를 합니다.");
	}
	
}
