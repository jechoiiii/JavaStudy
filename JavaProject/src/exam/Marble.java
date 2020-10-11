package exam;

public class Marble {
	
	/* 	어린아이가 소유하고 있는 구슬의 개수 정보를 담을 수 있다. 
		놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재. 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미.
		조건을 만족하는 클래스를 정의하였다면, 다음 조건을 만족하는 인스턴스를 각각 생성할 것. (하나의 클래스만 작성)
	*/

	// 변수 선언
	int numOfMarble; 	// 소유하는 구슬의 개수
	String name; 		// 어린아이 이름 
	
	// 어린아이의 이름과 구슬의 개수를 설정하는 메서드
	void setGirl(String girlName, int num) {
		name = girlName;
		numOfMarble = num;
	}
	
	// 게임 Win -> 구슬의 개수 증가 
	void win(int num) {
		numOfMarble += num;
	}
	
	// 게임 Lose -> 구슬의 개수 감소  
	void lose(int num) {
		numOfMarble -= num;
	}
		
	// 게임 승리 메서드 : 상대(Girl), 구슬의 개수
	void playWin(Marble girl, int num) {
		// 나는 승리 -> 나의 구슬의 개수 증가
		win(num);
		// 상대는 패배 -> 상대의 구슬의 개수 감소 
		girl.lose(num);
	}
	
	// 구슬의 개수 출력하는 메서드
	void showData() {
		System.out.println(name+"의 구슬의 개수: "+numOfMarble);
	}
	
	
	// 조건을 만족하는 클래스를 정의하였다면, 다음조건을 만족하는 인스턴스를 각각 생성하자. 
	// 어린이1의 보유자산: 구슬 15개, 어린이2의 보유자산: 구슬 9개 
	public static void main(String[] args) {
	
		Marble girl1 = new Marble();
		Marble girl2 = new Marble();
		
	// 어린이1의 보유자산: 구슬 15개
	// 어린이2의 보유자산: 구슬 9개 
		girl1.setGirl("어린이1", 15);
		girl2.setGirl("어린이2", 9);
		
		System.out.println("게임 시작할 때의 어린이들이 보유한 구슬의 정보");
		girl1.showData();
		girl2.showData();
		
	// 인스턴스의 생성이 완료되면 다음의 상황을 main 메서드 내에서 시뮬레이션 하자. 
	// “1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다” 
		girl1.playWin(girl2, 2);
		System.out.println("게임: 어린이1이 승리해서 2개를 획득");
		girl1.showData();
		girl2.showData();
		
	// “2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.” 
		girl2.playWin(girl1, 7);
		System.out.println("게임: 어린이2가 승리해서 7개를 획득");
		girl1.showData();
		girl2.showData();		
		
	// 마지막으로 각각의 어린이의 보유 구슬의 개수를 출력하고 프로그램 종료.
		System.out.println("게임 종료 후 결과");
		girl1.showData();
		girl2.showData();
		
	}
	
	
	
/*	int numOfMarble1=0;	// 어린아이 1이 소유하는 구슬의 개수
	int numOfMarble2=0;	// 어린아이 2가 소유하는 구슬의 개수
	int num;			// 게임으로 얻거나 잃은 구슬의 개수
 
 	// 어린아이1이 소유하는 구슬의 개수 구하기
	int firstChild(int numOfMarble1, int num) {	// 게임으로 얻거나 잃은 구슬의 개수
		numOfMarble1 += num;
		return numOfMarble1; // 게임 후 어린아이 1이 소유하는 구슬의 개수
	}
	
	void firstChildResult() {
		System.out.println("첫번째 아이가 소유하는 구슬의 개수 : " + numOfMarble1);
	}
	
	// 어린아이2가 소유하는 구슬의 개수 구하기
	void secondChild(int numOfMarble2, int num) {
		numOfMarble2 -= num;
	}
	
	void secChildResult() {
		System.out.println("두번째 아이가 소유하는 구슬의 개수 : " + numOfMarble2);
	}
	
	
	Marble ch1 = new Marble();	// 인스턴스화
	
	ch1.firstChild(15,2);
	
	System.out.println("1차 게임 결과 --------------------------");
	ch1.firstChildResult();		
	ch1.secChildResult();
	
	
	ch1.firstChild(9,-7);
	
	System.out.println("2차 게임 결과 --------------------------");
	ch1.firstChildResult();		
	ch1.secChildResult();
	*/
	
	
}
