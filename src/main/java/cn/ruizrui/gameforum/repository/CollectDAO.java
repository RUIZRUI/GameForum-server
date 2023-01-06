package cn.ruizrui.gameforum.repository;
import java.util.List;

import cn.ruizrui.gameforum.model.CollectInfo;
public interface CollectDAO {
	public List<CollectInfo> getCollectionByUserId(int userId);
	public boolean cancelCollection(String userName,String gameName);
	public boolean clearCollection(String userName);
	public boolean addCollection(int userId, String gameId);
}
