package cn.ruizrui.gameforum.DAO;
import java.util.ArrayList;

import cn.ruizrui.gameforum.entity.IosGame;
public interface IosDAO {
 public ArrayList<IosGame> getAllGames();
 public IosGame getGameByName(String game_name);
 public ArrayList<IosGame> getGameByType(String game_type);
 public void addGame(IosGame game);
 public ArrayList<IosGame> getGameByTime();
 public	ArrayList<IosGame> getGameByRaterNum();
 public ArrayList<IosGame> getGameByScore();
 public boolean deleteGame(String gameName);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
