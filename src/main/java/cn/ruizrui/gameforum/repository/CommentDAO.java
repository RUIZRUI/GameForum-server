package cn.ruizrui.gameforum.repository;

import java.util.List;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.MyComment;

public interface CommentDAO {
	public List<MyComment> getCommentsToMe(int userId);
	public List<MyComment> getCommentsFromMe(int userId);
	public boolean deleteComment(int commentId,String userName);
	public boolean clearComment(String userName);
	public List<Comment> getCommentsByGameId(String gameId);
	public boolean commentGame(int userIdFrom, String gameId, String content);
	public boolean commentComment(String userName,int commentId,String content);
	public boolean likes(int commentId);
	public boolean dislike(int commentId);
}
