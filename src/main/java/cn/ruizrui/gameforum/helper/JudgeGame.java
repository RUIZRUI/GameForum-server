package cn.ruizrui.gameforum.helper;
import cn.ruizrui.gameforum.repository.impl.AndroidDAOImpl;
import cn.ruizrui.gameforum.repository.impl.IOSDAOImpl;
import cn.ruizrui.gameforum.repository.impl.OnlineDAOImpl;
import cn.ruizrui.gameforum.repository.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.IOSGame;
import cn.ruizrui.gameforum.model.OnlineGame;
import cn.ruizrui.gameforum.model.SingleGame;

public class JudgeGame {
	AndroidDAOImpl ai=new AndroidDAOImpl();
	IOSDAOImpl ii=new IOSDAOImpl();
	OnlineDAOImpl oi=new OnlineDAOImpl();
	SingleDAOImpl si=new SingleDAOImpl();
	
	public AndroidGame judgeAndroid(String gameId) {
		return ai.getGameById(gameId);
	}

	public IOSGame judgeIOS(String gameId) {
		return ii.getGameById(gameId);
	}

	public OnlineGame judgeOnline(String gameId) {
		return oi.getGameById(gameId);
	}

	public SingleGame judgeSingle(String gameId) {
		return si.getGameById(gameId);
	}

	public String deleteGame(String gameName,int belong) {
		switch(belong) {
			case 0:si.deleteGame(gameName);
				break;
			case 1:ai.deleteGame(gameName);
				break;
			case 2:ii.deleteGame(gameName);
				break;
			case 3:oi.deleteGame(gameName);
				break;
			default:
				return "ɾ��ʧ��";
		}
		return "success";
	}

	public int getGameNum(int belong) {
		switch(belong) {
			case 0:
				return si.getGameNumber();
			case 1:
				return ai.getGameNumber();
			case 2:
				return ii.getGameNumber();
			case 3:
				return oi.getGameNumber();
			default:
				return 0;
		}
	}

	public String getGameIdByName(String gameName) {
		if(si.getGameIdByName(gameName)!=null) {
			return si.getGameIdByName(gameName);
		}else if(ai.getGameIdByName(gameName)!=null) {
			return ai.getGameIdByName(gameName);
		}else if(ii.getGameIdByName(gameName)!=null) {
			return ii.getGameIdByName(gameName);
		}else if(oi.getGameIdByName(gameName)!=null) {
			return oi.getGameIdByName(gameName);
		}
		return null;
	
	}
}
