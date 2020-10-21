package exception;

public class AgeInputException extends Exception {

	private int age; 
	
	// 생성자
	public AgeInputException(int age) {
		super();
		this.age = age;
	}

	@Override
	public String toString() {
		return "AgeInputException [age=" + age + " , getMessage()="+getMessage()+ "]";
	}


	
	
	
	
}
