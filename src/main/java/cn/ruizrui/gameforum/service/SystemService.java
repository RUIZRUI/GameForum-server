package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    private UserInterface proxy = new ProxyUser("管理员");

    /**
     * 获取注册人数
     * @return
     */
    public int getRegisterNum(){
        return proxy.getRegisterPeopleNum();
    }

    /**
     * 获取日活量
     * @return
     */
    public int getDailyActNum(){
        return proxy.oneDayPeopleNum();
    }

    /**
     * 获取日访问量
     * @return
     */
    public int getDailyVisitNum(){
        return proxy.oneMonthPeopleNum();
    }

    /**
     * 获取游戏总数
     * @return
     */
    public int getGameNum(){
        return proxy.getAllGameNum();
    }

    /**
     * 获取单机游戏数
     * @return
     */
    public int getSingleGameNum(){
        return proxy.getSingleGameNum();
    }

    /**
     * 获取安卓游戏数
     * @return
     */
    public int getAndroidGameNum(){
        return proxy.getAndroidGameNum();
    }

    /**
     * 获取苹果游戏数
     * @return
     */
    public int getIOSGameNum(){
        return proxy.getIOSGameNum();
    }

    /**
     * 获取网页游戏数
     * @return
     */
    public int getOnlineGameNum(){
        return proxy.getOnlineGameNum();
    }

}
