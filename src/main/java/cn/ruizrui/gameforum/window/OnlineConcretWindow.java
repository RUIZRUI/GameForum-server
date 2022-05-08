package window;

import java.util.ArrayList;

import DAO.impl.CommentDAOImpl;
import DAO.impl.OnlineDAOImpl;

import entity.Comment;
import entity.OnlineGame;

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
