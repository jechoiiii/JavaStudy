package thread;

public class AdderThread extends Sum implements Runnable {

	int start;
	int end;
	
	// 생성자로 초기화 
	AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			addNum(i);
		}	
		
	}
}
