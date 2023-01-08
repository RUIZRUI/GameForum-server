package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.*;
public interface AndroidDAO {
	ArrayList<AndroidGame>  getAllGames();
	AndroidGame getGameById(String gameId);
	ArrayList<AndroidGame> getGameByType(String game_type);
	boolean addGame(AndroidGame androidGame);
	ArrayList<AndroidGame> getGameByTime();
	ArrayList<AndroidGame> getGameByRaterNum();
	ArrayList<AndroidGame> getGameByScore();
	boolean deleteGame(String gameId);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
