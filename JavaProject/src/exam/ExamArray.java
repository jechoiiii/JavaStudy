package exam;

import java.util.Scanner;

public class ExamArray {

	public static void main(String[] args) {		
		// main메서드 : 프로그램 시작 시점. 인스턴스/메서드 호출해서 프로그램 흐름을 만든다.
		// 메서드/변수는 클래스에 정의하고, 메인 메서드에서 인스턴스를 생성하고 참조변수/메서드를 호출한다.

/* 
	문제 1. -------------------------------------------------
*/
		// 배열 선언
		int[] arr = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 5개를 입력해주세요.");
		System.out.println("정수 1");
		for(int i=0; i<arr.length; i++) {
			System.out.println("정수를 입력해주세요. >> ");
			arr[i]= sc.nextInt();
		}
		
		System.out.println("최대값 : " + maxValue(arr));
		System.out.println("최소값 : " + minValue(arr));	

/* 
	문제 2. ---------------------------------------------------
*/
		int[][] arr2 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		System.out.println("2차원 배열 =============");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.println(arr2[i][j]);
			}
			System.out.println();
		}

		addOneDArr(arr2, 5);
		System.out.println("배열 요소 전체에 +5 =============");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.println(arr2[i][j]);
			}
			System.out.println();
		}
	
	
	
	// main 종료 ==================================================================
	}	
	
/*
	문제 1. -------------------------------------------------------------
		int형 1차원 배열을 매개변수로 전달 받아서 
		배열에 저장된 최대값, 그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
		​
		public static int miniValue(int[] arr) { . . . . } // 최소값 반환
		public static int maxValue(int[] arr) { . . . . } // 최대값 반환
		​
		위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
		두 매소드 실행을 확인인하기 위한 main 메소드 정의.
		int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는 임의로 결정
*/
	
	// 전달받은 1차원 배열에서 최소값을 축출해서 반환하는 메서드 
	public static int minValue(int[] arr) {	// static 메서드는 static 멤버만 호출가능 // int 타입 배열 안 변수들은 모두 int 타입
		int min = arr[0];
		for(int i=1; i<arr.length; i++) { 	// i를 1로 설정한 이유: 연산 줄이기 위해. 이미 0번지가 min으로 설정되어 비교 불필요
			if(min>arr[i]) {			
				min = arr[i];				// else할 필요 없어. if 충족못하면 min은 그대로.
			}
		}
		return min;
	}
	
	// 전달받은 1차원 배열에서 최대값을 축출해서 반환하는 메서드
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
				
/*
 	문제 2. ------------------------------------------------------------
		int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.

		public static void addOneDArr(int[][] arr, int add) { . . . . . }

		단, 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 
		위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.
 */
	// 2차원 배열은 1차원 배열들을 가지는 또 다른 1차원 배열이다.
	
	public static void addOneDArr(int[][] arr, int add) {	// 2차원 배열 arr
	
		// 2차원 배열이 가지는 1차원 배열의 개수만큼 반복
		// 		각각의 1차원 배열을 반복 arr[0] 
		for(int i=0; i<arr.length; i++) {
			for(int j=0; i<arr[i].length; j++) {
				arr[i][j] = arr[i][j] + add;
			}
		}
	}
	
/*
	문제 3. ------------------------------------------------------------
		다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
		1 2 3 <- arr[0]
		4 5 6 <- arr[1]
		7 8 9 <- arr[2]
		이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
		7 8 9 <- arr[2]
		1 2 3 <- arr[0]
		4 5 6 <- arr[1]
		즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다. 
		이번에도 마찬가지로 배열의 가로, 세로길이에 상관 없이 동작을 하도록 메서드가 정의되어야 하며, 
		정의된 메서드의 확인을 위한 main메서드도 함께 정의하자.
 */
	
	public static void changeArr(int[][] arr) {
		
		// 2차원 배열은 1차원 배열들을 요소로 갖는 배열이다. 
		// 1차원 배열들의 위치를 변경 -> 2차원 배열이 가지는 1차원 배열의 주소값이 변경
		
		// 주소값의 변경을 위한 임시 배열 선언, 생성
		int[] temp = new int[arr[0].length];	// [arr[arr.length-1].length]
		
		temp = arr[arr.length-1];	// 2차원 배열의 마지막 요소인 1차원 배열을 temp에 저장

		for(int i=arr.length-1; i>0; i--) {	// 0번지를 처리하려면 -1번지가 필요하니 제외
			arr[i] = arr[i-1];			
		}
		arr[0] = temp;
	}
	

		
		
		
		
		
		
	

}
