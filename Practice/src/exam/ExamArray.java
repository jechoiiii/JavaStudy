package exam;

import java.util.Scanner;

public class ExamArray {

	public static void main(String[] args) {		
		// main메서드 : 프로그램 시작 시점. 인스턴스/메서드 호출해서 프로그램 흐름을 만든다.
		// 메서드/변수는 클래스에 정의하고, 메인 메서드에서 인스턴스를 생성하고 참조변수/메서드를 호출한다.

/* 
	문제 1. -------------------------------------------------
*/
		Scanner s = new Scanner(System.in);
		
		int cnt=0;	// 사용자로부터 입력받을 정수의 개수
		
		System.out.println("입력하고자 하는 정수의 개수를 입력해주세요.");
		cnt = s.nextInt();
		
		int[] arr = new int[cnt];
		
		System.out.println("정수를 입력해주세요.");
		
		int ij=0;
		while(ij<arr.length) {
			System.out.println("정수를 입력해주세요. >> ");
			arr[ij]= s.nextInt();
			ij++;
		}
		
		System.out.println("최대값 : " +maxValue(arr));
		System.out.println("최소값 : " +minValue(arr));
		
/* 
	문제 2. ---------------------------------------------------
*/
		int[][] arr2 = {	
				{1,2},
				{3,4},
				{5,6}
		};
		
		System.out.println("2차원 배열 ------------------");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}
		
		addOneArr(arr2, 3);	// 메서드 호출 
		System.out.println("배열 요소 전체에 +3 -----------");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}
		
/* 
	문제 3. ---------------------------------------------------
*/		
		int[][] arr3 = {	
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		System.out.println("2차원 배열 ------------------");
		for(int i=0; i<arr3.length; i++) {
			for(int j=0; j<arr3[i].length; j++) {
				System.out.print(arr3[i][j] + "");
			}
		System.out.println();
		}
		
		System.out.println("2차원 배열 구조 변경 ----------");
		changeArr(arr3);	//메서드 호출 
		for(int i=0; i<arr3.length; i++) {
			for(int j=0; j<arr3[i].length; j++) {
				System.out.print(arr3[i][j] + "");
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
	public static int minValue(int[] arr) {
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	// 전달받은 1차원 배열에서 최대값을 축출해서 반환하는 메서드
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {

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
	
	public static void addOneArr(int[][] arr, int add) {
		
		// 2차원 배열이 가지는 1차원 배열의 개수만큼 반복 
		// 		각각 1차원 배열 arr[0] 반복 
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
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

	public static void changeArr(int[][] arr3) {
		
		// 주소값 변경을 위해 임시 배열 선언, 생성
		int[] temp = new int[arr3[0].length];
		
		temp = arr3[arr3.length-1];	// 2차원 배열의 마지막 요소인 1차원 배열(2번지)를 temp에 저장
		
		for(int i=arr3.length-1; i>0; i--) {	// 0번지를 처리하려면 -1번지가 필요하니 제외
			arr3[i] = arr3[i-1];
		}
		arr3[0] = temp;
	}


}
