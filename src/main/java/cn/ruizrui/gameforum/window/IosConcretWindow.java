package cn.ruizrui.gameforum.window;

import java.util.ArrayList;
import cn.ruizrui.gameforum.DAO.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.IosDAOImpl;
import cn.ruizrui.gameforum.entity.Comment;
import cn.ruizrui.gameforum.entity.IosGame;

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
