package cn.ruizrui.gameforum.helper;

import java.util.UUID;

import cn.ruizrui.gameforum.model.*;
import cn.ruizrui.gameforum.repository.*;
import cn.ruizrui.gameforum.repository.impl.*;

public class GameHelper {
	private static AndroidDAO androidDAO = new AndroidDAOImpl();
	private static IOSDAO iosdao = new IOSDAOImpl();
	private static OnlineDAO onlineDAO = new OnlineDAOImpl();
	private static SingleDAO singleDAO = new SingleDAOImpl();
	private static BaseGameDao baseGameDao = new BaseGameDaoImpl();
	private static GameIntroductionDAO gameIntroductionDAO = new GameIntroductionDAOImpl();

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

	public static String deleteGame(String gameName, String gameBelong) {
		boolean result = false;
		String gameId;
		switch(gameBelong) {
			case "单机游戏":
				gameId = singleDAO.getGameIdByName(gameName);
				result = (gameId != null) && singleDAO.deleteGame(gameId) && baseGameDao.deleteGameById(gameId) && gameIntroductionDAO.deleteGameIntroductionById(gameId);
				break;
			case "安卓游戏":
				gameId = androidDAO.getGameIdByName(gameName);
				result = (gameId != null) && androidDAO.deleteGame(gameId) && baseGameDao.deleteGameById(gameId) && gameIntroductionDAO.deleteGameIntroductionById(gameId);
				break;
			case "苹果游戏":
				gameId = iosdao.getGameIdByName(gameName);
				result = (gameId != null) && iosdao.deleteGame(gameId) && baseGameDao.deleteGameById(gameId) && gameIntroductionDAO.deleteGameIntroductionById(gameId);
				break;
			case "网页游戏":
				gameId = onlineDAO.getGameIdByName(gameName);
				result = (gameId != null) && onlineDAO.deleteGame(gameId) && baseGameDao.deleteGameById(gameId) && gameIntroductionDAO.deleteGameIntroductionById(gameId);
				break;
			default:
				return "没有此类型游戏";
		}
		return result ? "success" : ("删除游戏失败，gameBelong: " + gameBelong + ", gameName: " + gameName);
	}

	public static String publishGame(String gameName, String gameBelong, String gameType, String gameRelease,
									 String gameReleaseDate, String gameArrangeTime, String gamePlatform, String gameWebsite,
									 String gameLabel, String gameLanguage, float gameScore, Integer gameRaterNum, String gameImg){
		boolean result = false;
		switch (gameBelong) {
			case "单机游戏":
				SingleGame singleGame = new SingleGame();
				singleGame.setGame_id(UUID.randomUUID().toString());
				singleGame.setGame_name(gameName);
				singleGame.setGame_type(gameType);
				singleGame.setGame_release(gameRelease);
				singleGame.setGame_release_date(DateHelper.str2Date(gameReleaseDate));
				singleGame.setGame_arrange_date(DateHelper.str2Date(gameArrangeTime));
				singleGame.setGame_platform(gamePlatform);
				singleGame.setGame_website(gameWebsite);
				singleGame.setGame_label(gameLabel);
				singleGame.setGame_language(gameLanguage);
				singleGame.setGame_score(gameScore);
				singleGame.setGame_rater_num(gameRaterNum);
				singleGame.setGame_img(gameImg);
				GameIntroduction singleGameIntro = new GameIntroduction(singleGame.getGame_id(), singleGame.getGame_name());
				result = singleDAO.addGame(singleGame) && gameIntroductionDAO.addGameIntroduction(singleGameIntro);
				break;
			case "安卓游戏":
				AndroidGame androidGame = new AndroidGame();
				androidGame.setGame_id(UUID.randomUUID().toString());
				androidGame.setGame_name(gameName);
				androidGame.setGame_slogan("slogan");
				androidGame.setGame_version("version");
				androidGame.setGame_platform(gamePlatform);
				androidGame.setGame_type(gameType);
				androidGame.setGame_release_date(DateHelper.str2Date(gameReleaseDate));
				androidGame.setGame_release(gameRelease);
				androidGame.setGame_language(gameLanguage);
				androidGame.setGame_score(gameScore);
				androidGame.setGame_rater_num(gameRaterNum);
				androidGame.setGame_img(gameImg);
				GameIntroduction androidGameIntro = new GameIntroduction(androidGame.getGame_id(), androidGame.getGame_name());
				result = androidDAO.addGame(androidGame) && gameIntroductionDAO.addGameIntroduction(androidGameIntro);
				break;
			case "苹果游戏":
				IOSGame iosGame = new IOSGame();
				iosGame.setGame_id(UUID.randomUUID().toString());
				iosGame.setGame_name(gameName);
				iosGame.setGame_slogan("slogan");
				iosGame.setGame_version("version");
				iosGame.setGame_platform(gamePlatform);
				iosGame.setGame_type(gameType);
				iosGame.setGame_release_date(DateHelper.str2Date(gameReleaseDate));
				iosGame.setGame_release(gameRelease);
				iosGame.setGame_language(gameLanguage);
				iosGame.setGame_score(gameScore);
				iosGame.setGame_rater_num(gameRaterNum);
				iosGame.setGame_img(gameImg);
				GameIntroduction iosGameIntro = new GameIntroduction(iosGame.getGame_id(), iosGame.getGame_name());
				result = iosdao.addGame(iosGame) && gameIntroductionDAO.addGameIntroduction(iosGameIntro);
				break;
			case "网页游戏":
				OnlineGame onlineGame = new OnlineGame();
				onlineGame.setGame_id(UUID.randomUUID().toString());
				onlineGame.setGame_name(gameName);
				onlineGame.setGame_hope_num(0);
				onlineGame.setGame_type(gameType);
				onlineGame.setGame_frame("frame");
				onlineGame.setGame_develop("develop");
				onlineGame.setGame_operator("operator");
				onlineGame.setGame_website(gameWebsite);
				onlineGame.setGame_status("status");
				onlineGame.setGame_label(gameLabel);
				onlineGame.setGame_score(gameScore);
				onlineGame.setGame_rater_num(gameRaterNum);
				onlineGame.setGame_img(gameImg);
				GameIntroduction onlineGameIntro = new GameIntroduction(onlineGame.getGame_id(), onlineGame.getGame_name());
				result = onlineDAO.addGame(onlineGame) && gameIntroductionDAO.addGameIntroduction(onlineGameIntro);
				break;
			default:
				return "没有此类型游戏";
		}
		return result ? "success" : ("发布游戏失败，gameBelong: " + gameBelong + ", gameName: " + gameName);
	}
}
