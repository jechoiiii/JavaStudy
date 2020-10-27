package thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		// Thread 생성
		ShowThread st1 = new ShowThread("1번 쓰래드");
		ShowThread st2 = new ShowThread("2번 쓰래드");
		
		// Runnable 인터페이스 이용한 Thread 생
		Runnable target = new ShowRunnable();
		Thread st3 = new Thread(target);
		
		
		// 스케줄링 우선 순위 설정 1~10 : 기본 5
		// MAX_PRIORITY = (숫자)10, MIN_PRIORITY = (숫자)1
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		st1.setPriority(Thread.MAX_PRIORITY);	// 1번 쓰래드는 10에 우선순위 부여
		// st1.setPrioirty(Thread.NORM_PRIOIRTY);
		st2.setPriority(Thread.MIN_PRIORITY);	// 2번 쓰래드는 1에 우선순위 부여

		// start()와 run()의 차이 
		// start 시에는 쓰래드 돌리면서 코드 수행, run 시에는 run 완료 후 코드 수행
		st1.start();
		st2.start();
		st3.start();
		
		for(int i=0; i<100; i++) {
			System.out.println("안녕하세요 메인 쓰래드입니다.");
			try {
				// Thread.sleep() 메서드 : 수행결과를 잘 확인할 수 있도록 컴퓨터의 처리 시간을 지연시켜 출력 
				Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
		System.out.println("메인 쓰래드가 종료되었습니다.");
		
		
	}

}
