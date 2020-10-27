package thread;

public class AdderThreadMain2 {

	public static void main(String[] args) {
		
		Sum sum = new Sum();
		
		AdderThread2 t1 = new AdderThread2(sum, 1, 5000);
		AdderThread2 t2 = new AdderThread2(sum, 5001, 10000);
		
		t1.start();
		t2.start();
		
		try {
			// Thread.sleep(1000);
			t1.join();	
			t2.join();
			// 출력 값이 계속 다른 이유: 동시접근 시, 참조할 때마다 값이 변해서(?) => 동기화 처리의 필요성
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100의 합  : "+ sum.getNum());
		

	}

}
