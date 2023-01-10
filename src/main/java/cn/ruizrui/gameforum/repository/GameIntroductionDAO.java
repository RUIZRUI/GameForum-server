package cn.ruizrui.gameforum.repository;

import cn.ruizrui.gameforum.model.GameIntroduction;

public interface GameIntroductionDAO {

    String getGameIntroduction(String gameId);
    boolean addGameIntroduction(GameIntroduction gameIntroduction);
    boolean deleteGameIntroductionById(String gameId);
}
