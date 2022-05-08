package window;

import java.util.ArrayList;

import DAO.impl.CommentDAOImpl;
import DAO.impl.SingleDAOImpl;
import entity.Comment;
import entity.SingleGame;

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
