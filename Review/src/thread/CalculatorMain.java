package thread;

public class CalculatorMain {

	public static void main(String[] args) {
	
		// Calculator 클래스 인스턴스 생성 
		Calculator cal = new Calculator();
		
		// AddThread, MinusThread 클래스 인스턴스 생성 
		AddThread at = new AddThread(cal);
		MinusThread mt = new MinusThread(cal);
		
		at.start();
		mt.start();
		
		try {
			at.join();
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("연산의 횟수 : "+ cal.opPlusCnt);
		System.out.println("연산의 횟수 : "+ cal.opMinusCnt);

	}
}

class AddThread extends Thread {
	
	Calculator cal;
	
	AddThread(Calculator c){
		cal = c;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println( (i+1)+"번째 연산의 2+1 합 : "+ cal.add(2, 1) );
			System.out.println( (i+1)+"번째 연산의 3+1 합 : "+ cal.add(3, 1) );		
		}
	}
	
}

class MinusThread extends Thread {
	
	Calculator cal;
		
		MinusThread(Calculator c){
			cal = c;
		}
	
		@Override
		public void run() {
			for(int i=0; i<10; i++) {
				System.out.println( (i+1)+"번째 연산의 2-1 차 : "+ cal.minus(2, 1) );
				System.out.println( (i+1)+"번째 연산의 3-1 차 : "+ cal.minus(3, 1) );			
			}
		}
	
}