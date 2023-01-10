package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.model.SingleGame;

public interface SingleDAO {
	ArrayList<SingleGame> getAllGames();
	ArrayList<SingleGame> getGameByType(String game_type);
	ArrayList<SingleGame> getGameByDevelop(String game_develop);
	SingleGame getGameById(String gameId);
	boolean addGame(SingleGame singleGame);
	List<SingleGame> getSingleGameByTime();
	List<SingleGame> getSingleGameByRaterNum();
	List<SingleGame> getSingleGameByScore();
	boolean deleteGame(String gameId);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
