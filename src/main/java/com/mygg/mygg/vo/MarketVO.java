package com.mygg.mygg.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

// 매퍼에서 service_no이면 VO에서는 serviceNo 카멜형식!
@Getter
@Setter
@ToString
public class MarketVO {

	private int serviceNo;			// 서비스번호PK
	private int type;				// 서비스타입(숫자)
	private String typeNm;			// 서비스타입(글자)
	private String title;			// 제목
	private String content;			// 내용
	private String image;			// 사진
	private Timestamp regDate;		// 등록일시
	private Timestamp updateDate;	// 수정일시
	private String location;		// 장소
	private int id;					// 작성자 pk값(찜에도 쓰임)
	private String nickname;		// 작성자 닉네임(상세보기에서 마이페이지로이동)
	private String category;		// 카테고리
	private String[] categorys;		// 카테고리들 담는곳
	private int rvState;			// 예약상태
	private int chState;			// 채팅상태
	private int svState;			// 등록자의 매물상태

	private int jmState;			// 찜하기(인기정도)
	private int jmId;				// 사용자 ID 찜
	private int jmService;			// 서비스 번호 찜
	private String jmTitle;			// 서비스 제목이랑 조인
	private int price;				// 가격

	private String gubun;			// 저장&수정 작업을 구분하기 위한 변수
	private String jmGubun;			// 찜구분
	private int returnCnt;			// 작업처리 결과건수(1건이면 1받고, 2건이면 2받고)

}