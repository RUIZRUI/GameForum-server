package cn.ruizrui.gameforum.service;

import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.OnlineDAOImpl;

import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.OnlineGame;

public class OnlineConcretWindow {
	OnlineDAOImpl ai=new OnlineDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;
public ArrayList<Comment> getComment(String gameName){
	return comments=ci.getCommentByGameName(gameName);
}
public OnlineGame getGame(String gameId) {
	return ai.getGameById(gameId);
}
}
