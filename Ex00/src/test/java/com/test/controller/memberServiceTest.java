package com.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dto.MemberDto;
import com.test.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class memberServiceTest {
	@Autowired
	private MemberService service;
	
	@Test
	public void testLoginCheckService() throws Exception{		
		System.out.println(service.loginCheck("admin", "1234"));
	}
	
	@Test
	public void testRegisterMemberService() throws Exception{
		System.out.println(service.registerMember(new MemberDto("test2","1234","test2",1000)));
	}
	
	@Test
	public void testShowAllService() throws Exception{
		System.out.println(service.showall());
	}
	
	@Test
	public void testDeleteMember() throws Exception{
		System.out.println(service.deletMember("TestID"));
	}
}
