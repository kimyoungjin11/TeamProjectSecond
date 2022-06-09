package com.kosta.project.product;

import java.sql.Date;

public class Product {
	private int productId;
	private String productTitle;
	private String productContent;
	private int wishCount;
	private int viewCount;
	private int price;
	private Date reg_date;
	private String productStatus;
	private int joinNumber;
	private String userId;
	private int category;
	private int imageId;
	
	public Product() {
		
	}
	

	public Product(int productId, String productTitle, String productContent, int wishCount, int viewCount, int price, Date reg_date,
			String productStatus, int joinNumber, String userId, int category, int imageId) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productContent = productContent;
		this.viewCount = viewCount;
		this.wishCount = wishCount;
		this.price = price;
		this.reg_date = reg_date;
		this.productStatus = productStatus;
		this.joinNumber = joinNumber;
		this.userId = userId;
		this.category = category;
		this.imageId = imageId;
	}
	public int getproductId() {
		return productId;
	}
	public void setproductId(int productId) {
		this.productId = productId;
	}
	public String getproductTitle() {
		return productTitle;
	}
	public void setproductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getproductContent() {
		return productContent;
	}
	public void setproductContent(String productContent) {
		this.productContent = productContent;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	
	public int getViewCount() {
		return viewCount;
	}


	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}


	@Override
	public String toString() {

		"product [ productId = " + productId + ", productTitle=" + productTitle + ", productContent=" + productContent
				+ ", wishCount=" + wishCount + ", price=" + price + ", reg_date=" + reg_date + ", productStatus="
				+ productStatus + ", joinNumber=" + joinNumber + ", userId=" + userId + ", category=" + category + "]";
	}
	
	
	
	
}
