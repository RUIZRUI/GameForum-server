package cn.ruizrui.gameforum.repository.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.MyComment;
import cn.ruizrui.gameforum.repository.CommentDAO;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.Comment;

public class CommentDAOImpl extends baseDAO implements CommentDAO{

	@Override
	public List<MyComment> getCommentsFromMe(int userId) {
		List<MyComment> comments = null;
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select c.comment_id, if(c.user_id_to is null, null, u.user_name), bg.game_name, bg.game_belong, c.comment_time " +
				"from comments as c, user as u, base_game as bg " +
				"where c.user_id_from = ? and ((c.user_id_to is null and c.user_id_from = u.user_id) or c.user_id_to = u.user_id) and c.game_id = bg.game_id";
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			comments = new ArrayList<>();
			while(rs.next()) {
				MyComment comment = new MyComment();
				comment.setComment_id(rs.getInt(1));
				comment.setOther_name(rs.getString(2));
				comment.setGame_name(rs.getString(3));
				comment.setGame_belong(rs.getString(4));
				comment.setComment_time(rs.getDate(5));
				comments.add(comment);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return comments;
	}

	@Override
	public List<MyComment> getCommentsToMe(int userId) {
		List<MyComment> comments = null;
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql="select c.comment_id, u.user_name, bg.game_name, bg.game_belong, c.comment_time " +
				"from comments as c, user as u, base_game as bg " +
				"where c.user_id_to = ? and c.user_id_from = u.user_id and c.game_id = bg.game_id";
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			comments = new ArrayList<>();
			while(rs.next()) {
				MyComment comment = new MyComment();
				comment.setComment_id(rs.getInt(1));
				comment.setOther_name(rs.getString(2));
				comment.setGame_name(rs.getString(3));
				comment.setGame_belong(rs.getString(4));
				comment.setComment_time(rs.getDate(5));
				comments.add(comment);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return comments;
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
	public List<Comment> getCommentsByGameId(String gameId) {
		List<Comment> comments = null;
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select c.comment_id, c.user_id_from, c.parent_id, c.content, c.comment_time, u.img, u.user_name, u.priority " +
				"from comments as c, user as u " +
				"where c.game_id = ? and c.user_id_from = u.user_id;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, gameId);
			rs = pst.executeQuery();
			comments = new ArrayList<>();
			while(rs.next()) {
				Comment c = new Comment();
				c.setComment_id(rs.getInt(1));
				c.setUser_id_from(rs.getInt(2));
				c.setParent_id(rs.getInt(3));
				c.setContent(rs.getString(4));
				c.setComment_time(rs.getTimestamp(5).getTime());
				c.setImg(rs.getString(6));
				c.setUser_name(rs.getString(7));
				c.setPriority(rs.getString(8));
				comments.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return comments;
	}

	@Override
	public boolean commentGame(int userIdFrom, String gameId, String content) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into comments(user_id_from, game_id, content) values (?, ?, ?)";
		boolean result = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userIdFrom);
			pst.setString(2, gameId);
			pst.setString(3, content);
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return result;
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
