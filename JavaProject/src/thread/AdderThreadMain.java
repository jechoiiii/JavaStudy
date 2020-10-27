package thread;

public class AdderThreadMain {

	public static void main(String[] args) {

		AdderThread at1 = new AdderThread(1, 50); // 1~50
		AdderThread at2 = new AdderThread(51, 100);	// 51~100
		
		// 쓰래드 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		try {
			// Object 클래스의 join() : t1 쓰래드가 종료될 때까지 다른 쓰래드는 멈춘 상태. CPU 할당받지 X 
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100 의 합 : " + (at1.getNum()+at2.getNum()) );
			// MISTAKE : 괄호처리 안했을 때 문자열이 붙어서 이상하게 출력됨

		
	}

}
