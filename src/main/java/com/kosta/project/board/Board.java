package com.kosta.project.board;

import java.sql.Date;

public class Board {
	private long boardId;
	private String boardTitle;
	private String boardContext;
	private int wishCount;
	private int price;
	private Date reg_date;
	private String boardStatus;
	private int joinNumber;
	private int userId;
	private int category;
	private int imageId;
	
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContext() {
		return boardContext;
	}
	public void setBoardContext(String boardContext) {
		this.boardContext = boardContext;
	}
	public int getWishCount() {
		return wishCount;
	}
	public void setWishCount(int wishCount) {
		this.wishCount = wishCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
	public int getJoinNumber() {
		return joinNumber;
	}
	public void setJoinNumber(int joinNumber) {
		this.joinNumber = joinNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getimageId() {
		return category;
	}
	public void setimageId(int imageId) {
		this.imageId = imageId;
	}
	
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContext=" + boardContext
				+ ", wishCount=" + wishCount + ", price=" + price + ", reg_date=" + reg_date + ", boardStatus="
				+ boardStatus + ", joinNumber=" + joinNumber + ", userId=" + userId + ", category=" + category + "]";
	}
	
	
	
	
}
