package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.config.SQLConfig;
import cn.ruizrui.gameforum.model.User;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserInterface proxy = new ProxyUser("用户");

    private UserInterface admin = new ProxyUser("管理员");

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

    /**
     * 更改个人信息
     * @param userId
     * @param userName
     * @param userEmail
     * @param userPhone
     * @param userSex
     * @param userBirthday
     * @return
     */
    public String updateUser(int userId, String userName, String userEmail, String userPhone, String userSex, String userBirthday){
        return proxy.setUserData(userId, userName, userEmail, userPhone, userSex, userBirthday);
    }

    /**
     * 管理员删除用户
     * @param userId
     * @param userName
     * @param deletedUserId
     * @return
     */
    public String userDelete(int userId, String userName, int deletedUserId){
        return admin.deleteUser(deletedUserId);
    }
}
