package cn.ruizrui.gameforum.service;

import java.util.List;
import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.model.SingleGame;

public class SingleMainWindow {
	SingleDAOImpl si=new SingleDAOImpl();
	
	public List<SingleGame> getAndroidGameByTime(){
		return si.getSingleGameByTime();
	}
	public List<SingleGame> getAndroidGameByPopularity(){
		return si.getSingleGameByRaterNum();
	}
	public List<SingleGame> getAndroidGameByRate(){
		return si.getSingleGameByScore();
	}
}
