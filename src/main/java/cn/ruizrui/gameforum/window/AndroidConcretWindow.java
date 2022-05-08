package window;

import java.util.ArrayList;

import DAO.impl.AndroidDAOImpl;
import DAO.impl.CommentDAOImpl;
import entity.AndroidGame;
import entity.Comment;

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
