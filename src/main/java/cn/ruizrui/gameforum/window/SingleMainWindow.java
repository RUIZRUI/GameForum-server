package window;

import java.util.ArrayList;
import DAO.impl.SingleDAOImpl;
import entity.SingleGame;

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
