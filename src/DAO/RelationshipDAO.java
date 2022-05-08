package DAO;

import java.util.ArrayList;

import entity.UserEntity;

public interface RelationshipDAO {
	public ArrayList<UserEntity> getMyFans(String userName);
	public ArrayList<UserEntity> getMyFollow(String userName);
	public boolean cancelFollow(String userName,String followedUserName);
	public boolean followUser(String userName,String fanUserName);
}
