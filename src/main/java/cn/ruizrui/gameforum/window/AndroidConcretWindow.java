package cn.ruizrui.gameforum.window;

import java.util.ArrayList;

import cn.ruizrui.gameforum.DAO.impl.AndroidDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.entity.AndroidGame;
import cn.ruizrui.gameforum.entity.Comment;

public class AndroidConcretWindow {
	AndroidDAOImpl ai=new AndroidDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;

	public ArrayList<Comment> getComment(String gameName){
		return comments=ci.getCommentByGameName(gameName);
	}
	
	public AndroidGame getGame(String gameName) {
		return ai.getGameByName(gameName);
	}
}
