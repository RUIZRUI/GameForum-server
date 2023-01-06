package cn.ruizrui.gameforum.service;

import java.util.List;

import cn.ruizrui.gameforum.model.RelationUser;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import org.springframework.stereotype.Service;


@Service
public class FollowService {

    private UserInterface proxy = new ProxyUser("用户");

    /**
     * 获取关注信息
     * @param userId
     * @return
     */
    public List<RelationUser> getFollows(int userId){
        return proxy.getFollowUsers(userId);
    }

    /**
     * 获取粉丝信息
     * @param userId
     * @return
     */
    public List<RelationUser> getFans(int userId){
        return proxy.getFanUsers(userId);
    }

    /**
     * 关注用户
     * @param idolUserId
     * @param fanUserId
     * @return
     */
    public String followUser(int idolUserId, int fanUserId){
        return proxy.followUser(idolUserId, fanUserId);
    }
}
