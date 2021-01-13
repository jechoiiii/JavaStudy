package com.aia.firstspring.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aia.firstspring.member.domain.Member;

@Repository
public class MybatisMemberDao {
	
	private String nameSpace = "com.aia.firstspring.mybatis.mapper.memberMapper";

	@Autowired
	private SqlSessionTemplate template;
	
	public List<Member> selectMemberList() {
		return template.selectList(nameSpace+".");
	}
	
}
