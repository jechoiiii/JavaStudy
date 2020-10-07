package exam;

public class Marble {
	
	/* 	어린아이가 소유하고 있는 구슬의 개수 정보를 담을 수 있다. 
		놀이를 통한 구슬을 주고받음을 표현하는 메서드가 존재. 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미.
		조건을 만족하는 클래스를 정의하였다면, 다음 조건을 만족하는 인스턴스를 각각 생성할 것. (하나의 클래스만 작성)
		
	*/

	// 변수 선언: 어린아이가 소유하고 있는 구슬의 개수 정보
	int numOfMarble1=0;	// 어린아이 1이 소유하는 구슬의 개수
	int numOfMarble2=0;	// 어린아이 2가 소유하는 구슬의 개수
	int num;			// 게임으로 얻거나 잃은 구슬의 개수
	
	// 어린아이1이 소유하는 구슬의 개수 구하기
	int firstChild(int numOfMarble1, int num) {		// 게임으로 얻거나 잃은 구슬의 개수
		numOfMarble1 += num;
		return numOfMarble1;		// 게임 후 어린아이 1이 소유하는 구슬의 개수
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
	
	
	
}
