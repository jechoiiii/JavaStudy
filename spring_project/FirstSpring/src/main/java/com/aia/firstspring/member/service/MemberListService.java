package com.aia.firstspring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MybatisMemberDao;
import com.aia.firstspring.member.domain.Member;

@Service // Bean 자동 등록 -> root-context.xml에서 Bean 등록 주석 처리  
public class MemberListService {

//	@Autowired
//	MemberDao dao;
	
	@Autowired
	MybatisMemberDao dao;
	
//	public MemberListService(MemberDao dao) {
//		this.dao=dao;
//	}
	
	public List<Member> getMemberList() {
		return dao.selectMemberList();
	}
	
	public int getmemberTotalCount() {
		//return dao.selectTotalCount();
		return 0;
	}
	
}
