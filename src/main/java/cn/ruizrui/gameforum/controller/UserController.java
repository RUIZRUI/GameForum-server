package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.model.User;
import cn.ruizrui.gameforum.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/gameforum/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param userName
     * @param userPass
     * @param userEmail
     * @param userPhone
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String userName, @RequestParam String userPass, @RequestParam String userEmail,
                         @RequestParam String userPhone){
        User user = new User(userName, userPass, userEmail, userPhone);
        String result = userService.addUser(user);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }

    /**
     * 登录验证
     * @param userName
     * @param userPass
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userName, @RequestParam String userPass){
        String result = userService.authUser(userName, userPass);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam(value = "userName", required = true) String userName){
        User user = userService.getUser(userName);
        JSONObject message = new JSONObject();
        message.put("id", user.getUser_id());
        message.put("name", user.getUser_name());
        message.put("email", user.getMail());
        message.put("phone", user.getPhone());
        message.put("sex", user.getSex());
        message.put("birthday", user.getBirthdate());
        message.put("joinTime", new Date());
        message.put("followNum", user.getFollow_number());
        message.put("fanNum", user.getFans_number());
        message.put("avatarUrl", user.getImg());
        return message.toJSONString();
    }
}
