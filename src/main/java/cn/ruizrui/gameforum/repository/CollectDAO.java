package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.CollectInfo;
public interface CollectDAO {
	public ArrayList<CollectInfo> getCollectionByName(String userName);
	public boolean cancelCollection(String userName,String gameName);
	public boolean clearCollection(String userName);
	public boolean addCollection(String userName,String gameName);
}
