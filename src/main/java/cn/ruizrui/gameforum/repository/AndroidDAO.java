package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.*;
public interface AndroidDAO {
	ArrayList<AndroidGame>  getAllGames();
	AndroidGame getGameByName(String game_name);
	ArrayList<AndroidGame> getGameByType(String game_type);
	void addGame(AndroidGame game);
	ArrayList<AndroidGame> getGameByTime();
	ArrayList<AndroidGame> getGameByRaterNum();
	ArrayList<AndroidGame> getGameByScore();
	boolean deleteGame(String gameName);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
