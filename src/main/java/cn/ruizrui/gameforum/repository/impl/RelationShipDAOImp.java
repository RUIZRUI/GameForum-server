package cn.ruizrui.gameforum.repository.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.RelationUser;
import cn.ruizrui.gameforum.repository.RelationshipDAO;
import cn.ruizrui.gameforum.repository.baseDAO;

public class RelationShipDAOImp extends baseDAO implements RelationshipDAO {

	@Override
	public List<RelationUser> getMyFans(int userId) {
		List<RelationUser> fans = new ArrayList<RelationUser>();
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select u.user_id, u.user_name, u.img from user_relationship as ur, user as u where ur.main_userid = ? and ur.fans_userid = u.user_id";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RelationUser relationUser = new RelationUser();
				relationUser.setUser_id(rs.getInt(1));
				relationUser.setUser_name(rs.getString(2));
				relationUser.setUser_avatar(rs.getString(3));
				fans.add(relationUser);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con, pstmt, rs);
		return fans;
	}

	@Override
	public List<RelationUser> getMyFollow(int userId) {
		List<RelationUser> follows = new ArrayList<RelationUser>();
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select u.user_id, u.user_name, u.img from user_relationship as ur, user as u where ur.fans_userid = ? and ur.main_userid = u.user_id";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RelationUser relationUser = new RelationUser();
				relationUser.setUser_id(rs.getInt(1));
				relationUser.setUser_name(rs.getString(2));
				relationUser.setUser_avatar(rs.getString(3));
				follows.add(relationUser);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con, pstmt, rs);
		return follows;
	}

	@Override
	public boolean cancelFollow(String userName, String followedUserName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		int user_id=0;
		int followed_id = 0;
		ResultSet rs=null;
		String sql2="delete from user_relationship where main_userid=? and fans_userid=?";
		try {
			UserDAOImpl ui=new UserDAOImpl();
			user_id=ui.getUserId(userName);
			followed_id=ui.getUserId(followedUserName);
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, followed_id);
			pstmt.setInt(2, user_id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean followUser(String userName, String fanUserName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		int user_id=0;
		int followed_id = 0;
		ResultSet rs=null;
		String sql2="insert into user_relationship values(?,?)";
		try {
			UserDAOImpl ui=new UserDAOImpl();
			user_id=ui.getUserId(userName);
			followed_id=ui.getUserId(fanUserName);
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, followed_id);
			pstmt.setInt(2, user_id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

}
