package cn.ruizrui.gameforum.repository.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import cn.ruizrui.gameforum.model.RelationUser;
import cn.ruizrui.gameforum.repository.RelationshipDAO;
import cn.ruizrui.gameforum.repository.SingleDAO;
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
	public boolean cancelFollow(int idolUserId, int fanUserId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "delete from user_relationship where main_userid = ? and fans_userid = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idolUserId);
			pst.setInt(2, fanUserId);
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public boolean followUser(int idolUserId, int fanUserId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "insert into user_relationship values(?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idolUserId);
			pst.setInt(2, fanUserId);
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public boolean isExistFollow(int idolUserId, int fanUserId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select * from user_relationship where main_userid = ? and fans_userid = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idolUserId);
			pst.setInt(2, fanUserId);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return result;
	}
}
