package thread;

// 쓰래드 클래스의 정의 (2) 상속이 필요한 경우, Runnable 인터페이스를 구현해 쓰래드 생성
public class ShowRunnable implements Runnable {

	@Override
	public void run() {
		
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요. Runnable 쓰래드 입니다.");
			// Object 클래스의 sleep(ms)메서드 : 현재 쓰래드를 1/1000 간격으로 멈춤 (예외처리 필요)
			try {
				Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		System.out.println("Runnable 쓰래드가 종료되었습니다.");

	}
}
