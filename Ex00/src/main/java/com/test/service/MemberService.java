package com.test.service;

import java.util.List;

import com.test.dto.MemberDto;

public interface MemberService {
	boolean loginCheck(String id, String pw); 
	boolean registerMember(MemberDto dto);
	List<MemberDto>showall();
	int deletMember(String id);
	int updateMember(MemberDto dto);
}
