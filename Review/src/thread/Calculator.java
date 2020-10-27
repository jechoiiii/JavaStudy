package thread;

public class Calculator {

	int opPlusCnt = 0;
	int opMinusCnt = 0;
	
	public int add(int n1, int n2) {
		opPlusCnt++;
		return n1+n2;
	}
	
	public int minus(int n1, int n2) {
		opMinusCnt++;
		return n1-n2;
	}	
	
	// 새로운 동기화 키 ( -> 멀티 쓰레드 처리)
	Object obj = new Object();
	
	
	
//	int opCnt = 0;	// 연산의 횟수
//
//	public int add(int n1, int n2) {
//		opCnt++;
//		return n1+n2;
//	}
//	
//	public int minus(int n1, int n2) {
//		opCnt++;
//		return n1-n2;
//	}
	
	
}
