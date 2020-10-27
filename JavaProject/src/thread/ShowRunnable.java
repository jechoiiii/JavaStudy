package thread;

// 쓰래드 클래스 정의할 때 상속이 필요한 경우, Runnable을 구현해서 정의할 수도 있다. 
public class ShowRunnable implements Runnable{

	@Override
	public void run() {	
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요. Runnable입니다.");
			try {
			// Object 클래스의 sleep(ms) 메서드 : 현재 쓰래드를 1/1000 간격으로 멈춤 
				Thread.sleep(1000);	// 100/1000 -> 1/10초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
					}
	System.out.println("Runnable 쓰레드가 종료되었습니다.");	
	}




}
