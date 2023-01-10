package cn.ruizrui.gameforum.repository;

import java.util.List;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.MyComment;

public interface CommentDAO {
	List<MyComment> getCommentsToMe(int userId);
	List<MyComment> getCommentsFromMe(int userId);
	boolean deleteComment(int commentId);
	boolean clearComment(int userId);
	List<Comment> getCommentsByGameId(String gameId);
	boolean commentGame(int userIdFrom, String gameId, String content);
	boolean commentComment(String userName,int commentId,String content);
	boolean likes(int commentId);
	boolean dislike(int commentId);
}
