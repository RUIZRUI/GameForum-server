package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.model.User;
import cn.ruizrui.gameforum.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
