package window;

import java.util.ArrayList;
import DAO.impl.CommentDAOImpl;
import DAO.impl.IosDAOImpl;
import entity.Comment;
import entity.IosGame;

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
