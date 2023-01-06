package cn.ruizrui.gameforum.proxy;

import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.model.CollectInfo;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.RelationUser;
import cn.ruizrui.gameforum.model.User;

public interface UserInterface {

	public String userLogin(String userName,String userPass);
	
	public String userRegister(String userName,String userPass,String userEmail,String userPhone);
	
	public User getUserData(String userName);
	
	public String setUserData(int userId,String userName,String userEmail,String userPhone,String userSex,String userBirthday);
	
	public String setUserAvater(String userName,String imgUrl);
	
	public List<CollectInfo> getCollectionList(int userId);

	public boolean addCollection(String userName,String gameName);
	
	public String cancelCollection(String userName,String gameName);
	
	public String cleanCollection(String userName);
	
	public List<RelationUser> getFollowUsers(int userId);
	
	public String  cancelFollow(String userName,String followedUserName);
	
	public List<RelationUser> getFanUsers(int userId);
	
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
	
	public int getIOSGameNum();
	
	public int getOnlineGameNum();
	
	public int getSingleGameNum();
	
	public ArrayList<cn.ruizrui.gameforum.model.User> getTotalUser();
	
	public String deleteUser(String userName);
	
	public String addObserver(String userName);
	
	public String removeObserver(String userName);
	
	public String inform();
}
