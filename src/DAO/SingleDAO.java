package DAO;
import java.util.ArrayList;

import entity.SingleGame;

public interface SingleDAO {
	public ArrayList<SingleGame> getAllGames();
	public ArrayList<SingleGame> getGameByType(String game_type);
	public ArrayList<SingleGame> getGameByDevelop(String game_develop);
	public SingleGame getGameByName(String game_name);
	public void addGame(SingleGame game);
	public ArrayList<SingleGame> getSingleGameByTime();
	public ArrayList<SingleGame> getSingleGameByRaterNum();
	public ArrayList<SingleGame> getSingleGameByScore();
	public boolean deleteGame(String gameName);
	public int getGameNumber();
	String getGameIdByName(String gameName);
}
