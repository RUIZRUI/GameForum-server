package cn.ruizrui.gameforum.repository;

import java.util.List;

import cn.ruizrui.gameforum.model.RelationUser;

public interface RelationshipDAO {
	List<RelationUser> getMyFans(int userId);
	List<RelationUser> getMyFollow(int userId);
	boolean cancelFollow(int idolUserId, int fanUserId);
	boolean followUser(int idolUserId, int fanUserId);
	boolean isExistFollow(int idolUserId, int fanUserId);
}
