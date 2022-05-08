package window;

import java.util.ArrayList;
import DAO.impl.IosDAOImpl;

import entity.IosGame;

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
