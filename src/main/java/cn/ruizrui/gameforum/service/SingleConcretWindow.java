package cn.ruizrui.gameforum.service;

import java.util.List;

import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.SingleGame;

public class SingleConcretWindow {
	SingleDAOImpl si=new SingleDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	List<Comment> comments=null;
	public List<Comment> getComment(String gameId){
		return comments=ci.getCommentsByGameId(gameId);
	}
	public SingleGame getGame(String gameId) {
		return si.getGameById(gameId);
	}
}
