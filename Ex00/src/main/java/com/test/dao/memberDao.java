package com.test.dao;

import java.util.List;

import com.test.dto.MemberDto;

public interface memberDao {
		int loginCheck(String id, String pw);
		int insert(MemberDto dto);
		List<MemberDto> showAll();
		int delete(String id);
		int update(String id);
}
