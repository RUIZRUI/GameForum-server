package window;

import java.util.ArrayList;

import DAO.impl.AndroidDAOImpl;
import entity.AndroidGame;

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
