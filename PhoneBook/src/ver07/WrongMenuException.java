package ver07;

public class WrongMenuException extends Exception {

	private int select;
	
	public WrongMenuException(int select) {
		super();
		this.select = select;
	}

	@Override
	public String toString() {
		return "WrongMenuException [select=" + select + " , getMessage()="+getMessage()+ "]";
	}

}


