package cn.ruizrui.gameforum.proxy;

import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.model.*;

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
	public boolean addCollection(int userId, String gameId) {
		return ru.addCollection(userId, gameId);
	}
	
	public List<CollectInfo> getCollectionList(int userId){
		if(!priority.equals("游客")) {
			return ru.getCollectionList(userId);
		}else {
			return null;
		}
	}
	
	public String cancelCollection(int userId, String gameId) {
		if(!priority.equals("游客")) {
			return ru.cancelCollection(userId, gameId);
		}else {
			return "请登录";
		}
	}
	
	public String cleanCollection(int userId) {
		if(!priority.equals("游客")) {
			return ru.cleanCollection(userId);
		}else {
			return "请登录";
		}
	}
	
	public List<RelationUser> getFollowUsers(int userId){
		if(!priority.equals("游客")) {
			return ru.getFollowUsers(userId);
		}else {
			return null;
		}
	}
	
	public String cancelFollow(int idolUserId, int fanUserId) {
		if(!priority.equals("游客")) {
			return ru.cancelFollow(idolUserId, fanUserId);
		}else {
			return "请登录";
		}
	}
	
	public List<RelationUser> getFanUsers(int userId){
		if(!priority.equals("游客")) {
			return ru.getFanUsers(userId);
		}else {
			return null;
		}
	}
	
	public String followUser(int idolUserId,int fanUserId) {
		if(!priority.equals("游客")) {
			return ru.followUser(idolUserId, fanUserId);
		}else {
			return "请登录";
		}
	}
	
	public List<MyComment> getCommentToMe(int userId){
		if(!priority.equals("游客")) {
			return ru.getCommentToMe(userId);
		}else {
			return null;
		}
	}
	public boolean commentGame(int userIdFrom, String gameId, String content) {
		return ru.commentGame(userIdFrom, gameId, content);
	}
	public boolean commentComment(String userName,int commentId,String content) {
		return ru.commentComment(userName, commentId, content);
	}
	public List<MyComment> getCommentFromMe(int userId){
		if(!priority.equals("游客")) {
			return ru.getCommentFromMe(userId);
		}else {
			return null;
		}
	}
	
	public String deleteCommentFromMe(int commentId) {
		if(!priority.equals("游客")) {
			return ru.deleteCommentFromMe(commentId);
		}else {
			return "请登录";
		}
	};
	
	public String cleanCommentFromMe(int userId) {
		if(!priority.equals("游客")) {
			return ru.cleanCommentFromMe(userId);
		}else {
			return "请登录";
		}
	}
	// 版主
	public String deleteGame(String gameName, String gameBelong) {
		if(!priority.equals("游客") && !priority.equals("用户")) {
			return ru.deleteGame(gameName, gameBelong);
		}else {
			return "仅管理员可以删除游戏";
		}
	}

	@Override
	public String publishGame(int userId, String userName, String gameName, String gameBelong, String gameType, String gameRelease,
							  String gameReleaseDate, String gameArrangeTime, String gamePlatform, String gameWebsite,
							  String gameLabel, String gameLanguage, float gameScore, Integer gameRaterNum, String gameImg) {
		if(!priority.equals("游客") && !priority.equals("用户")) {
			return ru.publishGame(userId, userName, gameName, gameBelong, gameType, gameRelease, gameReleaseDate,
					gameArrangeTime, gamePlatform, gameWebsite, gameLabel, gameLanguage, gameScore, gameRaterNum, gameImg);
		} else {
			return "仅管理员可以发布游戏";
		}
	}

	// 管理员权限
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
	
	public int getIOSGameNum() {
		if(priority.equals("管理员")) {
			return ru.getIOSGameNum();
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
	
	public List<User> getTotalUser(){
		if(priority.equals("管理员")) {
			return ru.getTotalUser();
		}else {
			return null;
		}
	}

	public List<RelationUser> getAllUsers(){
		if (priority.equals("管理员")) {
			return ru.getAllUsers();
		} else {
			return null;
		}
	}
	
	public String deleteUser(int userId) {
		if(priority.equals("管理员")) {
			return ru.deleteUser(userId);
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
