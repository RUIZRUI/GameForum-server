package cn.ruizrui.gameforum.proxy;

import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.model.*;
import cn.ruizrui.gameforum.repository.BaseGameDao;
import cn.ruizrui.gameforum.repository.impl.*;
import cn.ruizrui.gameforum.helper.GameHelper;

public class RealUser implements UserInterface {

	List<User> fans = new ArrayList<User>();
	RelationShipDAOImp ri = new RelationShipDAOImp();
	CollectDAOImpl ci = new CollectDAOImpl();
	CommentDAOImpl cmi = new CommentDAOImpl();
	UserDAOImpl ui = new UserDAOImpl();
	GameHelper gameHelper = new GameHelper();
	LoginLogDAOImpl li = new LoginLogDAOImpl();
	
	public String userLogin(String userName,String userPass) {
		
		User ue=new User();
		ue=ui.getByName(userName);
		if(userPass.equals(ue.getPassword())){
			if(ue.getStatus()==true) {
				return "已登录";
			}
			// ui.setStatusOn(userName);
			return "success";
	}
		else if(ue.getUser_name()==null){
			return "没有该用户名";
		}else if(!ue.getPassword().equals(userPass)){
			return "密码错误请重新输入";
		}else {
			return "登录失败";
		}
	}

	@Override
	public String userRegister(String userName, String userPass, String userEmail, String userPhone) {
	
		User ue=new User();
		ue.setUser_name(userName);
		ue.setPassword(userPass);
		if(userEmail!=null){
			ue.setMail(userEmail);
		}else{
			ue.setMail("未设置");
		}
		if(userPhone!=null){
			ue.setPhone(userPhone);
		}else{
			ue.setPhone("未设置");
		}	
		ui.addUser(ue);
		return "success";
	}

	public User getUserData(String userName){
		User ue=ui.getByName(userName);
		return ue;
    }
	public boolean addCollection(int userId, String gameId) {
		return ci.addCollection(userId, gameId);
	}
	

	public	String setUserData(int userId,String userName,String userEmail,String userPhone,String userSex,String userBirthday){
		String oldName=ui.getUserName(userId);
		User ue=ui.getByName(oldName);
		if(userName!=null){
			ue.setUser_name(userName);
		}
		if(userEmail!=null){
			ue.setMail(userEmail);
		}
		if(userPhone!=null){
			ue.setPhone(userPhone);
		}
		if(userSex!=null){
			if(!userSex.equals("男")&&!userSex.equals("女")){
				return "设置错误";
			}
			ue.setSex(userSex);
		}
		if(userBirthday!=null){
			ue.setBirthdate(userBirthday);;
		}
		ui.updateUser(ue);
		return "success";
		}

	public List<CollectInfo> getCollectionList(int userId){
		List<CollectInfo> collections = new ArrayList<CollectInfo>();
		collections = ci.getCollectionByUserId(userId);
		return collections;
	}
	
	
	public String cancelCollection(int userId, String gameId){
		return ci.cancelCollection(userId, gameId) ? "success" : "取消收藏游戏失败";
	}
	
	public String cleanCollection(int userId){
		return ci.clearCollection(userId) ? "success" : "清空收藏游戏失败";
	}

	public boolean commentGame(int userIdFrom, String gameId, String content) {
		return cmi.commentGame(userIdFrom, gameId, content);
	}
	public boolean commentComment(String userName,int commentId,String content) {
		return cmi.commentComment(userName, commentId, content);
	}

	public List<RelationUser> getFollowUsers(int userId){
		return ri.getMyFollow(userId);
	}
	
	public  String cancelFollow(int idolUserId, int fanUserId){
		boolean result1 = ri.cancelFollow(idolUserId, fanUserId);
		if (result1 == false) {
			return "取消关注用户失败，cancelFollow: " + result1;
		}
		boolean result2 = ui.reduceFollowNumber(fanUserId);
		boolean result3 = ui.reduceFansNumber(idolUserId);
		if (result1 && result2 && result3) {
			return "success";
		} else {
			return "取消关注用户失败，cancelFollow: " + result1 + ", reduceFollowNumber: " + result2 + ", reduceFansNumber: " + result3;
		}

	}

	public List<RelationUser> getFanUsers(int userId){
		return ri.getMyFans(userId);
	}

	public  String followUser(int idolUserId, int fanUserId){
		if (ri.isExistFollow(idolUserId, fanUserId)) {
			return "您已关注此用户";
		}
		boolean result1 = ri.followUser(idolUserId, fanUserId);
		if (result1 == false) {
			return "关注用户失败，followUser: " + result1;
		}
		boolean result2 = ui.addFollowNumber(fanUserId);
		boolean result3 = ui.addFansNumber(idolUserId);
		if (result1 && result2 && result3) {
			return "success";
		} else {
			return "关注用户失败，followUser: " + result1 + ", addFollowNumber: " + result2 + ", addFansNumber: " + result3;
		}
	}
	
	
	public List<MyComment> getCommentToMe(int userId) {
		return cmi.getCommentsToMe(userId);
	}
	
	public List<MyComment> getCommentFromMe(int userId) {
		return cmi.getCommentsFromMe(userId);
	}
	
	public String deleteCommentFromMe(int commentId) {
		if(cmi.deleteComment(commentId)) {
			return "success";
		}else {
			return "删除评论失败";
		}
	}
	
	public String cleanCommentFromMe(int userId) {
		return cmi.clearComment(userId) ? "success" : "清空评论失败";
	}

	public String setUserAvater(String userName, String imgUrl) {
		
		ui.setUserAvater(userName, imgUrl);
		return "success";
	}

	@Override

	public String deleteGame(String gameName, String gameBelong) {
		return GameHelper.deleteGame(gameName, gameBelong);
	}

	@Override
	public String publishGame(int userId, String userName, String gameName, String gameBelong, String gameType, String gameRelease,
							  String gameReleaseDate, String gameArrangeTime, String gamePlatform, String gameWebsite,
							  String gameLabel, String gameLanguage, float gameScore, Integer gameRaterNum, String gameImg){
		return GameHelper.publishGame(gameName, gameBelong, gameType, gameRelease, gameReleaseDate, gameArrangeTime,
				gamePlatform, gameWebsite, gameLabel, gameLanguage, gameScore, gameRaterNum, gameImg);
	}

	@Override
	public int getRegisterPeopleNum() {

		return ui.getUserNumber();
	}
	//
	@Override
	public int oneDayPeopleNum() {

		return li.getDay();
	}
	//
	@Override
	public int oneMonthPeopleNum() {

		return li.getMonth();
	}

	@Override
	//�õ�����Ϸ��
	public int getAllGameNum() {

		int num=0;
		for(int i=0;i<4;i++) {
			num += gameHelper.getGameNum(i);
		}
		return num;
	}

	@Override

	public int getAndroidGameNum() {

		return gameHelper.getGameNum(1);
	}

	@Override

	public int getIOSGameNum() {

		return gameHelper.getGameNum(2);
	}

	@Override

	public int getOnlineGameNum() {

		return gameHelper.getGameNum(3);
	}

	@Override

	public int getSingleGameNum() {

		return gameHelper.getGameNum(0);
	}

	@Override
	public List<User> getTotalUser() {
		return ui.getTotalUsers();
	}

	@Override
	public List<RelationUser> getAllUsers(){
		return ui.getAllUsers();
	}

	@Override
	public String deleteUser(int userId) {
		 return ui.deleteUser(userId) ? "success" : "删除用户失败";
	}
	@Override
	public String addObserver(String userName) {
		User ue=ui.getByName(userName);
		fans.add(ue);
		return "success";
	}
	
	@Override
	public String removeObserver(String userName) {
		User ue=ui.getByName(userName);
		fans.remove(ue);
		return "success";
	}

	@Override
	public String inform() {
		for(int i=0;i<fans.size();i++) {
			 fans.get(i).update();
		}
		return "success";
	}

}
