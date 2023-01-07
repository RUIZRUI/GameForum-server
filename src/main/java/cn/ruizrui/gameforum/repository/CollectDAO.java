package cn.ruizrui.gameforum.repository;
import java.util.List;

import cn.ruizrui.gameforum.model.CollectInfo;
public interface CollectDAO {
	public List<CollectInfo> getCollectionByUserId(int userId);
	public boolean cancelCollection(int userId, String gameId);
	public boolean clearCollection(int userId);
	public boolean addCollection(int userId, String gameId);
	public boolean isExistCollection(int userId, String gameId);
}
