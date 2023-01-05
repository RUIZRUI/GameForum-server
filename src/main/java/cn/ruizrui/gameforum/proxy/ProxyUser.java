package cn.ruizrui.gameforum.proxy;

import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.model.CollectInfo;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.User;

public class ProxyUser implements UserInterface {
	String priority;
	RealUser ru=new RealUser();
	public ProxyUser(String priority) {
		this.priority=priority;
	}
	public String userLogin(String userName,String userPass) {
	return ru.userLogin(userName, userPass);
}
	
	public String userRegister(String userName,String userPass,String userEmail,String userPhone) {
		return ru.userRegister(userName, userPass, userEmail, userPhone);
	}
	//�û����Բ鿴
	public User getUserData(String userName) {
		if(!priority.equals("游客")) {
		return ru.getUserData(userName);
		}else 
			return null;
	}
	
	public String setUserData(int userId,String userName,String userEmail,String userPhone,String userSex,String userBirthday) {
		if(!priority.equals("游客")) {
			return ru.setUserData(userId, userName, userEmail, userPhone, userSex, userBirthday);
		}else {
			return "请登录";
		}
	}
	
	public String setUserAvater(String userName,String imgUrl) {
		if(!priority.equals("游客")) {
			return ru.setUserAvater(userName, imgUrl);
		}else {
			return "请登录";
		}
	}
	public boolean addCollection(String userName,String gameName) {
		return ru.addCollection(userName, gameName);
	}
	
	public List<CollectInfo> getCollectionList(int userId){
		if(!priority.equals("游客")) {
			return ru.getCollectionList(userId);
		}else {
			return null;
		}
	}
	
	public String cancelCollection(String userName,String gameName) {
		if(!priority.equals("游客")) {
			return ru.cancelCollection(userName, gameName);
		}else {
			return "请登录";
		}
	}
	
	public String cleanCollection(String userName) {
		if(!priority.equals("游客")) {
			return ru.cleanCollection(userName);
		}else {
			return "请登录";
		}
	}
	
	public ArrayList<User> getFollowUsers(String userName){
		if(!priority.equals("游客")) {
			return ru.getFollowUsers(userName);
		}else {
			return null;
		}
	}
	
	public String  cancelFollow(String userName,String followedUserName) {
		if(!priority.equals("游客")) {
			return ru.cancelFollow(userName, followedUserName);
		}else {
			return "请登录";
		}
	}
	
	public ArrayList<User> getFanUsers(String userName){
		if(!priority.equals("游客")) {
			return ru.getFanUsers(userName);
		}else {
			return null;
		}
	}
	
	public String followUser(String userName,String fanUserName) {
		if(!priority.equals("游客")) {
			return ru.followUser(userName, fanUserName);
		}else {
			return "请登录";
		}
	}
	
	public ArrayList<Comment> getCommentToMe(String userName){
		if(!priority.equals("游客")) {
			return ru.getCommentToMe(userName);
		}else {
			return null;
		}
	}
	public boolean commentGame(String userName,String gameName,String content) {
		return ru.commentGame(userName, gameName, content);
	}
	public boolean commentComment(String userName,int commentId,String content) {
		return ru.commentComment(userName, commentId, content);
	}
	public ArrayList<Comment> getCommentFromMe(String userName){
		if(!priority.equals("游客")) {
			return ru.getCommentFromMe(userName);
		}else {
			return null;
		}
	}
	
	public String deleteCommentFromMe(int commentId,String userName) {
		if(!priority.equals("游客")) {
			return ru.deleteCommentFromMe(commentId, userName);
		}else {
			return "请登录";
		}
	};
	
	public String cleanCommentFromMe(String userName) {
		if(!priority.equals("游客")) {
			return ru.cleanCommentFromMe(userName);
		}else {
			return "请登录";
		}
	}
	//�����еĹ���
	public String deleteGame(String gameName,int belong) {
		if(!priority.equals("游客")&&!priority.equals("用户")) {
			return ru.deleteGame(gameName, belong);
		}else {
			return "请登录";
		}
	}
	
	//δʵ��ɾ����������
	
	//ϵͳ����Ա
	public int getRegisterPeopleNum() {
		if(priority.equals("管理员")) {
			return ru.getRegisterPeopleNum();
		}else {
			return -1;
		}
	}
	
	public int oneDayPeopleNum() {
		if(priority.equals("管理员")) {
			return ru.oneDayPeopleNum();
		}else {
			return -1;
		}
	}
	
	public int oneMonthPeopleNum() {
		if(priority.equals("管理员")) {
			return ru.oneMonthPeopleNum();
		}else {
			return -1;
		}
	}
	
	public int getAllGameNum() {
		if(priority.equals("管理员")) {
			return ru.getAllGameNum();
		}else {
			return -1;
		}
	}
	
	public int getAndroidGameNum() {
		if(priority.equals("管理员")) {
			return ru.getAndroidGameNum();
		}else {
			return -1;
		}
	}
	
	public int getIosGameNum() {
		if(priority.equals("管理员")) {
			return ru.getIosGameNum();
		}else {
			return -1;
		}
	}
	
	public int getOnlineGameNum() {
		if(priority.equals("管理员")) {
			return ru.getOnlineGameNum();
		}else {
			return -1;
		}
	}
	
	public int getSingleGameNum() {
		if(priority.equals("管理员")) {
			return ru.getSingleGameNum();
		}else {
			return -1;
		}
	}
	
	public ArrayList<User> getTotalUser(){
		if(priority.equals("管理员")) {
			return ru.getTotalUser();
		}else {
			return null;
		}
	}
	
	public String deleteUser(String userName) {
		if(priority.equals("管理员")) {
			return ru.deleteUser(userName);
		}else {
			return "权限不够";
		}
	}
	@Override
	public String addObserver(String userName) {
		// TODO 自动生成的方法存根
		return ru.addObserver(userName);
	}
	@Override
	public String removeObserver(String userName) {
		// TODO 自动生成的方法存根
		return ru.removeObserver(userName);
	}
	@Override
	public String inform() {
		// TODO 自动生成的方法存根
		return ru.inform();
	}
}
