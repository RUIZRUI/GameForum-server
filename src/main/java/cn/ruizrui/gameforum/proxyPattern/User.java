package cn.ruizrui.gameforum.proxyPattern;

import java.util.ArrayList;

import cn.ruizrui.gameforum.entity.CollectInfo;
import cn.ruizrui.gameforum.entity.Comment;
import cn.ruizrui.gameforum.entity.UserEntity;

public interface User {
	public boolean addCollection(String userName,String gameName);
	public String userLogin(String userName,String userPass);
	
	public String userRegister(String userName,String userPass,String userEmail,String userPhone);
	
	public UserEntity getUserData(String userName);
	
	public String setUserData(int userId,String userName,String userEmail,String userPhone,String userSex,String userBirthday);
	
	public String setUserAvater(String userName,String imgUrl);
	
	public ArrayList<CollectInfo> getCollectionList(String userName);
	
	public String cancelCollection(String userName,String gameName);
	
	public String cleanCollection(String userName);
	
	public ArrayList<UserEntity> getFollowUsers(String userName);
	
	public String  cancelFollow(String userName,String followedUserName);
	
	public ArrayList<UserEntity> getFanUsers(String userName);
	
	public String followUser(String userName,String fanUserName);
	
	public ArrayList<Comment> getCommentToMe(String userName);
	
	public ArrayList<Comment> getCommentFromMe(String userName);
	
	public String deleteCommentFromMe(int commentId,String userName);
	
	public String cleanCommentFromMe(String userName);
	
	//版主
	public String deleteGame(String gameName,int belong);
	
	

	
	//管理员
	public int getRegisterPeopleNum();
	
	public int oneDayPeopleNum();
	
	public int oneMonthPeopleNum();
	
	public int getAllGameNum();
	
	public int getAndroidGameNum();
	
	public int getIosGameNum();
	
	public int getOnlineGameNum();
	
	public int getSingleGameNum();
	
	public ArrayList<UserEntity> getTotalUser();
	
	public String deleteUser(String userName);
	
	public String addObserver(String userName);
	
	public String removeObserver(String userName);
	
	public String inform();
}
