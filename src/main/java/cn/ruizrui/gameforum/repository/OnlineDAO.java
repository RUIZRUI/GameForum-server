package cn.ruizrui.gameforum.repository;
import cn.ruizrui.gameforum.model.*;
import java.util.ArrayList;

public interface OnlineDAO {
	public ArrayList<OnlineGame> getAllGame();
	OnlineGame getGameById(String gameId);
	ArrayList<OnlineGame> getGameByType(String game_type);
	ArrayList<OnlineGame> getGameByDevelop(String game_develop);
	boolean addGame(OnlineGame onlineGame);
	ArrayList<OnlineGame> getGameByHopeNum();
	ArrayList<OnlineGame> getGameByRaterNum();
	ArrayList<OnlineGame> getGameByScore();
	boolean deleteGame(String gameId);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
