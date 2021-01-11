package com.aia.firstspring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aia.firstspring.member.domain.Member;

@Repository // Bean 자동 등록 -> root-context.xml에서 Bean 등록 주석 처리
public class MemberDao {

	@Autowired
	private JdbcTemplate template;
	
	// JdbcTemplate template 인스턴스를 주입 
	// 1. 생성자 주입 방식 
	// 2. 프로퍼티 주입 방식 
	// 3. 자동 주입 
	
//	// 생성자를 이용한 객체 주입
//	public MemberDao(JdbcTemplate t) {
//		template = t;
//		System.out.println("MemberDao 인스턴스 생성");
//	}
	

	public List<Member> selectMemberList() {
		return template.query(	// 쿼리문 결과값 받아오기 
				"select * from member order by membername", 
				new RowMapper<Member>() {

					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member();
						member.setIdx(rs.getInt("idx"));
						member.setMemberid(rs.getString("memberid"));
						member.setMembername(rs.getString("membername"));
						member.setPassword(rs.getString("password"));
						member.setMemberphoto(rs.getString("memberphoto"));
						member.setRegdate(rs.getTimestamp("regdate"));
						return member;
					}
					
				});
	}
	
	
	public int selectTotalCount() {
		return template.queryForObject("select count(*) from member", Integer.class);
	}


	public int insertMember(Member member) {
		String sql = "insert into member (memberid, membername, password) values(?,?,?)";
		return template.update(sql, member.getMemberid(), member.getMembername(), member.getPassword());
		
	}
	
	
}
