package cn.ruizrui.gameforum.repository;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.IOSGame;
public interface IOSDAO {
    public ArrayList<IOSGame> getAllGames();
    public IOSGame getGameById(String gameId);
    public ArrayList<IOSGame> getGameByType(String game_type);
    public void addGame(IOSGame game);
    public ArrayList<IOSGame> getGameByTime();
    public	ArrayList<IOSGame> getGameByRaterNum();
    public ArrayList<IOSGame> getGameByScore();
    public boolean deleteGame(String gameName);
	int getGameNumber();
	String getGameIdByName(String gameName);
}
