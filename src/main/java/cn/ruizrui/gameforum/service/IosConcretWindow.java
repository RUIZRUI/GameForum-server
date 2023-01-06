package cn.ruizrui.gameforum.service;

import java.util.List;
import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.IOSDAOImpl;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.IOSGame;

public class IosConcretWindow {
	IOSDAOImpl ai=new IOSDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	List<Comment> comments=null;
	public List<Comment> getComment(String gameId){
		return comments=ci.getCommentsByGameId(gameId);
	}
	public IOSGame getGame(String gameId) {
		return ai.getGameById(gameId);
	}
}
