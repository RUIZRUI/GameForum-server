package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.IosGame;
import cn.ruizrui.gameforum.model.OnlineGame;
import cn.ruizrui.gameforum.model.SingleGame;
import cn.ruizrui.gameforum.service.GameService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gameforum/v1/game")
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * 获取所有单机游戏
     * @param sortType
     * @param desc
     * @return
     */
    @RequestMapping(value = "/getAllSingleGame", method = RequestMethod.GET)
    public String getAllSingleGame(@RequestParam int sortType, @RequestParam boolean desc){
        List<SingleGame> singleGameList = gameService.getAllSingleGame(sortType, desc);
        JSONObject message = new JSONObject();
        message.put("result", singleGameList);
        return message.toJSONString();
    }

    /**
     * 获取所有安卓游戏
     * @param sortType
     * @param desc
     * @return
     */
    @RequestMapping(value = "/getAllAndroidGame", method = RequestMethod.GET)
    public String getAllAndroidGame(@RequestParam int sortType, @RequestParam boolean desc){
        List<AndroidGame> androidGameList = gameService.getAllAndroidGame(sortType, desc);
        JSONObject message = new JSONObject();
        message.put("result", androidGameList);
        return message.toJSONString();
    }

    /**
     * 获取所有苹果游戏
     * @param sortType
     * @param desc
     * @return
     */
    @RequestMapping(value = "/getAllIOSGame", method = RequestMethod.GET)
    public String getAllIOSGame(@RequestParam int sortType, @RequestParam boolean desc){
        List<IosGame> iosGameList = gameService.getAllIOSGame(sortType, desc);
        JSONObject message = new JSONObject();
        message.put("result", iosGameList);
        return message.toJSONString();
    }

    /**
     * 获取所有网页游戏
     * @param sortType
     * @param desc
     * @return
     */
    @RequestMapping(value = "/getAllOnlineGame", method = RequestMethod.GET)
    public String getAllOnlineGame(@RequestParam int sortType, @RequestParam boolean desc){
        List<OnlineGame> onlineGameList = gameService.getAllOnlineGame(sortType, desc);
        JSONObject message = new JSONObject();
        message.put("result", onlineGameList);
        return message.toJSONString();
    }

    /**
     * 获取单个单机游戏
     * @param gameId
     * @return
     */
    @RequestMapping(value = "/getSingleGame", method = RequestMethod.GET)
    public String getSingleGame(@RequestParam String gameId){
        SingleGame singleGame = gameService.getSingleGame(gameId);
        String result = (singleGame != null) ? "success" : "单机游戏为空值";
        JSONObject message = new JSONObject();
        message.put("result", result);
        message.put("singleGame", singleGame);
        return message.toJSONString();
    }

    /**
     * 获取游戏简介
     * @param gameId
     * @return
     */
    @RequestMapping(value = "/getGameIntroduction", method = RequestMethod.GET)
    public String getGameIntroduction(@RequestParam String gameId){
        String gameIntroduction = gameService.getGameIntroduction(gameId);
        String result = (gameIntroduction != null) ? "success" : "游戏简介为空值";
        JSONObject message = new JSONObject();
        message.put("result", result);
        message.put("gameIntroduction", gameIntroduction);
        return message.toJSONString();
    }
}
