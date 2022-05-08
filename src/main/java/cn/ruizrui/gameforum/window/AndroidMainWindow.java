package cn.ruizrui.gameforum.window;

import java.util.ArrayList;

import cn.ruizrui.gameforum.DAO.impl.AndroidDAOImpl;
import cn.ruizrui.gameforum.entity.AndroidGame;

public class AndroidMainWindow {
	AndroidDAOImpl ai=new AndroidDAOImpl();
	
	public ArrayList<AndroidGame> getAndroidGameByTime(){
		return ai.getGameByTime();
	}
	public ArrayList<AndroidGame> getAndroidGameByPopularity(){
		return ai.getGameByRaterNum();
	}
	public ArrayList<AndroidGame> getAndroidGameByRate(){
		return ai.getGameByScore();
	}
}
