package cn.ruizrui.gameforum.repository;

public interface BaseGameDao {

    String getGameBelongById(String gameId);

    boolean deleteGameById(String gameId);
}
