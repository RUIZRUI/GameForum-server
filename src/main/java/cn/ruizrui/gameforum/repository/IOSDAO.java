package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.IOSGame;
public interface IOSDAO {
    ArrayList<IOSGame> getAllGames();
    IOSGame getGameById(String gameId);
    ArrayList<IOSGame> getGameByType(String game_type);
    boolean addGame(IOSGame iosGame);
    ArrayList<IOSGame> getGameByTime();
    ArrayList<IOSGame> getGameByRaterNum();
    ArrayList<IOSGame> getGameByScore();
    boolean deleteGame(String gameId);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
