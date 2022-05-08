package cn.ruizrui.gameforum.window;

import java.util.ArrayList;
import cn.ruizrui.gameforum.DAO.impl.IosDAOImpl;

import cn.ruizrui.gameforum.entity.IosGame;

public class IosMainWindow {
	IosDAOImpl ii=new IosDAOImpl();
	
	public ArrayList<IosGame> getAndroidGameByTime(){
		return ii.getGameByTime();
	}
	public ArrayList<IosGame> getAndroidGameByPopularity(){
		return ii.getGameByRaterNum();
	}
	public ArrayList<IosGame> getAndroidGameByRate(){
		return ii.getGameByScore();
	}
}
