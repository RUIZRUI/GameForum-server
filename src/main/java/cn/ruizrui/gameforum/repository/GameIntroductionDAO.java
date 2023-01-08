package cn.ruizrui.gameforum.repository;

import cn.ruizrui.gameforum.model.GameIntroduction;

public interface GameIntroductionDAO {

    public String getGameIntroduction(String gameId);
    public boolean addGameIntroduction(GameIntroduction gameIntroduction);
    public boolean deleteGameIntroductionById(String gameId);
}
