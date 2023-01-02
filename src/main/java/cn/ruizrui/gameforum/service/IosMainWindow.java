package cn.ruizrui.gameforum.service;

import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.IosDAOImpl;

import cn.ruizrui.gameforum.model.IosGame;

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
