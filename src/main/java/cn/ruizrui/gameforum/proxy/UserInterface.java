package cn.ruizrui.gameforum.proxy;

import java.util.List;

import cn.ruizrui.gameforum.model.*;

public interface UserInterface {

	public String userLogin(String userName,String userPass);
	
	public String userRegister(String userName,String userPass,String userEmail,String userPhone);
	
	public User getUserData(String userName);
	
	public String setUserData(int userId,String userName,String userEmail,String userPhone,String userSex,String userBirthday);
	
	public String setUserAvater(String userName,String imgUrl);
	
	public List<CollectInfo> getCollectionList(int userId);

	public boolean addCollection(int userId, String gameId);
	
	public String cancelCollection(int userId, String gameId);
	
	public String cleanCollection(int userId);
	
	public List<RelationUser> getFollowUsers(int userId);
	
	public String cancelFollow(int idolUserId, int fanUserId);
	
	public List<RelationUser> getFanUsers(int userId);
	
	public String followUser(int idolUserId, int fanUserId);
	
	public List<MyComment> getCommentToMe(int userId);
	
	public List<MyComment> getCommentFromMe(int userId);
	
	public String deleteCommentFromMe(int commentId);
	
	public String cleanCommentFromMe(int userId);

	public boolean commentGame(int userIdFrom, String gameId, String content);
	
	//版主
	public String deleteGame(String gameName, String gameBelong);

	public String publishGame(int userId, String userName, String gameName, String gameBelong, String gameType, String gameRelease,
							  String gameReleaseDate, String gameArrangeTime, String gamePlatform, String gameWebsite,
							  String gameLabel, String gameLanguage, float gameScore, Integer gameRaterNum, String gameImg);
	
	

	
	//管理员
	public int getRegisterPeopleNum();
	
	public int oneDayPeopleNum();
	
	public int oneMonthPeopleNum();
	
	public int getAllGameNum();
	
	public int getAndroidGameNum();
	
	public int getIOSGameNum();
	
	public int getOnlineGameNum();
	
	public int getSingleGameNum();
	
	public List<User> getTotalUser();

	public List<RelationUser> getAllUsers();
	
	public String deleteUser(int userId);
	
	public String addObserver(String userName);
	
	public String removeObserver(String userName);
	
	public String inform();
}
