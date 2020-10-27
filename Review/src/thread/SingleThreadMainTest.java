package thread;

import javax.swing.JOptionPane;

public class SingleThreadMainTest {	
// 싱글 쓰래드 : 하나의 쓰래드 순서대로 진행 (사용자 입력 완료 -> Count Down) 

	// JOptionPane : 사용자 입력
	public static void main(String[] args) {
		
		// Age Input 
		String age = JOptionPane.showInputDialog("나이를 입력해주세요.");
			// 창 띄우고 대기 중 main 쓰래드 STOP  
			// 취소 선택 시 null 값 참조 -> 오류 
		
		int ageNum = Integer.parseInt(age);
		
		System.out.println("저의 나이는 "+age+"살 입니다.");
		
		// Count Down
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}
}
