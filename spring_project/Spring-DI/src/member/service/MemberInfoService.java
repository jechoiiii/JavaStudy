package member.service;

import member.dao.Dao;

public class MemberInfoService implements MemberService {

	Dao dao;
	
	// 프로퍼티의 주입 방식
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 실행");
		dao.select();
		return null;
	}

}
