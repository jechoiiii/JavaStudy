package first;

/*
		파일 이름 : ArrayBubbleSort.java
		내용 : 버블 정렬 필기
		작성 일자 : 2020.10.13
 */

public class ArrayBubbleSort {

	public static void main(String[] args) {
		
		// 정수 데이터 10개를 저장하는 배열 생성
		int[] number = new int[10];
		
		// 임의의 숫자 0~9 까지의 숫자를 배열의 각 요소에 저장
		for(int i=0; i<number.length; i++) {
			number[i] = (int)(Math.random()*10);	
			System.out.print(number[i]+ " ");
		}
		
		System.out.println("\n============================");
		
		for(int i=0; i<number.length; i++) {
			
			boolean changed = false; // 자리바뀜이 발생했는지 체크
			
			// 자리를 바꾸는 처리
			for(int j=0; j<number.length-1-i; j++) { // 반복의 조건 "-i" => 자리가 확정된 요소는 크기 비교 불필요
				
				// 왼쪽 인데스의 값과 오른쪽 인덱스의 값을 비교하고, 
				if(number[j]>number[j+1]) {
					// 왼쪽 값이 크면 자리 변경  => 스위치
					int temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
					
					changed = true;
				}
			}
			
			if(!changed) {
				break;
			}
			
			for(int k : number) {	// 값의 변경이 아닌 출력이 목적
				System.out.print(number[k] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
