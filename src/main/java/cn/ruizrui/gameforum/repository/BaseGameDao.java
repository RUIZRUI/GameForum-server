package cn.ruizrui.gameforum.repository;

public interface BaseGameDao {

    public String getGameBelongById(String gameId);

    public boolean deleteGameById(String gameId);
}
