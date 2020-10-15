package first;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PackageTest {

	public static void main(String[] args) {
		
		// java.util.Date today = new java.util.Date();
		Date today = new Date();
		// java.sql.Date 동일한 클래스명을 가진 클래스를 사용할 땐, 속한 패키지명도 꼭 명시할 것.
		
		System.out.println(today);
		
		// SimpleDateFormat 에  Ctrl + Space로 import
		// SimpleDateFormat date = null; 에 Ctrl + Shift + O 로 import
		SimpleDateFormat date = null;
		
		// yyyy -> 년도
		// MM -> 월
		// dd -> 일
		// hh -> 시
		// mm -> 분
		// ss -> 초
		// a -> 오전 / 오후
		// 2020.10.15 10:56
		date = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		
		String now = date.format(today);

		System.out.println(now);
		
		
		

	}

}
