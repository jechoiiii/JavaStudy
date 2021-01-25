package com.aia.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDao;

@Service
public class MemberVerifyService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	
	public int memberVerify(int idx, String code) {
		
		dao = template.getMapper(MemberDao.class);
	
		int result = 0;	// 0-> 잘못된 요청, 1-> 인증 완료, 3-> 이미 인증  
		
		int isVerify = dao.selectMemberByIdxVerify(idx); // DAO 갔다오기 (dao 선언) 
		//0 or 1 
		if(isVerify == 1) {
			result = 3;
		} else { // 업데이트 필요 
			result = dao.updateMemberByVerify(idx, code);
		}
		
		return result;
	}
	
}
