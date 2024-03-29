package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.IOSGame;
import cn.ruizrui.gameforum.model.OnlineGame;
import cn.ruizrui.gameforum.model.SingleGame;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import cn.ruizrui.gameforum.repository.*;
import cn.ruizrui.gameforum.repository.impl.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GameService {

    private UserInterface proxy = new ProxyUser("用户");
    private UserInterface admin = new ProxyUser("管理员");
    private SingleDAO singleDAO = new SingleDAOImpl();
    private AndroidDAO androidDAO = new AndroidDAOImpl();
    private IOSDAO iosDAO = new IOSDAOImpl();
    private OnlineDAO onlineDAO = new OnlineDAOImpl();
    private GameIntroductionDAO gameIntroductionDAO = new GameIntroductionDAOImpl();

    /**
     * 获取所有单机游戏
     * @param sortType
     * @param desc
     * @return
     */
    public List<SingleGame> getAllSingleGame(int sortType, boolean desc){
        List<SingleGame> singleGameList;
        if (sortType == 1) {
            // 时间排序
            singleGameList = singleDAO.getSingleGameByTime();
        } else if (sortType == 2) {
            // 热度排序
            singleGameList = singleDAO.getSingleGameByRaterNum();
        } else if (sortType == 3) {
            // 评分排序
            singleGameList = singleDAO.getSingleGameByScore();
        } else {
            singleGameList = null;
        }
        return singleGameList;
    }

    /**
     * 获取所有安卓游戏
     * @param sortType
     * @param desc
     * @return
     */
    public List<AndroidGame> getAllAndroidGame(int sortType, boolean desc){
        List<AndroidGame> androidGameList;
        if (sortType == 1){
            // 时间排序
            androidGameList = androidDAO.getGameByTime();
        } else if (sortType == 2){
            // 热度排序
            androidGameList = androidDAO.getGameByRaterNum();
        } else if (sortType == 3){
            // 评分排序
            androidGameList = androidDAO.getGameByScore();
        } else {
            androidGameList = null;
        }
        return  androidGameList;
    }

    /**
     * 获取所有苹果游戏
     * @param sortType
     * @param desc
     * @return
     */
    public List<IOSGame> getAllIOSGame(int sortType, boolean desc){
        List<IOSGame> iosGameList;
        if (sortType == 1){
            // 时间排序
            iosGameList = iosDAO.getGameByTime();
        } else if (sortType == 2){
            // 热度排序
            iosGameList = iosDAO.getGameByRaterNum();
        } else if (sortType == 3){
            // 评分排序
            iosGameList = iosDAO.getGameByScore();
        } else {
            iosGameList = null;
        }
        return iosGameList;
    }

    /**
     * 获取所有网页游戏
     * @param sortType
     * @param desc
     * @return
     */
    public List<OnlineGame> getAllOnlineGame(int sortType, boolean desc){
        List<OnlineGame> onlineGameList;
        if (sortType == 1){
            // 期望值排序
            onlineGameList = onlineDAO.getGameByHopeNum();
        } else if (sortType == 2){
            // 热度排序
            onlineGameList = onlineDAO.getGameByRaterNum();
        } else if (sortType == 3){
            // 评分排序
            onlineGameList = onlineDAO.getGameByScore();
        } else {
            onlineGameList = null;
        }
        return onlineGameList;
    }

    /**
     * 获取单个单机游戏
     * @param gameId
     * @return
     */
    public SingleGame getSingleGame(String gameId){
        return singleDAO.getGameById(gameId);
    }

    /**
     * 获取游戏简介
     * @param gameId
     * @return
     */
    public String getGameIntroduction(String gameId){
        return gameIntroductionDAO.getGameIntroduction(gameId);
    }

    /**
     * 获取单个苹果游戏
     * @param gameId
     * @return
     */
    public IOSGame getIOSGame(String gameId){
        return iosDAO.getGameById(gameId);
    }

    /**
     * 获取单个安卓游戏
     * @param gameId
     * @return
     */
    public AndroidGame getAndroidGame(String gameId){
        return androidDAO.getGameById(gameId);
    }

    /**
     * 获取单个网页游戏
     * @param gameId
     * @return
     */
    public OnlineGame getOnlineGame(String gameId){
        return onlineDAO.getGameById(gameId);
    }

    /**
     * 删除游戏
     * @param userId
     * @param userName
     * @param gameName
     * @param gameBelong
     * @return
     */
    public String gameDelete(int userId, String userName, String gameName, String gameBelong){
        return admin.deleteGame(gameName, gameBelong);
    }

    /**
     * 发布游戏
     * @param userId
     * @param userName
     * @param gameName
     * @param gameBelong
     * @param gameType
     * @param gameRelease
     * @param gameReleaseDate
     * @param gameArrangeTime
     * @param gamePlatform
     * @param gameWebsite
     * @param gameLabel
     * @param gameLanguage
     * @param gameScore
     * @param gameRaterNum
     * @param gameImg
     * @return
     */
    public String gamePublish(int userId, String userName, String gameName, String gameBelong, String gameType, String gameRelease,
                              String gameReleaseDate, String gameArrangeTime, String gamePlatform, String gameWebsite,
                              String gameLabel, String gameLanguage, float gameScore, Integer gameRaterNum, String gameImg){
        return admin.publishGame(userId, userName, gameName, gameBelong, gameType, gameRelease, gameReleaseDate,
                gameArrangeTime, gamePlatform, gameWebsite, gameLabel, gameLanguage, gameScore, gameRaterNum, gameImg);
    }
}
