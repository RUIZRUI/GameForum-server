package cn.ruizrui.gameforum.DAO;
import java.util.ArrayList;

import cn.ruizrui.gameforum.entity.*;
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
