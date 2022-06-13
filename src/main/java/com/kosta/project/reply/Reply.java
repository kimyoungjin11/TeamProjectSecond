package com.kosta.project.reply;

import java.sql.Date;

public class Reply {
	
	private int reply_ID;
	private Date reply_DATE;
	private int product_ID;
	private String user_ID;
	
	
	
	
	
	public Reply(int reply_ID, Date reply_DATE, int product_ID, String user_ID) {
		super();
		this.reply_ID = reply_ID;
		this.reply_DATE = reply_DATE;
		this.product_ID = product_ID;
		this.user_ID = user_ID;
	}
	
	
	
	public Reply() {
		super();
	}



	public int getReply_ID() {
		return reply_ID;
	}
	public void setReply_ID(int reply_ID) {
		this.reply_ID = reply_ID;
	}
	public Date getReply_DATE() {
		return reply_DATE;
	}
	public void setReply_DATE(Date reply_DATE) {
		this.reply_DATE = reply_DATE;
	}
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}



	@Override
	public String toString() {
		return "Reply [reply_ID=" + reply_ID + ", reply_DATE=" + reply_DATE + ", product_ID=" + product_ID
				+ ", user_ID=" + user_ID + "]";
	}

	
	
}
