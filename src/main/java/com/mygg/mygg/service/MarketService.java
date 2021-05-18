package com.mygg.mygg.service;

import com.mygg.mygg.vo.MarketVO;

import java.util.List;

public interface MarketService {

    // 서비스 마켓 리스트
    public List<MarketVO> marketList() throws Exception;

    // 서비스 글 저장(신규, 수정)
    public MarketVO serviceSave(MarketVO marketVO) throws Exception;

    // 서비스 상세보기
    public MarketVO serviceDetail(int serviceNo) throws Exception;

}