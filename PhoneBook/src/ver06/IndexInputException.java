package ver06;

public class IndexInputException extends Exception{

	private int index;
	
	IndexInputException(int index) {
		super();
		this.index = index;
	}
	
	@Override
	public String toString() {
		return "IndexInputException [index=" + index + " , getMessage()="+getMessage()+ "]";
	}
}
