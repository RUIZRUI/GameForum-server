package cn.ruizrui.gameforum.window;

import java.util.ArrayList;

import cn.ruizrui.gameforum.DAO.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.OnlineDAOImpl;

import cn.ruizrui.gameforum.entity.Comment;
import cn.ruizrui.gameforum.entity.OnlineGame;

public class OnlineConcretWindow {
	OnlineDAOImpl ai=new OnlineDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;
public ArrayList<Comment> getComment(String gameName){
	return comments=ci.getCommentByGameName(gameName);
}
public OnlineGame getGame(String gameName) {
	return ai.getGameByName(gameName);
}
}
