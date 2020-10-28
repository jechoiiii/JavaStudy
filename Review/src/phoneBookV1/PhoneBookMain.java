package phoneBookV1;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfo pi1 = new PhoneInfo("박세리", "010-5555-9999", "2020.10.28");
		PhoneInfo pi2 = new PhoneInfo("곽민정", "0101-3333-2222", "2010.05.10");
		
		pi1.ShowInfo();
		pi2.ShowInfo();
		
		
	}
	
}
