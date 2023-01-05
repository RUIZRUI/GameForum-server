package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.model.RelationUser;
import cn.ruizrui.gameforum.service.FollowService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gameforum/v1/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 获取关注信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getFollows", method = RequestMethod.GET)
    public String getFollows(@RequestParam int userId){
        List<RelationUser> relationUserList = followService.getFollows(userId);
        JSONObject message = new JSONObject();
        message.put("followList", relationUserList);
        return message.toJSONString();
    }

    /**
     * 获取粉丝信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getFans", method = RequestMethod.GET)
    public String getFans(@RequestParam int userId){
        List<RelationUser> relationUserList = followService.getFans(userId);
        JSONObject message = new JSONObject();
        message.put("fanList", relationUserList);
        return message.toJSONString();
    }
}
