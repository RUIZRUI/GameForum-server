package cn.ruizrui.gameforum.repository;
import cn.ruizrui.gameforum.model.*;
import java.util.ArrayList;

public interface OnlineDAO {
	public ArrayList<OnlineGame> getAllGame();
	OnlineGame getGameByName(String game_name);
	ArrayList<OnlineGame> getGameByType(String game_type);
	ArrayList<OnlineGame> getGameByDevelop(String game_develop);
	void addGame(OnlineGame game);
	ArrayList<OnlineGame> getGameByTime();
	ArrayList<OnlineGame> getGameByRaterNum();
	ArrayList<OnlineGame> getGameByScore();
	boolean deleteGame(String gameName);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
