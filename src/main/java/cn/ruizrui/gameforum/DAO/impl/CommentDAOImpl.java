package DAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.CommentDAO;
import DAO.baseDAO;
import entity.Comment;
import tools.JudgeGame;

public class CommentDAOImpl extends baseDAO implements CommentDAO{

	@Override
	public ArrayList<Comment> getCommentsToMe(String userName) {
		// TODO �Զ����ɵķ������
		ArrayList<Comment> Comments=new ArrayList<Comment>();
		ArrayList<Integer> comment_id=new ArrayList<Integer>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select comment_id from comments where user_id=?";
		String sql2="select * from  comments where parent_id=?";
		try{
			pstmt=con.prepareStatement(sql);
			UserDAOImpl ui=new UserDAOImpl();
			int user_id=ui.getUserId(userName);
			pstmt.setInt(1, user_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				comment_id.add(rs.getInt(1));
			}
			for(int i=0;i<comment_id.size();i++) {
				pstmt=con.prepareStatement(sql2);
				pstmt.setInt(1, comment_id.get(i));
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Comment c=new Comment();
					c.setComment_id(rs.getInt("comment_id"));
					c.setComment_name(ui.getUserName(rs.getInt("user_id")));
					c.setGame_name(rs.getString("game_name"));
					c.setTimestamp(rs.getTimestamp("time"));
					c.setContent(rs.getString("content"));
					Comments.add(c);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return Comments;
	}

	@Override
	public ArrayList<Comment> getCommentsFromMe(String userName) {
		// TODO �Զ����ɵķ������
		ArrayList<Comment> Comments=new ArrayList<Comment>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from comments where user_id=? and parent_id = -1";
		String sql3="select a.comment_id,b.user_id,a.game_name,a.time,a.content from comments as a,"
				+ "comments as b where b.comment_id=a.parent_id and a.user_id=?";
		try{
			pstmt=con.prepareStatement(sql);
			UserDAOImpl ui=new UserDAOImpl();
			int user_id=ui.getUserId(userName);
			pstmt.setInt(1, user_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Comment c=new Comment();
				c.setComment_id(rs.getInt("comment_id"));
				c.setComment_name(null);
				c.setGame_name(rs.getString("game_name"));
				c.setTimestamp(rs.getTimestamp("time"));
				c.setContent(rs.getString("content"));
				Comments.add(c);
			}
				pstmt=con.prepareStatement(sql3);
				pstmt.setInt(1, user_id);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Comment c=new Comment();
					c.setComment_id(rs.getInt(1));
					c.setComment_name(ui.getUserName(rs.getInt(2)));
					c.setGame_name(rs.getString(3));
					c.setTimestamp(rs.getTimestamp(4));
					c.setContent(rs.getString(5));
					Comments.add(c);
				}
		}catch(SQLException e){
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return Comments;
	}

	@Override
	public boolean deleteComment(int commentId,String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserDAOImpl ui=new UserDAOImpl();
		int user_id=ui.getUserId(userName);
		String sql="delete from comments where comment_id=? and user_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, commentId);
			pstmt.setInt(2, user_id);
			System.out.println(pstmt.executeUpdate());
		}catch(SQLException e) {
			e.printStackTrace();
		};
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean clearComment(String userName) {
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserDAOImpl ui=new UserDAOImpl();
		int user_id=ui.getUserId(userName);
		String sql="delete from comments where user_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		};
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public ArrayList<Comment> getCommentByGameName(String gameName) {
		// TODO �Զ����ɵķ������
		ArrayList<Comment> comments=new ArrayList<Comment>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from comments where game_name=?";
		UserDAOImpl ui=new UserDAOImpl();
		String user_name=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gameName);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Comment c=new Comment();
				c.setComment_id(rs.getInt("comment_id"));
				c.setContent(rs.getString("content"));
				c.setDislike(rs.getInt("dislike"));
				c.setGame_id(rs.getString("game_id"));
				c.setGame_name(rs.getString("game_name"));
				c.setLike(rs.getInt("like"));
				c.setParent_id(rs.getInt("like"));
				c.setTimestamp(rs.getTimestamp("time"));
				c.setUser_id(rs.getInt("user_id"));
				comments.add(c);
			}
			for(int i=0;i<comments.size();i++) {
				user_name=ui.getUserName(comments.get(i).getUser_id());
				comments.get(i).setComment_name(user_name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return comments;
	}

	@Override
	public boolean commentGame(String userName, String gameName,String content) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into comments(user_id,game_id,"
				+ "parent_id,content,likes,dislike,game_name) values(?,?,?,?,?,?,?)";
		UserDAOImpl ui=new UserDAOImpl();
		JudgeGame jg=new JudgeGame();
		String game_id=jg.getGameIdByName(gameName);
		int user_id=ui.getUserId(userName);
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setString(2, game_id);
			pstmt.setInt(3,-1);
			pstmt.setString(4, content);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setString(7,gameName);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean commentComment(String userName, int commentId,String content) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into comments(user_id,game_id,"
				+ "parent_id,content,likes,dislike,game_name) values(?,?,?,?,?,?,?)";
		String sql2="select game_id,game_name from comments where comment_id=?";
		UserDAOImpl ui=new UserDAOImpl();
		int user_id=ui.getUserId(userName);
		String game_id=null;
		String game_name=null;
		try {
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, commentId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				game_id=rs.getString("game_id");
			    game_name=rs.getString("game_name");
			}else {
				return false;
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setString(2, game_id);
			pstmt.setInt(3,commentId);
			pstmt.setString(4, content);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setString(7,game_name);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean likes(int commentId) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update comments set likes=likes+1 where comment_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, commentId);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		};
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean dislike(int commentId) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update comments set likes=likes-1 where comment_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, commentId);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		};
		closeAll(con,pstmt,rs);
		return true;
	}

}
