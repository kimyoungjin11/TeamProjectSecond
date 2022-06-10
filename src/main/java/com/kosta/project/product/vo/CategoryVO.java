package com.kosta.project.product.vo;

public class CategoryVO {
	int category_id;
	String category_name;
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryVO [category_id=").append(category_id).append(", category_name=").append(category_name)
				.append("]");
		return builder.toString();
	}
	
	public CategoryVO(){
	}
	
	public CategoryVO(int category_id, String category_name) {
		this.category_id = category_id;
		this.category_name = category_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
