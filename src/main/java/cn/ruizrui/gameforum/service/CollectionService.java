package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.model.CollectInfo;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private UserInterface proxy = new ProxyUser("用户");

    /**
     * 获取用户收藏信息
     * @param userId
     * @return
     */
    public List<CollectInfo> getCollection(int userId){
        return proxy.getCollectionList(userId);
    }
}
