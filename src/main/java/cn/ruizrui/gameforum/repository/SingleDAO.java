package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.model.SingleGame;

public interface SingleDAO {
	public ArrayList<SingleGame> getAllGames();
	public ArrayList<SingleGame> getGameByType(String game_type);
	public ArrayList<SingleGame> getGameByDevelop(String game_develop);
	public SingleGame getGameById(String gameId);
	public void addGame(SingleGame game);
	public List<SingleGame> getSingleGameByTime();
	public List<SingleGame> getSingleGameByRaterNum();
	public List<SingleGame> getSingleGameByScore();
	public boolean deleteGame(String gameName);
	public int getGameNumber();
	String getGameIdByName(String gameName);
}
