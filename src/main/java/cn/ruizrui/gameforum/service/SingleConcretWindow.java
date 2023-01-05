package cn.ruizrui.gameforum.service;

import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.SingleGame;

public class SingleConcretWindow {
	SingleDAOImpl si=new SingleDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;
public ArrayList<Comment> getComment(String gameName){
	return comments=ci.getCommentByGameName(gameName);
}
public SingleGame getGame(String gameId) {
	return si.getGameById(gameId);
}
}
