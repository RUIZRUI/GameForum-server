package cn.ruizrui.gameforum.service;

import java.util.List;

import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.OnlineDAOImpl;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.OnlineGame;

public class OnlineConcretWindow {
	OnlineDAOImpl ai=new OnlineDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	List<Comment> comments=null;
public List<Comment> getComment(String gameId){
	return comments=ci.getCommentsByGameId(gameId);
}
public OnlineGame getGame(String gameId) {
	return ai.getGameById(gameId);
}
}
