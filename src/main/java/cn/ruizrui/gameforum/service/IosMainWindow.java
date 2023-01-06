package cn.ruizrui.gameforum.service;

import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.IOSDAOImpl;

import cn.ruizrui.gameforum.model.IOSGame;

public class IosMainWindow {
	IOSDAOImpl ii=new IOSDAOImpl();
	
	public ArrayList<IOSGame> getAndroidGameByTime(){
		return ii.getGameByTime();
	}
	public ArrayList<IOSGame> getAndroidGameByPopularity(){
		return ii.getGameByRaterNum();
	}
	public ArrayList<IOSGame> getAndroidGameByRate(){
		return ii.getGameByScore();
	}
}
