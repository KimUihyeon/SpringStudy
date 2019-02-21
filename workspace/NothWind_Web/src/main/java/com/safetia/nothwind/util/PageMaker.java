package com.safetia.nothwind.util;

import org.springframework.stereotype.Repository;

@Repository
public class PageMaker {
	
	private int page;       // 현재페이지.
	private int perPageNum; // 한 페이지당 게시물.
	private int totalCount; // 총 페이지.
	private int startPage;  // 시작페이지.
	private int endPage;    // 마지막페이지.
	private boolean isPrev; // 이전 버튼 유무.
	private boolean isNext; // 다음 버튼 유무.
	
	
	private int displayPageNum = 10; // 페이징 컨트롤 갯수.
	
	
	private void CalcData() {
		this.endPage = (int)(Math.ceil(page/(double)displayPageNum)*displayPageNum);
		
		startPage = (endPage-displayPageNum) +1 ;

		int tempEndPage = (int)(Math.ceil( (double)totalCount / (double) perPageNum) );
		
		if (endPage>tempEndPage) {
			endPage = tempEndPage;
		}
		
		isPrev = startPage== 1 ? false : true;
		isNext = page * perPageNum >= totalCount ? false : true;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		CalcData();
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return isPrev;
	}

	public void setPrev(boolean isPrev) {
		this.isPrev = isPrev;
	}

	public boolean isNext() {
		return isNext;
	}

	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}

	//노출시킬필요 없음.
/*	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
*/
	public PageMaker() {
		this.page = 1;
		this.perPageNum = 10 ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<1) {
			page = 1; 
		}
		startPage = (page - 1) *perPageNum;
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	
	
}
