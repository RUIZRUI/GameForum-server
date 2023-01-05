package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.IosGame;
import cn.ruizrui.gameforum.model.OnlineGame;
import cn.ruizrui.gameforum.model.SingleGame;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import cn.ruizrui.gameforum.repository.AndroidDAO;
import cn.ruizrui.gameforum.repository.IosDAO;
import cn.ruizrui.gameforum.repository.OnlineDAO;
import cn.ruizrui.gameforum.repository.SingleDAO;
import cn.ruizrui.gameforum.repository.impl.AndroidDAOImpl;
import cn.ruizrui.gameforum.repository.impl.IosDAOImpl;
import cn.ruizrui.gameforum.repository.impl.OnlineDAOImpl;
import cn.ruizrui.gameforum.repository.impl.SingleDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private UserInterface proxy = new ProxyUser("用户");

    private SingleDAO singleDAO = new SingleDAOImpl();

    private AndroidDAO androidDAO = new AndroidDAOImpl();

    private IosDAO iosDAO = new IosDAOImpl();

    private OnlineDAO onlineDAO = new OnlineDAOImpl();

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
    public List<IosGame> getAllIOSGame(int sortType, boolean desc){
        List<IosGame> iosGameList;
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
}
