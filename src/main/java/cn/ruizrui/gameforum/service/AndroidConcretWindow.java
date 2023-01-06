package cn.ruizrui.gameforum.service;

import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.impl.AndroidDAOImpl;
import cn.ruizrui.gameforum.repository.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.model.AndroidGame;
import cn.ruizrui.gameforum.model.Comment;

public class AndroidConcretWindow {
	AndroidDAOImpl ai=new AndroidDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;

	public ArrayList<Comment> getComment(String gameName){
		return comments=ci.getCommentByGameName(gameName);
	}
	
	public AndroidGame getGame(String gameId) {
		return ai.getGameById(gameId);
	}
}
