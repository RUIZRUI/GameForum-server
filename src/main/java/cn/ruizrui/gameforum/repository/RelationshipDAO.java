package cn.ruizrui.gameforum.repository;

import java.util.ArrayList;

import cn.ruizrui.gameforum.model.User;

public interface RelationshipDAO {
	public ArrayList<User> getMyFans(String userName);
	public ArrayList<User> getMyFollow(String userName);
	public boolean cancelFollow(String userName,String followedUserName);
	public boolean followUser(String userName,String fanUserName);
}
