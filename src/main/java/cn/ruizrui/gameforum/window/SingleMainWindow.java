package cn.ruizrui.gameforum.window;

import java.util.ArrayList;
import cn.ruizrui.gameforum.DAO.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.entity.SingleGame;

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
