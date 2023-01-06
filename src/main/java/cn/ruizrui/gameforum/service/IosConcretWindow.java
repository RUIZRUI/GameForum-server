package cn.ruizrui.gameforum.service;

import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.IOSDAOImpl;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.IOSGame;

public class IosConcretWindow {
	IOSDAOImpl ai=new IOSDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;
public ArrayList<Comment> getComment(String gameName){
	return comments=ci.getCommentByGameName(gameName);
}
public IOSGame getGame(String gameId) {
	return ai.getGameById(gameId);
}
}
