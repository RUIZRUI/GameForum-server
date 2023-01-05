package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.config.SQLConfig;
import cn.ruizrui.gameforum.model.User;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 登录验证
     * @param userName
     * @param userPass
     * @return
     */
    public String authUser(String userName, String userPass){
        return proxy.userLogin(userName, userPass);
    }

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    public User getUser(String userName){
        return proxy.getUserData(userName);
    }

    public String updateUser(int userId, String userName, String userEmail, String userPhone, String userSex, String userBirthday){
        return proxy.setUserData(userId, userName, userEmail, userPhone, userSex, userBirthday);
    }
}
