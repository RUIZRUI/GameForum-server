package cn.ruizrui.gameforum.window;

import java.util.ArrayList;
import cn.ruizrui.gameforum.DAO.impl.OnlineDAOImpl;
import cn.ruizrui.gameforum.entity.OnlineGame;

public class OnlineMainWindow {
	OnlineDAOImpl oi=new OnlineDAOImpl();
	
	public ArrayList<OnlineGame> getAndroidGameByTime(){
		return oi.getGameByTime();
	}
	public ArrayList<OnlineGame> getAndroidGameByPopularity(){
		return oi.getGameByRaterNum();
	}
	public ArrayList<OnlineGame> getAndroidGameByRate(){
		return oi.getGameByScore();
	}
}
