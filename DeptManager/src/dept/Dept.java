package dept;

// VO (Value Object) : 데이터 저장 기능만 가지는 클래스, read only (setter 없는 경우)
// DTO (Data Transfer Object) : 데이터 저장 기능을 가지는 클래스, write 가능 

public class Dept {

	private int deptno;
	private String dname;
	private String loc;
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno="+deptno+", dname="+dname+", loc="+loc+"]";
	}
	
	
	
	
}
