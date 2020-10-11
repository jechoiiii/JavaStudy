package card;

public class CardMain {
	
	static int weight = 5;
	// 클래스 변수를 만들어 놓으면 인스턴스 생성을 안해도 사용 가능
	// 사용 빈도가 더 높다.
	
	public static void main(String[] args) {
	// main메서드도 static -> 프로그램 내내 사용 가능한 공용 메서드 	
		
		System.out.println(Math.PI);	// 상수의 이름은 대문자
		
		System.out.println(Math.random());
		
		System.out.println(CardMain.weight);
		
		System.out.println("카드의 폭 사이즈: " + Card.width);
		
		
		Card.play();		// 인스턴스 생성 없이도 출력
		
		Card c1 = new Card("heart",10);
		Card c2 = new Card();
		
		
		System.out.println("=======================");
		System.out.println("카드 1의 정보");
		System.out.println("모양 : " + c1.kind + ", 숫자 : " + c1.number);
		
		System.out.println("카드 2의 정보");
		System.out.println("모양 : " + c2.kind + ", 숫자 : " + c2.number);
		
		
		
		c1.play();
		
		System.out.println("카드의 폭 사이즈: " + c1.width);
		System.out.println("카드의 폭 사이즈: " + c2.width);
		
		Card.width = 120;	// 공용변수의 개념으로 사용하면 됨. 
		
		System.out.println("카드의 폭 사이즈 변경");
		System.out.println("카드의 폭 사이즈: " + c1.width);
		System.out.println("카드의 폭 사이즈: " + c2.width);

	}

}
