package ver07;

public class NoDataException extends Exception{

	private int cnt;
	
	public NoDataException(int cnt) {
		super();
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "NoDataException [count=" + cnt + " , getMessage()="+getMessage()+ "]";
	}
}
