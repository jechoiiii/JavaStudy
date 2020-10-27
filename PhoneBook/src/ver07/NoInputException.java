package ver07;

public class NoInputException extends Exception{

	private int index;
	
	NoInputException() {
		super();
	}
	
	@Override
	public String toString() {
		return "NoInputException [index=" + index + " , getMessage()="+getMessage()+ "]";
	}
}
