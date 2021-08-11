package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.memberDao;
import com.test.dto.MemberDto;

@Service
public class memberServiceImpl implements MemberService {
	@Autowired
	memberDao dao;
	
	@Override
	public boolean loginCheck(String id, String pw) {
		int result = dao.loginCheck(id, pw);
		return result==1;
	}

	@Override
	public boolean registerMember(MemberDto dto) {
		int result = dao.insert(dto);
		return result == 1;
	}

	@Override
	public List<MemberDto> showall() {
		List<MemberDto> list = dao.showAll();
		return list;
	}

	@Override
	public int deletMember(String id) {
		int result = dao.delete(id);
		return result;
	}

	@Override
	public int updateMember(MemberDto dto) {
		int result = dao.update(null);
		return result;
	}

}
