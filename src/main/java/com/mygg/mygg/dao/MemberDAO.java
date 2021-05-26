package com.mygg.mygg.dao;

import com.mygg.mygg.dto.LoginDTO;
import com.mygg.mygg.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberDAO {

    void register(MemberVO memberVO) ;
    Map<String,String> login(LoginDTO loginDTO) ;
}
