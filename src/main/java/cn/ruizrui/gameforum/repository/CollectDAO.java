package cn.ruizrui.gameforum.repository;
import java.util.List;

import cn.ruizrui.gameforum.model.CollectInfo;
public interface CollectDAO {
	List<CollectInfo> getCollectionByUserId(int userId);
	boolean cancelCollection(int userId, String gameId);
	boolean clearCollection(int userId);
	boolean addCollection(int userId, String gameId);
	boolean isExistCollection(int userId, String gameId);
}
