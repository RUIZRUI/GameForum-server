package cn.ruizrui.gameforum.window;

import java.util.ArrayList;

import cn.ruizrui.gameforum.DAO.impl.CommentDAOImpl;
import cn.ruizrui.gameforum.DAO.impl.SingleDAOImpl;
import cn.ruizrui.gameforum.entity.Comment;
import cn.ruizrui.gameforum.entity.SingleGame;

public class SingleConcretWindow {
	SingleDAOImpl si=new SingleDAOImpl();
	CommentDAOImpl ci=new CommentDAOImpl();
	ArrayList<Comment> comments=null;
public ArrayList<Comment> getComment(String gameName){
	return comments=ci.getCommentByGameName(gameName);
}
public SingleGame getGame(String gameName) {
	return si.getGameByName(gameName);
}
}
