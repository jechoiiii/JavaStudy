package com.aia.op.member.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
@Log4j
public class MemberListControllerTest {

	//@Autowired
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc; // 컨트롤러 실행할 수 있도록 지원하는 클래스 
	
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testMemberList() throws Exception {
		
		log.info( mockMvc.perform(MockMvcRequestBuilders.get("/member/list")).andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testReg() throws Exception {
		
		log.info(
				mockMvc.perform(
						MockMvcRequestBuilders.post("/member/reg")
						.param("userid", "jechoiiii@gmail.com")
						.param("pw", "1111")
						.param("username", "tester1234")
						).andReturn().getModelAndView().getModelMap()
				);
	}

}
