package thread;

import javax.swing.JOptionPane;

public class ThreadTestMain1 {	// 싱글 쓰래드

	public static void main(String[] args) {
		
		// JOptionPane.showInputDialog("이름을 입력해주세요.");
		String age = JOptionPane.showInputDialog("나이를 입력해주세요.");	
				// 창 띄우고 대기 main쓰래드가 멈추고 있음. 취소 선택 -> null 값 -> 오류

		int ageNumber = Integer.parseInt(age);
		
		System.out.println("저의 나이는 "+ age +"살 입니다.");
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
