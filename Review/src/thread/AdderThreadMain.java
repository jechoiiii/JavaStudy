package thread;

public class AdderThreadMain {

	public static void main(String[] args) {
	
		// 인스턴스 생성 : Runnable 구현은 생성자 매개변수 필요 (at1, at2)
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		// 쓰래드 설정	
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		// start() 호출 : 쓰래드 실행대기(Runnable) 상태로 만듬 
		t1.start();
		t2.start();
		
		// join() 호출 : 현재 쓰래드가 종료될 때까지 다른 쓰래드는 대기(멈춤) * 예외처리 필요 
		// 만약 없다면, 새로 생성한 스레드(자손 스래드)의 종료를 기다리지 않고 조상 스래드를 진행할 것. (순서 유의)
		// 즉 t1이 끝나기 전에 t2를 호출해 계속 다른 값을 참조해 매번 다른 값이 출력된다. 
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100의 합 : "+ (at1.getNum()+at2.getNum()));
		
	}

}
