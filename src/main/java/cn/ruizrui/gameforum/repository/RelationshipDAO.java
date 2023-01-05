package cn.ruizrui.gameforum.repository;

import java.util.List;

import cn.ruizrui.gameforum.model.RelationUser;

public interface RelationshipDAO {
	public List<RelationUser> getMyFans(int userId);
	public List<RelationUser> getMyFollow(int userId);
	public boolean cancelFollow(String userName,String followedUserName);
	public boolean followUser(String userName,String fanUserName);
}
