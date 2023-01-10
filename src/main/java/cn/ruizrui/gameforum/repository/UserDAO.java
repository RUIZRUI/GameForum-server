package cn.ruizrui.gameforum.repository;

import java.util.List;

import cn.ruizrui.gameforum.model.RelationUser;
import cn.ruizrui.gameforum.model.User;

public interface UserDAO {
	User getByName(String userName);
	int getUserId(String userName);
	boolean addUser(User ue);
	boolean updateUser(User ue);
	String getUserName(int userId);
	int getUserNumber();
	boolean setStatusOn(String userName);
	boolean setStatusDown(String userName);
	boolean deleteUser(int userId);
	boolean promoteUser(String userName);
	boolean setUserAvater(String userName,String imgUrl);
	List<User> getTotalUsers();
	List<RelationUser> getAllUsers();
	boolean addFansNumber(int userId);
	boolean reduceFansNumber(int userId);
	boolean addFollowNumber(int userId);
	boolean reduceFollowNumber(int userId);
	
	
}
