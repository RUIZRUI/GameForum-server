package cn.ruizrui.gameforum.service;

import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.OnlineDAOImpl;
import cn.ruizrui.gameforum.model.OnlineGame;

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
