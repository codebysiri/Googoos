package com.mygg.mygg.service;

import java.util.List;

import com.mygg.mygg.vo.MarketVO;

public interface MarketService {

	// 서비스 마켓 리스트
	public List<MarketVO> marketList() throws Exception;

	// 서비스 글 저장(신규, 수정)
	public MarketVO serviceSave(MarketVO marketVO) throws Exception;

	// 서비스 상세보기
	public MarketVO serviceDetail(int serviceNo) throws Exception;

	// 서비스 삭제하기
	public MarketVO serviceDelete(MarketVO marketVO) throws Exception;

	// 찜 추가
	public int jmSave(MarketVO marketVO) throws Exception;

	// 장소, 아이디

}