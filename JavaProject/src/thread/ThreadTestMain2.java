package thread;

import javax.swing.JOptionPane;

public class ThreadTestMain2 {	// 멀티 쓰래드

	// 다른 쓰래드에서도 참조가 가능한 클래스 변수*
	public static boolean check = false;
	
	public static void main(String[] args) {
	
		InputAgeThread iat = new InputAgeThread();
		CountDownThread cdt = new CountDownThread();
		
		iat.start();
		cdt.start();

	}
}

class InputAgeThread extends Thread {

	@Override
	public void run() {
		System.out.println("10초 안에 입력을 해주세요.");
		String age = JOptionPane.showInputDialog("나이를 입력해주세요.");	
		System.out.println("저의 나이는 "+ age +"살 입니다.");	
		ThreadTestMain2.check = true;
	}		

}

class CountDownThread extends Thread {
	
	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			// 사용자 입력 시 종료 처리 
			if(ThreadTestMain2.check) {
				break;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	
}
