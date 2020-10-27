package thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		//  Thread 생성
		ShowThread st1 = new ShowThread("1번 쓰레드");
		ShowThread st2 = new ShowThread("2번 쓰레드");
		
		// Runnable 인터페이스 이용한 Thread
		Runnable target = new ShowRunnable();
		Thread st3 = new Thread(target);
		
		// 우선 순위 설정 1~10 : 기본 5 (우선 순위란, 선택될 확률이 높은 것일뿐 절대적인 처리 순위가 아님)
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		st1.setPriority(Thread.MAX_PRIORITY);
		st2.setPriority(Thread.MIN_PRIORITY);
		
		st1.start();	
		st2.start();
		//st3.start();
		
//		for(int i=0; i<100; i++) {
//			System.out.println("안녕하세요 메인쓰레드입니다.");
//			try {
//				Thread.sleep(100); // 100/1000초
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		System.out.println("메인 쓰레드가 종료되었습니다.");
	}

}
