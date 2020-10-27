package thread;

public class Calculator {

	// int opCnt=0;
	int opPlusCnt=0;
	int opMinusCnt=0;
	
	public int add(int n1, int n2) {
		synchronized(this) { // 참조변수 this는 인스턴스의 단 하나의 key 로 사용된다.
							 // this : 동기화 대상
			opPlusCnt++;	
		}
		return n1+n2;
	}
	
	public int minus(int n1, int n2) {
		synchronized(obj) { // 위에서 key 사용하면 여기서 opCnt++은 대기하고 n1-n2값만 반환 (데이터 일관성 유지) 
			opMinusCnt++;	
		}
		return n1-n2;
	}
	
	// 새로운 동기화 키  (-> 멀티 쓰래드 처리)
	Object obj = new Object();
	
	
	
//	synchronized public int add(int n1, int n2) {
//		opCnt++;
//		return n1+n2;
//	}
//	
//	public synchronized int minus(int n1, int n2) {
//		opCnt++;
//		return n1-n2;
//	}
	
}
