package exam;

public class MarbleMain {

	public static void main(String[] args) {

		
		Marble ch1 = new Marble();	// 인스턴스화
			
		ch1.firstChild(15,2);
		
		System.out.println("1차 게임 결과 --------------------------");
		ch1.firstChildResult();		
		ch1.secChildResult();

		
		ch1.firstChild(9,-7);
		
		System.out.println("2차 게임 결과 --------------------------");
		ch1.firstChildResult();		
		ch1.secChildResult();
		
	}

}
