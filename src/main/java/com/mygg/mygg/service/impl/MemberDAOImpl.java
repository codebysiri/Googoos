package com.mygg.mygg.service.impl;

import com.mygg.mygg.dao.MemberDAO;
import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Inject
    private SqlSession sqlSession;

    @Override
    public void register(MemberDTO memberDTO) {
        sqlSession.insert("MemberMapper.register", memberDTO);
    }

    @Override
    public Map<String, String> login(LoginDTO loginDTO) {
        return null;
    }
}
