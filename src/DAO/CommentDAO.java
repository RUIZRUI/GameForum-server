package DAO;

import java.util.ArrayList;

import entity.Comment;

public interface CommentDAO {
	public ArrayList<Comment> getCommentsToMe(String userName);
	public ArrayList<Comment> getCommentsFromMe(String userName);
	public boolean deleteComment(int commentId,String userName);
	public boolean clearComment(String userName);
	public ArrayList<Comment> getCommentByGameName(String gameName);
	public boolean commentGame(String userName,String gameName,String content);
	public boolean commentComment(String userName,int commentId,String content);
	public boolean likes(int commentId);
	public boolean dislike(int commentId);
}
