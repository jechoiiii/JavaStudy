package thread;

public class AdderThread2 extends Thread {

	Sum sum;
	int start;
	int end;
	
	// 생성자로 초기화 
	AdderThread2(Sum sum, int start, int end) {
		this.sum = sum;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			sum.addNum(i);
		}	
		
	}
}
