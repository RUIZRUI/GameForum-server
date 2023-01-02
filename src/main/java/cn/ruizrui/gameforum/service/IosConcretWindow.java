package cn.ruizrui.gameforum.service;

import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.repository.impl.IosDAOImpl;
import cn.ruizrui.gameforum.model.Comment;
import cn.ruizrui.gameforum.model.IosGame;

public class IosConcretWindow {
	IosDAOImpl ai=new IosDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;
public ArrayList<Comment> getComment(String gameName){
	return comments=ci.getCommentByGameName(gameName);
}
public IosGame getGame(String gameName) {
	return ai.getGameByName(gameName);
}
}
