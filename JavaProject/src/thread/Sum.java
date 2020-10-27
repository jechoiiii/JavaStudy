package thread;

public class Sum {

	int num;
	
	Sum(){
		num=0;
	}
	
	// 동기화 처리 : 한번에 한 쓰레드만 접근 가능하도록 LOCK해 데이터의 일관성 유지
	synchronized void addNum(int n) {
		num += n;
	}
	
	int getNum() {
		return num;	
	}
	
}
