package thread;

public class AdderThreadMain2 {


	public static void main(String[] args) {
		
		// Sum 클래스 인스턴스 생성 
		Sum sum= new Sum();
		
		AdderThread2 t1 = new AdderThread2(sum, 1, 50);
		AdderThread2 t2 = new AdderThread2(sum, 51, 100);
	
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100의 합 : "+ sum.getNum());
		
	}
	
	
	
	

	
	
}