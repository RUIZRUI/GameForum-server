package cn.ruizrui.gameforum.entity;

import java.sql.Timestamp;

public class UserEntity {
private int user_id;
private String password;
private String priority;
private int fans_number;
private Timestamp logintime;
private String user_name;
private String mail;
private boolean status;
private String phone;
private String img;
private String sex;
private String birthdate;
public String update() {
	return "你关注的用户更新啦";
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirthdate() {
	return birthdate;
}
public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public int getFollow_number() {
	return follow_number;
}
public void setFollow_number(int follow_number) {
	this.follow_number = follow_number;
}
private int follow_number;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPriority() {
	return priority;
}
public void setPriority(String priority) {
	this.priority = priority;
}
public int getFans_number() {
	return fans_number;
}
public void setFans_number(int fans_number) {
	this.fans_number = fans_number;
}
public Timestamp getLogintime() {
	return logintime;
}
public void setLogintime(Timestamp logintime) {
	this.logintime = logintime;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public boolean getStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}
