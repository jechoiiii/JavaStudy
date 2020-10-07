package first;

public class ExamOper2 {

	public static void main(String[] args) {
	
		// [과제] 연산자 추가 문제
	/*	1번. 다음 연산의 결과를 적으시오.
	 */	System.out.println("문제 1 -----------------------------------");
		
		int x = 2;
		int y = 5;
		char ch = 'A'; // 'A'의문자코드는 65

		System.out.println(y += 10 - x++); // y = y+10 -x++(값 대입 후 증가) = 5+10-2 = 13 출력, int x = 3
		System.out.println(x += 2); // x = x+2 = 3+2 = 5
		System.out.println(!('A' <= ch && ch <= 'Z')); // !(65 <= 65 <= 90) = !(true) = false
		System.out.println('C' - ch); // 67 - 65 = 2
		System.out.println('5' - '0'); // 53 - 48 = 5
		System.out.println(ch + 1); // 65 + 1 = 66
		System.out.println(++ch); // ++ch(증가 후 값 대입) -> 65 + 1 = 66 -> char(66) = 'B'
		System.out.println(ch++); // ch++(값 대입 후 증가) -> B 출력, (int)ch++ = 66 + 1 = 67 -> 'C'
		System.out.println(ch); // ch -> C

	/* 	2번. 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
		만일 사과의수가 123개이고 하나의 바구니에는10개의 사과를 담을 수 있다면,13개의 바구니가 필요할 것이다.(1)에 알맞은 코드를 넣으시오.
		[실행결과 : 13]
	*/	System.out.println("문제 2 -----------------------------------");


		int numOfApples = 123; // 사과의 개수
		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int numOfBucket = (numOfApples % sizeOfBucket == 0) ? numOfApples / sizeOfBucket
				: numOfApples / sizeOfBucket + 1;
		// 모든 사과를담는데 필요한 바구니의 수
		// 전체 사과를 10으로 나눈 몫이 바구니 개수. 10으로 나눈 나머지가 0보다 크면 바구니 개수 +1
		
		// 1. 전체 사과의 개수를 10으로 나눈다
		numOfBucket = numOfApples/sizeOfBucket;
		// 2. 전체 사과를 10으로 나눈 나머지를 구하고, 나머지가 10보다 크면 바구니 개수를 1 증가
		if (numOfApples%numOfBucket>0) {
			numOfBucket++;
		}
		
		numOfBucket = numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket>0? 1:0);
		
		System.out.println("필요한바구니의 수 :" + numOfBucket);

	/* 	3번. 아래는 변수 num의 값에 따라 ‘양수’,‘음수’,‘0’을 출력하는 코드이다.삼항 연산자를 이용해서(1)에 알맞은 코드를 넣으시오.
		[Hint] 삼항 연산자 두 번 사용하라.
		[실행 결과 : 양수]		 
	*/	System.out.println("문제 3 -----------------------------------");
	
		int num = 10;
		System.out.println((num > 0) ? "양수" : ((num < 0) ? "음수" : "0"));
		

	/* 	4번. 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
		만일 변수 num 의 값이‘456’이라면 ‘400’이 되고,‘111’이라면 ‘100’이 된다.(1)에 알맞은 코드를 넣으시오.
		[실행 결과 : 400]
	*/	System.out.println("문제 4 -----------------------------------");
		
		num = 456;
		System.out.println(num - num%100);
		System.out.println(num / num * 100);
		
	/* 	5번. 아래는 변수num의 값 중에서 일의 자리를1로 바꾸는 코드이다.
		만일 변수 num의값이 333이라면 331이 되고,777이라면 771이 된다.(1)에 알맞은 코드를 넣으시오.
		[실행 결과 : 331]
	*/	System.out.println("문제 5 -----------------------------------");
		
		num = 333;
		System.out.println(num - num%10 + 1);
		System.out.println(num/10*10 + 1);
	
	/* 	6번. 아래는  변수num의 값보다 크면서도 가장 가까운10의 배수에서 변수num의 값을뺀 나머지를 구하는 코드이다.
	 	예를 들어, 24의 크면서도 가장 가까운10의 배수는 30이다.19의 경우 20이고,81의 경우 90이 된다.30에서 24를 뺀 나머지는6이기 때문에 변수num의 값이 24라면6을결과로 얻어야 한다.(1)에 알맞은 코드를 넣으시오.
		[실행 결과 : 331]
	*/	System.out.println("문제 6 -----------------------------------");
	  	
		num = 24;
		System.out.println(10 - (num + 10)%10);
		System.out.println(10 - num%10);
		// 10의 자리 뽑기: 735 -> 735/100 -> 73/10 -> 3
		
	/*  7번.아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.변환공식이 'C =5/9 ×(F - 32)'라고 할 때,(1)에 알맞은 코드를 넣으시오.
	 	단, 변환 결과값은 소수점셋째 자리에서 반올림해야 한다.(Math.round()를 사용하지 않고 처리할 것)
	 */	System.out.println("문제 7 -----------------------------------");
		
	 	int fahrenheit =100;
		float celcius = (int)(5/9f*(fahrenheit - 32)*100 + 0.5)/100f;	
		// 5/9의 소수점 나와야하니 f 추가.
		// 0.4 + 0.5 -> 0.9 -> int로 0 / 0.6 + 0.5 -> 1.1 -> int로 1
		// (int)()뒤에 괄호해야하는 이유: if not, 5/9f를 int로 형변환함
	
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);

	/*	8번.	아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
	 	[실행결과 : c = 30, ch = C, f=1.5, l=27000000000, result=true]
	*/	 	System.out.println("문제 8 -----------------------------------");
	
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b); 	// 또는 int c = a + b;
		// byte. short, char : 연산의 경우 int 자료형으로 자동변환
		 
		char chh = 'A';
		chh = (char)(chh + 2);
		 
		float f = 3 / 2f; 
	
		long l = 3000L * 3000 * 3000;	// 어떤 3000에든 하나만 long타입으로 변환
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = (float)d==f2; 

		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
	 
		
	/*	9번. 다음은 문자형 변수ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수b의 값이true가 되도록 하는 코드이다.
	 	(1)에 알맞은 코드를 넣으시오. 
	 	[실행결과 : true] * 0(48)~9(57), A(65)~Z(90), a(97)~z(122)
	*/	System.out.println("문제 9 -----------------------------------");
	
		ch = 'z';
		boolean boo = ('z'>=48 && 'z'<=57 || 'z'>=65 && 'z'<=90 || 'z'>=97 && 'z'<=122);
		System.out.println(boo);
		
		boolean b2 = (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>=0 && ch<=9);
		System.out.println(b2);
		// 비교연산 &&가 ||보다 우선된다
		
	/*	10번.다음은 대문자를 소문자로 변경하는 코드인데,문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다.
		문자코드는 소문자가 대문자보다32만큼 더 크다.예를들어 'A‘의 코드는65이고 ’a'의 코드는97이다. (1)~(2)에 알맞은 코드를 넣으시오.
		[실행결과 : ch:A, ch to lowerCase: a]
	*/	System.out.println("문제 10 -----------------------------------");
	
		ch = 'A';
		char lowerCase = (char)((ch>=97 && ch<=122) ? ch-32 : ch); 	// 명시적 형변환 필요
//		char lowerCase1 = (ch>='A' && ch<='Z') ? (char)ch+32 : ch;
		System.out.println("ch:"+ch);
		System.out.println("ch to lowerCase:"+lowerCase);
		
		
		
		
		
		
	}

}
