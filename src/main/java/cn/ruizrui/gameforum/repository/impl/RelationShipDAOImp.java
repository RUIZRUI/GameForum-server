package cn.ruizrui.gameforum.repository.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.RelationshipDAO;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.User;

public class RelationShipDAOImp extends baseDAO implements RelationshipDAO {

	@Override
	//û�����ã����Ƿ�����user��
	public ArrayList<User> getMyFans(String userName) {
		// TODO �Զ����ɵķ������
		ArrayList<User> fans=new ArrayList<User>();
		ArrayList<String> fans_id=new ArrayList<String>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select a.fans_userid from user_relationship as a, user as b where a.main_userid=b.user_id and b.user_name =?";
		String sql2="select user_name,img from user where user_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				fans_id.add(rs.getString(1));
			}
			for(int i=0;i<fans_id.size();i++) {
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1, fans_id.get(i));
				rs=pstmt.executeQuery();
				while(rs.next()) {
					User ue=new User();
					ue.setUser_name(rs.getString("user_name"));
					ue.setImg(rs.getString("img"));
					fans.add(ue);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return fans;
	}

	@Override
	public ArrayList<User> getMyFollow(String userName) {
		// TODO �Զ����ɵķ������
		ArrayList<User> follows=new ArrayList<User>();
		ArrayList<Integer> follows_id=new ArrayList<Integer>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select a.main_userid from user_relationship as a, user as b where a.fans_userid=b.user_id and b.user_name =?";
		String sql2="select user_name,img from user where user_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				follows_id.add(rs.getInt(1));
			}
			for(int i=0;i<follows_id.size();i++) {
				pstmt=con.prepareStatement(sql2);
				pstmt.setInt(1, follows_id.get(i));
				rs=pstmt.executeQuery();
				while(rs.next()) {
					User ue=new User();
					ue.setUser_name(rs.getString("user_name"));
					ue.setImg(rs.getString("img"));
					follows.add(ue);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
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
