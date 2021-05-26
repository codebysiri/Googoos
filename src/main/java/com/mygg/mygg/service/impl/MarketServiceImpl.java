package com.mygg.mygg.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mygg.mygg.dao.MarketDAO;
import com.mygg.mygg.service.MarketService;
import com.mygg.mygg.vo.MarketVO;

@Service("marketService")
public class MarketServiceImpl implements MarketService {
	private static final Logger logger = LoggerFactory.getLogger(MarketDAO.class);

	// Dao와 연결
	@Resource(name="marketDAO")
	private MarketDAO marketDAO;

	// 리스트
	@Override
	public List<MarketVO> marketList() throws Exception {

		List<MarketVO> marketList = marketDAO.marketList();

		return marketList;
	}

	// 서비스 글 올리기
	@Override
	public MarketVO serviceSave(MarketVO marketVO) throws Exception {

		// int 타입의 resultCnt변수 작업처리 결과수 1건이 넘어오면 1 3건이 넘어오면 3이 담겨진다.
		int resultCnt = 0;

		// 작업구분 (I:신규등록 | U:수정)
		try {
			// 등록해서 넘어온게 marketVO 구분타입의 get구분이 I이면
			if("I".equals(marketVO.getGubun())) {
				resultCnt = marketDAO.serviceSave(marketVO);
			}
			// 등록해서 넘어온게 marketVO 구분타입의 get구분이 U이거나 다른거 일때.
			else {
				resultCnt = marketDAO.serviceUpdateSave(marketVO);
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
		// setReturnCnt 작업처리 결과건수 변수를 가져오다.
		marketVO.setReturnCnt(resultCnt);

		return marketVO;
	}

	// 서비스 상세보기
	@Override
	public MarketVO serviceDetail(int serviceNo) throws Exception {

		return marketDAO.serviceDetail(serviceNo);
	}

	// 서비스 삭제하기
	@Override
	@Transactional
	public MarketVO serviceDelete(MarketVO marketVO) throws Exception {
		// 삭제 건수
		int returnCnt = marketDAO.serviceDelete(marketVO);

		marketVO.setReturnCnt(returnCnt);

		return marketVO;
	}
}