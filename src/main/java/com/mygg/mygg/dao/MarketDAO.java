package com.mygg.mygg.dao;

import java.util.List;

import com.mygg.mygg.vo.MarketVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("marketDAO")
public class MarketDAO extends AbstractDAO {
    private static final Logger logger = LoggerFactory.getLogger(MarketDAO.class);

    // 쿼리 "namespace.id", 값
    // 리스트
    public List<MarketVO> marketList() throws Exception {

        @SuppressWarnings("unchecked")
        List<MarketVO> marketList = (List<MarketVO>) selectList("market.selectMarketList");

        return marketList;
    }

    // 상세보기
    public MarketVO serviceDetail(int serviceNo) throws Exception {
        return (MarketVO) select("market.selectServiceDetail", serviceNo);
    }

    // 등록
    public int serviceSave(MarketVO marketVO) throws Exception {
        return (int) insert("market.insertService", marketVO);
    }

    // 수정
    public int serviceUpdateSave(MarketVO serviceNo) throws Exception {
        return (int) update("market.serviceUpdate", serviceNo);
    }
}
