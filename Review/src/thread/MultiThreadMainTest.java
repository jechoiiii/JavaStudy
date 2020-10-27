package thread;

import javax.swing.JOptionPane;

public class MultiThreadMainTest {	
// 멀티 쓰래드 : 두 쓰래드가 동시에 진행 (사용자 입력 창 띄우고 Count Down 시작) 

	// 사용자 입력 시 종료 처리하기 위한 클래스 변수 
	// 다른 쓰래드에서도 참조가 가능한 클래스 변수*
	public static boolean check = false;
	
	// JOptionPane : 사용자 입력
	public static void main(String[] args) {
		
		AgeInputThread iat = new AgeInputThread();
		CountDownThread cdt = new CountDownThread();
		
		iat.start();
		cdt.start();

	}
}

class AgeInputThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("10초 안에 입력 해주세요.");
		String age = JOptionPane.showInputDialog("나이를 입력해주세요.");
			// 창 띄우고 AgeInput 쓰래드 대기
		MultiThreadMainTest.check = true;
		System.out.println("저의 나이는 "+age+"살 입니다.");
		
		
	}

}

class CountDownThread extends Thread {
	
	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			// 사용자 입력 시 종료 처리
			if(MultiThreadMainTest.check) {
				break;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}	
		System.exit(0); // 프로그램 종료
	}

}