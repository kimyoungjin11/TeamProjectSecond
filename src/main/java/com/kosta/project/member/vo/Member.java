package com.kosta.project.member.vo;

public class Member {
  private  String userId;
  private  String userName;
  private  String userPassword;
  private  String phone;
  
  
  
  
public Member(String userId, String userName, String userPassword, String phone) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userPassword = userPassword;
	this.phone = phone;
}
public Member() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "Member [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", phone=" + phone
			+ "]";
}
 
  
}
