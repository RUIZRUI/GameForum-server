package cn.ruizrui.gameforum.repository;

import java.util.ArrayList;

import cn.ruizrui.gameforum.model.User;

public interface UserDAO {
	public User getByName(String userName);
	public int getUserId(String userName);
	public boolean addUser(User ue);
	public boolean updateUser(User ue);
	public String getUserName(int userId);
	public int getUserNumber();
	public boolean setStatusOn(String userName);
	public boolean setStatusDown(String userName);
	public boolean deleteUser(String userName);
	public boolean promoteUser(String userName);
	public boolean setUserAvater(String userName,String imgUrl);
	public ArrayList<User> getTotalUsers();
	public boolean addFansNumber(String userName);
	public boolean reduceFansNumber(String userName);
	public boolean addFollowNumber(String userName);
	public boolean reduceFollowNumber(String userName);
	
	
}
