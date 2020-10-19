package friend;

public class HighFriend extends Friend {	// HighFriend는 Friend를 상속하고, Friend는 Object를 상속한다.
	
	private String work;	// 고교 동창의 직업
	
	// 상위클래스의 생성자를 호출해 초기화해야 한다. 
	// 생성자를 통해 인스턴스 변수 초기화
	HighFriend(String name, String pNum, String addr, String work) {
		super(name, pNum, addr);	// 상위클래스 생성자는 꼭 첫 문장에
		this.work = work;
	}

	@Override
	public void showData() {	// Friend f = new HighFriend(); => f.showData()
		super.showData();
		System.out.println("직업 : " +work);	
		 	// work를 직접 참조시킬 순 없지만 오버라이드를 통해 work를 출력하는 기능을 구현할 수 있다. 
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("전화번호 : " + getPhoneNumber());
		System.out.println("주소 : " + getAddr());
	}

	
}

