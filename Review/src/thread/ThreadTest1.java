package thread;

public class ThreadTest1 {
	
	public static void main(String[] args) {
		
		ShowInfo info1 = new ShowInfo(2, 1);
		ShowInfo info2 = new ShowInfo(10, 3);
		
		Thread t1 = new Thread(info1);
		Thread t2 = new Thread(info2);
		
		t1.start();
		t2.start();
		System.out.println("yes");
		
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}	
}

class ShowInfo implements Runnable{
	
	int num1;
	int num2;

	ShowInfo(int n1, int n2){
		num1 = n1;
		num2 = n2;
	}
	
	@Override
	public void run() {
		System.out.println(num1+num2);
		System.out.println(num1-num2);
		
	}
}