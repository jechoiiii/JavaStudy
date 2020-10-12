package first;

public class LoopTest {

	public static void main(String[] args) {
		
		/* 	반복문: for, while, do~while
		- for문과 while문은 서로 변경 가능하다.
		- do-while문은 조건을 만족하지 못하더라도 최소한 한번은 수행한다.
	 	
	 	
	 	for => 반복의 횟수가 정해졌을 때 
	 	형식: 	for(int i = 0(index)(초기화); i <10(반복의 조건); 증감식(i+=1)) {
	 			반복 영역}
	 	
	 	배열(데이터의 묶음) + for 반복문   * 집합객체인 컬렉션도 배열과 유사해 for반복문과 사용한다. 
	 	

	 	while => 반복의 횟수를 모를 때 - DB, JDBC
	 	형식: 	int i = 0; (초기화)
	 			while (i<10(반복의 조건)) {
	 				반복 영역 
	 				i++;}
//	 
		*/
		
		// while Loop	
		// 반복의 횟수를 체크하기 위한 인덱스
		int i=0;
		
		while (i<5) {
			System.out.println("자바 안녕 - " +i);
			i++;	// 탈출을 위한 연산식 (없으면 i=0만 무한반복)
		}
		System.out.println("==============================");
		
		// do while Loop
		// 최소 한번 실행 후 조건에 맞게 반복 실행
		i=0; 	// i=5로 세팅되어 있으니 초기화 필요
		
		do {
			System.out.println("안녕 자바 - " +i);
			i++;
		} while (i<5);		// 조건과 상관없이 한번은 무조건 실행
		System.out.println("==============================");
		
		// for Loop
		int sum=0;	// 합을 구하기 위한 변수 선
		
		for(int j=1; j<11; j++) {	// 지역변수: j는 for문 블럭 안에서만 사용가능한 변수. for문이 끝나면 소멸한다.
			sum = sum + j;
		}
		System.out.println("1~10까지의 합 : " + sum);
		System.out.println("==============================");
		
		
		// 0부터 몇까지 더해나갔을 때 합이 100을 넘어가는지 확인하는 프로그램
		sum = 0;
		i = 0;
		
		// 몇번을 반복해야 하는지 모르는 경우 : 무한반복 처리
		while(true) {
			// 탈출의 조건
			if(sum>100) {
				break;	// break를 감싸고 있는 while블럭 탈출
			}
			i++;		// 더하는 수의 증가
			sum+= i;	// 합을 구하는 연산
		}
		System.out.println(i + "를 더했을 때 합이 100이 넘어갑니다. 100이 넘어가는 최초의 값은 " + sum);
		System.out.println("==============================");
		
		// 1~10까지의 수 중에 3의 배수를 생략하고 출력
		for(i=0; i<11; i++) {
			if(i%3==0) {	// 3의 배수를 찾는 조건
				continue;
			}
			System.out.println(i);
		}
		System.out.println("==============================");

			if(!(i%3==0)) {
				System.out.println(i);
			} // 로 대체가
		
			
		// continue를 이용한 숫자 찾기 
		// 0~99 까지의 수 중에 5의 배수이면서 7의 배수인 숫자를 출력하고 총 몇개가 존재하는지 개수를 출력
		int num = 0;
		int count = 0;
		
		while((num++)<100) {	// (탈출의 조건)
			//num++;
			if(num%5!=0 || num%7!=0) {	//	!(num%5==0 && num%7==0)
				continue;
			}
			count++;
			System.out.println(num);		
		}
		System.out.println("0~99 사이의 숫자 중에 5의 배수이면서 7의 배수인 숫자는 모두 " +count+ "개가 있습니다");
		System.out.println("==============================");

		// 이름 붙은 반복문 
		outerLoop :	for(i=1; i<10; i++) {
			
				for(int j=1; j<10; j++) {
					System.out.println("[" +i+ "," +j+ "]");
					if(i%2==0 && j%2==0)
						break outerLoop;	
						// 반복문에 이름 붙이지 않으면, j에 대한 for문만 탈출하고 i에 대한 for문은 탈출X
				}
		}
		
		
		
		
		
	}

}
