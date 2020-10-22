package basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
	
		String strData = "11,22,33,44,55";
		StringTokenizer st = new StringTokenizer(strData, ",", true);
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("-----------------");
		String pNum = "Tel 82-010-1111-2222";
		StringTokenizer st1 = new StringTokenizer(pNum);
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(pNum, "- "); // 구분자 '-' ' '
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		System.out.println("-----------------");
		StringTokenizer st3 = new StringTokenizer(pNum, "- ", true);
		
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		
	}

}
