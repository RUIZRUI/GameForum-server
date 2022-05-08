package cn.ruizrui.gameforum.proxyPattern;

import java.util.ArrayList;

import cn.ruizrui.gameforum.DAO.impl.CollectDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.LoginLogDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.RelationShipDAOImp;
import cn.ruizrui.gameforum.DAO.impl.UserDAOImpl;
import cn.ruizrui.gameforum.entity.CollectInfo;
import cn.ruizrui.gameforum.entity.Comment;
import cn.ruizrui.gameforum.entity.UserEntity;
import cn.ruizrui.gameforum.tools.JudgeGame;

public class RealUser implements User{
	ArrayList<UserEntity> fans=new ArrayList<UserEntity>();
	RelationShipDAOImp ri=new RelationShipDAOImp();
	CollectDAOImpl ci=new CollectDAOImpl();
	CommentDAOImpl cmi=new CommentDAOImpl();
	UserDAOImpl ui=new UserDAOImpl();
	JudgeGame jg=new JudgeGame();
	LoginLogDAOImpl li=new LoginLogDAOImpl();
	
	public String userLogin(String userName,String userPass) {
		
		UserEntity ue=new UserEntity();
		ue=ui.getByName(userName);
		if(userPass.equals(ue.getPassword())){
			if(ue.getStatus()==true) {
				return "已登录";
			}
			ui.setStatusOn(userName);
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
	
		UserEntity ue=new UserEntity();
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

	public UserEntity getUserData(String userName){
		UserEntity ue=ui.getByName(userName);
		return ue;
    }
	public boolean addCollection(String userName,String gameName) {
		return ci.addCollection(userName, gameName);
	}
	

	public	String setUserData(int userId,String userName,String userEmail,String userPhone,String userSex,String userBirthday){
		String oldName=ui.getUserName(userId);
		UserEntity ue=ui.getByName(oldName);
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

	public ArrayList<CollectInfo> getCollectionList(String userName){
		ArrayList<CollectInfo> collections=new ArrayList<CollectInfo>();
		collections=ci.getCollectionByName(userName);
		return collections;
	}
	
	
	public String cancelCollection(String userName,String gameName){
		ci.cancelCollection(userName,gameName);
		return "success";
		}
	
	public String cleanCollection(String userName){
		ci.clearCollection(userName);
		return "success";
	}
	public boolean commentGame(String userName,String gameName,String content) {
		return cmi.commentGame(userName, gameName, content);
	}
	public boolean commentComment(String userName,int commentId,String content) {
		return cmi.commentComment(userName, commentId, content);
	}

	public ArrayList<UserEntity> getFollowUsers(String userName){
		return ri.getMyFollow(userName);
		}
	
	public  String cancelFollow(String userName,String fanUserName){
		ri.cancelFollow(userName,fanUserName);
		ui.reduceFollowNumber(userName);
		ui.reduceFansNumber(fanUserName);
		return "success";
	}

	public ArrayList<UserEntity> getFanUsers(String userName){
		this.fans=ri.getMyFans(userName);
		return fans;
	}

	public  String followUser(String userName,String fanUserName){
		ri.followUser(userName,fanUserName);
		ui.addFollowNumber(userName);
		ui.addFansNumber(fanUserName);
		return "success";
	}
	
	
	public ArrayList<Comment> getCommentToMe(String userName) {
		return cmi.getCommentsToMe(userName);
	}
	
	public ArrayList<Comment> getCommentFromMe(String userName) {
		return cmi.getCommentsFromMe(userName);
	}
	
	public String deleteCommentFromMe(int commentId,String userName) {
		if(cmi.deleteComment(commentId, userName)) {
		return "success";
		}else {
			return "false";
		}
	}
	
	public String cleanCommentFromMe(String userName) {
		cmi.clearComment(userName);
		return "success";
	}

	public String setUserAvater(String userName, String imgUrl) {
		
		ui.setUserAvater(userName, imgUrl);
		return "success";
	}

	@Override

	public String deleteGame(String gameName, int belong) {

		return jg.deleteGame(gameName, belong);
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
			num+=jg.getGameNum(i);
		}
		return num;
	}

	@Override

	public int getAndroidGameNum() {

		return jg.getGameNum(1);
	}

	@Override

	public int getIosGameNum() {

		return jg.getGameNum(2);
	}

	@Override

	public int getOnlineGameNum() {

		return jg.getGameNum(3);
	}

	@Override

	public int getSingleGameNum() {

		return jg.getGameNum(0);
	}

	@Override

	public ArrayList<UserEntity> getTotalUser() {

		return ui.getTotalUsers();
	}

	@Override

	public String deleteUser(String userName) {
		 ui.deleteUser(userName);
		 return "success";
	}
	@Override
	public String addObserver(String userName) {
		UserEntity ue=ui.getByName(userName);
		fans.add(ue);
		return "success";
	}
	
	@Override
	public String removeObserver(String userName) {
		UserEntity ue=ui.getByName(userName);
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
