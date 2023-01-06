package cn.ruizrui.gameforum.helper;
import cn.ruizrui.gameforum.repository.*;
import cn.ruizrui.gameforum.repository.impl.*;
import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.IOSGame;
import cn.ruizrui.gameforum.model.OnlineGame;
import cn.ruizrui.gameforum.model.SingleGame;

public class GameHelper {
	private static AndroidDAO androidDAO = new AndroidDAOImpl();
	private static IOSDAO iosdao = new IOSDAOImpl();
	private static OnlineDAO onlineDAO = new OnlineDAOImpl();
	private static SingleDAO singleDAO = new SingleDAOImpl();
	private static BaseGameDao baseGameDao = new BaseGameDaoImpl();

	public String deleteGame(String gameName,int belong) {
		switch(belong) {
			case 0:singleDAO.deleteGame(gameName);
				break;
			case 1:androidDAO.deleteGame(gameName);
				break;
			case 2:iosdao.deleteGame(gameName);
				break;
			case 3:onlineDAO.deleteGame(gameName);
				break;
			default:
				return "ɾ��ʧ��";
		}
		return "success";
	}

	public int getGameNum(int belong) {
		switch(belong) {
			case 0:
				return singleDAO.getGameNumber();
			case 1:
				return androidDAO.getGameNumber();
			case 2:
				return iosdao.getGameNumber();
			case 3:
				return onlineDAO.getGameNumber();
			default:
				return 0;
		}
	}

	public static String getGameBelongById(String gameId){
		return baseGameDao.getGameBelongById(gameId);
	}

	public static SingleGame getSingleGameById(String gameId){
		return singleDAO.getGameById(gameId);
	}

	public static AndroidGame getAndroidGameById(String gameId){
		return androidDAO.getGameById(gameId);
	}

	public static IOSGame getIOSGameById(String gameId){
		return iosdao.getGameById(gameId);
	}

	public static OnlineGame getOnlineGameById(String gameId){
		return onlineDAO.getGameById(gameId);
	}
}
