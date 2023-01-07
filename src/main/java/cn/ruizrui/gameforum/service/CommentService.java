package cn.ruizrui.gameforum.service;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.MyComment;
import cn.ruizrui.gameforum.proxy.ProxyUser;
import cn.ruizrui.gameforum.proxy.UserInterface;
import cn.ruizrui.gameforum.repository.CommentDAO;
import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentDAO commentDAO = new CommentDAOImpl();

    private UserInterface proxy = new ProxyUser("用户");

    /**
     * 获取一个游戏的所有评论
     * @param gameId
     * @return
     */
    public List<Comment> getCommentByGame(String gameId){
        return commentDAO.getCommentsByGameId(gameId);
    }

    /**
     * 发布评论
     * @param userIdFrom
     * @param gameId
     * @param content
     * @return
     */
    public boolean publishComment(int userIdFrom, String gameId, String content){
        return proxy.commentGame(userIdFrom, gameId, content);
    }

    /**
     * 获取回复我的评论列表
     * @param userId
     * @return
     */
    public List<MyComment> getCommentToMe(int userId){
        return proxy.getCommentToMe(userId);
    }

    /**
     * 获取我发布的评论列表
     * @param userId
     * @return
     */
    public List<MyComment> getCommentFromMe(int userId){
        return proxy.getCommentFromMe(userId);
    }

    /**
     * 删除评论
     * @param commentId
     * @param userId
     * @return
     */
    public String deleteComment(int commentId, int userId){
        return proxy.deleteCommentFromMe(commentId);
    }

    /**
     * 清空用户评论
     * @param userId
     * @return
     */
    public String clearCommentByUser(int userId){
        return proxy.cleanCommentFromMe(userId);
    }
}
