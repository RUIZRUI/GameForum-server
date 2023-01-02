package cn.ruizrui.gameforum.service;

import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.model.SingleGame;

public class SingleMainWindow {
	SingleDAOImpl si=new SingleDAOImpl();
	
	public ArrayList<SingleGame> getAndroidGameByTime(){
		return si.getSingleGameByTime();
	}
	public ArrayList<SingleGame> getAndroidGameByPopularity(){
		return si.getSingleGameByRaterNum();
	}
	public ArrayList<SingleGame> getAndroidGameByRate(){
		return si.getSingleGameByScore();
	}
}
