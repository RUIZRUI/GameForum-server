package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.model.CollectInfo;
import cn.ruizrui.gameforum.service.CollectionService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gameforum/v1/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 获取用户收藏信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getCollection", method = RequestMethod.GET)
    public String getCollection(@RequestParam int userId){
        List<CollectInfo> collectInfoList = collectionService.getCollection(userId);
        JSONObject message = new JSONObject();
        message.put("result", collectInfoList);
        return message.toJSONString();
    }

    /**
     * 添加游戏收藏
     * @param userId
     * @param gameId
     * @return
     */
    @RequestMapping(value = "/addCollection", method = RequestMethod.POST)
    public String addCollection(@RequestParam int userId, @RequestParam String gameId){
        String result = collectionService.addCollection(userId, gameId);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }

    /**
     * 取消收藏游戏
     * @param userId
     * @param gameId
     * @return
     */
    @RequestMapping(value = "/cancelCollection", method = RequestMethod.POST)
    public String cancelCollection(@RequestParam int userId, @RequestParam String gameId){
        String result = collectionService.cancelCollection(userId, gameId);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }

    /**
     * 清空收藏游戏
     * @param userId
     * @return
     */
    @RequestMapping(value = "/clearCollection", method = RequestMethod.POST)
    public String clearCollection(@RequestParam int userId){
        String result = collectionService.clearCollection(userId);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }
}
