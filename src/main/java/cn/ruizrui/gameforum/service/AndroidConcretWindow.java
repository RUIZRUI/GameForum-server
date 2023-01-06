package cn.ruizrui.gameforum.service;

import java.util.List;

import cn.ruizrui.gameforum.repository.impl.AndroidDAOImpl;
import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.Comment;

public class AndroidConcretWindow {
	AndroidDAOImpl ai=new AndroidDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	List<Comment> comments=null;

	public List<Comment> getComment(String gameId){
		return comments=ci.getCommentsByGameId(gameId);
	}
	
	public AndroidGame getGame(String gameId) {
		return ai.getGameById(gameId);
	}
}
