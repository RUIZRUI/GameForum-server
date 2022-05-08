package window;

import java.util.ArrayList;
import DAO.impl.OnlineDAOImpl;
import entity.OnlineGame;

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
