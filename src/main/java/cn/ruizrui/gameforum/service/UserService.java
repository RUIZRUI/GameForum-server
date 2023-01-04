package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.config.SQLConfig;
import cn.ruizrui.gameforum.model.User;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserInterface proxy = new ProxyUser("用户");

    @Autowired
    private SQLConfig config;

    /**
     * 添加用户信息，即注册服务
     * @param user
     * @return
     */
    public String addUser(User user){
        return proxy.userRegister(user.getUser_name(), user.getPassword(), user.getMail(), user.getPhone());
    }
}
