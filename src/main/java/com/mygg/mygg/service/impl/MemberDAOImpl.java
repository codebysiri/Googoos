package com.mygg.mygg.service.impl;

import com.mygg.mygg.dao.MemberDAO;
import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;

import javax.inject.Inject;

public class MemberDAOImpl implements MemberDAO {

    private static String NAMESPACE = "com.mygg.mygg.mybatis.mapper.MemberMapper";
    private final SqlSession sqlSession;

    @Inject
    public MemberDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void register(MemberVO memberVO) throws Exception {
        sqlSession.insert(NAMESPACE = ".register", memberVO);
    }

    @Override
    public MemberVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
    }
}
