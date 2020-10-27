package thread;

// 쓰래드 클래스의 정의 (1) Thread 클래스를 상속 (명시 필수)
public class ShowThread extends Thread {

	String threadName;
	
	public ShowThread(String name) {
		threadName = name;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요. "+threadName+"입니다.");
			try {
				sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
		}
		System.out.println(threadName+"쓰래드가 종료되었습니다.");
		
	}
	
}
