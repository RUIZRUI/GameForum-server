package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.model.CollectInfo;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import cn.ruizrui.gameforum.repository.CollectDAO;
import cn.ruizrui.gameforum.repository.impl.CollectDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private UserInterface proxy = new ProxyUser("用户");

    private CollectDAO collectDAO = new CollectDAOImpl();

    /**
     * 获取用户收藏信息
     * @param userId
     * @return
     */
    public List<CollectInfo> getCollection(int userId){
        return proxy.getCollectionList(userId);
    }

    /**
     * 添加游戏收藏
     * @param userId
     * @param gameId
     * @return
     */
    public String addCollection(int userId, String gameId){
        if (collectDAO.isExistCollection(userId, gameId)) {
            return "您已收藏此游戏";
        }
        return proxy.addCollection(userId, gameId) ? "success" : "游戏收藏失败";
    }

    /**
     * 取消收藏游戏
     * @param userId
     * @param gameId
     * @return
     */
    public String cancelCollection(int userId, String gameId){
        return proxy.cancelCollection(userId, gameId);
    }

    /**
     * 清空收藏游戏
     * @param userId
     * @return
     */
    public String clearCollection(int userId){
        return proxy.cleanCollection(userId);
    }
}
