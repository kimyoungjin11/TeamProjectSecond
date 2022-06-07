package com.kosta.project.product;

import java.sql.Date;

public class Product {
	private long productId;
	private String productTitle;
	private String productContext;
	private int wishCount;
	private int price;
	private Date reg_date;
	private String productStatus;
	private int joinNumber;
	private int userId;
	private int category;
	private int imageId;
	
	
	public long getproductId() {
		return productId;
	}
	public void setproductId(long productId) {
		this.productId = productId;
	}
	public String getproductTitle() {
		return productTitle;
	}
	public void setproductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getproductContext() {
		return productContext;
	}
	public void setproductContext(String productContext) {
		this.productContext = productContext;
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
	public String getproductStatus() {
		return productStatus;
	}
	public void setproductStatus(String productStatus) {
		this.productStatus = productStatus;
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
		return "product [productId=" + productId + ", productTitle=" + productTitle + ", productContext=" + productContext
				+ ", wishCount=" + wishCount + ", price=" + price + ", reg_date=" + reg_date + ", productStatus="
				+ productStatus + ", joinNumber=" + joinNumber + ", userId=" + userId + ", category=" + category + "]";
	}
	
	
	
	
}
