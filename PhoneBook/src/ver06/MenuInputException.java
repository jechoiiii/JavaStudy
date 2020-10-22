package ver06;

public class MenuInputException extends Exception {

	private int select;
	
	public MenuInputException(int select) {
		super();
		this.select = select;
	}

	@Override
	public String toString() {
		return "MenuInputException [select=" + select + " , getMessage()="+getMessage()+ "]";
	}

}


