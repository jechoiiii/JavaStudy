package thread;

public class Sum {

	int num;
	
	Sum(){
		num = 0;
	}
	
	void addNum(int n) {
		num += n;
	}
	
	int getNum() {
		return num;
	}

// 왜 Mac에선 Override할 run() 없이 AdderThread에서 실행 안되는지?
	public void run() {	
		
		
	}
	
}
