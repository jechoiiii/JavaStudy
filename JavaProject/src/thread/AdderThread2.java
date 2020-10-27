package thread;

public class AdderThread2 extends Thread {

	Sum sum;
	int start;
	int end;
	
	public AdderThread2(Sum sum, int start, int end){
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
