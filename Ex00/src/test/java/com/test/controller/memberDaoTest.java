package com.test.controller;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.memberDao;
import com.test.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class memberDaoTest {
	@Autowired
	memberDao dao;
	
	@Test
	public void testLoginCheck() throws Exception{
		int result = dao.loginCheck("admin", "1234");
		System.out.println(result);
	}
	
	@Test
	public void testRegisterAction() throws Exception{
		int result = dao.insert(new MemberDto("TestID2","TestPw2","TestName2",1000));
		if(result==1) {
			System.out.println("회원가입 성공!");
		} else
			System.out.println("회원가입 실패!");
	}
	
	@Test
	public void testShowAll() throws Exception{
		List<MemberDto>memberList = dao.showAll();
		for(MemberDto dto : memberList){
			System.out.println(dto);
		}
	}
	
	@Test
	public void testDelete() throws Exception{
		int result = dao.delete("aa");
		if(result==1) {
			System.out.println("회원삭제 성공!");
		}
	}
	
	@Test
	public void testUpdateMember() throws Exception{
		
	}
}
