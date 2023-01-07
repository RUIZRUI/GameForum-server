package cn.ruizrui.gameforum.controller;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.MyComment;
import cn.ruizrui.gameforum.service.CommentService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gameforum/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获取一个游戏的所有评论
     * @param gameId
     * @return
     */
    @RequestMapping(value = "/getCommentByGame", method = RequestMethod.GET)
    public String getCommentByGame(@RequestParam String gameId){
        List<Comment> commentList = commentService.getCommentByGame(gameId);
        String result = (commentList != null) ? "success" : "评论列表为空值";
        JSONObject message = new JSONObject();
        message.put("result", result);
        message.put("commentList", commentList);
        return message.toJSONString();
    }

    /**
     * 发布评论
     * @param userIdFrom
     * @param gameId
     * @param content
     * @return
     */
    @RequestMapping(value = "/publishComment", method = RequestMethod.POST)
    public String publishComment(@RequestParam int userIdFrom, @RequestParam String gameId, @RequestParam String content){
        String result = commentService.publishComment(userIdFrom, gameId, content) ? "success" : "评论失败";
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }

    /**
     * 获取回复我的评论列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getCommentToMe", method = RequestMethod.GET)
    public String getCommentToMe(@RequestParam int userId){
        List<MyComment> comments = commentService.getCommentToMe(userId);
        JSONObject message = new JSONObject();
        if (comments == null){
            message.put("result", "null");
        } else {
            message.put("result", comments);
        }
        return message.toJSONString();
    }

    /**
     * 获取我发布的评论列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getCommentFromMe", method = RequestMethod.GET)
    public String getCommentFromMe(@RequestParam int userId){
        List<MyComment> comments = commentService.getCommentFromMe(userId);
        JSONObject message = new JSONObject();
        if (comments == null){
            message.put("result", "null");
        } else {
            message.put("result", comments);
        }
        return message.toJSONString();
    }

    /**
     * 删除评论
     * @param commentId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    public String deleteComment(@RequestParam int commentId, @RequestParam int userId){
        String result = commentService.deleteComment(commentId, userId);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }

    /**
     * 清空用户评论
     * @param userId
     * @return
     */
    @RequestMapping(value = "/clearCommentByUser", method = RequestMethod.POST)
    public String clearCommentByUser(@RequestParam int userId){
        String result = commentService.clearCommentByUser(userId);
        JSONObject message = new JSONObject();
        message.put("result", result);
        return message.toJSONString();
    }
}
