package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.service.SystemService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/gameforum/v1/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    /**
     * 获取系统信息
     * @param userId
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getSystemInfo", method = RequestMethod.GET)
    public String getSystemInfo(@RequestParam int userId, @RequestParam String userName){
        int registerNum = systemService.getRegisterNum();
        int dailyActNum = systemService.getDailyActNum();
        int dailyVisitNum = systemService.getDailyVisitNum();
        int gameNum = systemService.getGameNum();
        int singleGameNum = systemService.getSingleGameNum();
        int androidGameNum = systemService.getAndroidGameNum();
        int iosGameNum = systemService.getIOSGameNum();
        int onlineGameNum = systemService.getOnlineGameNum();
        JSONObject message = new JSONObject();
        if (registerNum == -1 || dailyActNum == -1 || dailyVisitNum == -1 || gameNum == -1 || singleGameNum == -1 ||
                androidGameNum == -1 || iosGameNum == -1 || onlineGameNum == -1){
            message.put("result", "insufficientPermission");
        } else {
            message.put("result", "success");
            message.put("registerNum", registerNum);
            message.put("dailyActNum", dailyActNum);
            message.put("dailyVisitNum", dailyVisitNum);
            message.put("gameNum", gameNum);
            message.put("singleGameNum", singleGameNum);
            message.put("androidGameNum", androidGameNum);
            message.put("iosGameNum", iosGameNum);
            message.put("onlineGameNum", onlineGameNum);
        }
        return message.toJSONString();
    }
}
