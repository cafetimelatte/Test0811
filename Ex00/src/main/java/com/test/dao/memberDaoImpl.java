package com.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.dto.MemberDto;

public class memberDaoImpl  implements memberDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int loginCheck(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		int result = sqlSession.selectOne("com.test.mapper.memberMapper.loginCheck",map);
		return result;
	}

	@Override
	public int insert(MemberDto dto) {	
		return sqlSession.insert("com.test.mapper.memberMapper.insertMember",dto);
	}

	@Override
	public List<MemberDto> showAll() {
		return sqlSession.selectList("com.test.mapper.memberMapper.showAll");
	}

	@Override
	public int delete(String id) {
		int result = sqlSession.delete("com.test.mapper.memberMapper.deleteMember",id);
		return result;
	}

	@Override
	public int update(String id) {
		return sqlSession.update("com.test.mapper.memberMapper.updateMember", id);
	}

}
