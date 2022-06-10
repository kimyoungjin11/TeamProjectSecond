package com.kosta.project.member.vo;

import java.sql.Date;

public class Member {
  private  String userId;
  private  String userName;
  private  String userPassword;
  private  String nickName;
  private  Date signDate;
  private  String phone;
  private String userRole;
public Member() {
	super();
	// TODO Auto-generated constructor stub
}
public Member(String userId, String userName, String userPassword, String nickName, Date signDate, String phone,
		String userRole) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userPassword = userPassword;
	this.nickName = nickName;
	this.signDate = signDate;
	this.phone = phone;
	this.userRole = userRole;
}

public Member(String userId, String userPassword, String phone) {
	super();
	this.userId = userId;
	this.userPassword = userPassword;
	this.phone = phone;
}
public Member(String userid) {
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
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public Date getSignDate() {
	return signDate;
}
public void setSignDate(Date signDate) {
	this.signDate = signDate;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
@Override
public String toString() {
	return "Member [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", nickName="
			+ nickName + ", signDate=" + signDate + ", phone=" + phone + ", userRole=" + userRole + "]";
}

  
  

}
