package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.UserDAO;
import DAO.baseDAO;
import entity.UserEntity;

public class UserDAOImpl extends baseDAO implements UserDAO{

	@Override
	public UserEntity getByName(String userName) {
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserEntity usertemp=new UserEntity();
		String sql="select * from user where user_name=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			usertemp.setUser_id(rs.getInt("user_id"));
			usertemp.setPassword(rs.getString("password"));
			usertemp.setPriority(rs.getString("priority"));
			usertemp.setFans_number(rs.getInt("fans_number"));
			usertemp.setLogintime(rs.getTimestamp("logintime"));
			usertemp.setUser_name(rs.getString("user_name"));
			usertemp.setPhone(rs.getString("phone"));
			usertemp.setMail(rs.getString("mail"));
			usertemp.setStatus(rs.getBoolean("status"));
			usertemp.setImg(rs.getString("img"));
			usertemp.setFollow_number(rs.getInt("follow_number"));
			usertemp.setSex(rs.getString("sex"));
			usertemp.setBirthdate(rs.getString("birthdate"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return usertemp;
	}

	public boolean addUser(UserEntity ue) {
		LoginLogDAOImpl li=new LoginLogDAOImpl();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql1="insert into user(password,priority,user_name,phone,mail,status) values(?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, ue.getPassword());
			pstmt.setString(2,"用户");
			pstmt.setString(3, ue.getUser_name());
			pstmt.setString(4, ue.getPhone());
			pstmt.setString(5, ue.getMail());
			pstmt.setBoolean(6, true);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		li.log(ue.getUser_name());
		closeAll(con,pstmt,rs);
		return true;
	}
	public boolean addUserAll(UserEntity ue) {
		// TODO �Զ����ɵķ������
		LoginLogDAOImpl li=new LoginLogDAOImpl();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql1="insert into user(password,priority,fans_number,user_name,phone,mail,"
				+ "status,img,follow_number,sex,birthdate) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, ue.getPassword());
			pstmt.setString(2,"用户");
			pstmt.setInt(3,0);
			pstmt.setString(4, ue.getUser_name());
			pstmt.setString(5, ue.getPhone());
			pstmt.setString(6, ue.getMail());
			pstmt.setBoolean(7, true);
			pstmt.setString(8, ue.getImg());
			pstmt.setInt(9, 0);
			pstmt.setString(10, ue.getSex());
			pstmt.setString(11, ue.getBirthdate());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		li.log(ue.getUser_name());
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean updateUser(UserEntity ue) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql1="update user set user_name=?,mail=?,phone=?,sex=?,birthdate=? where user_id=?";
		try {
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, ue.getUser_name());
			pstmt.setString(2,ue.getMail());
			pstmt.setString(3,ue.getPhone());
			pstmt.setString(4, ue.getSex());
			pstmt.setString(5, ue.getBirthdate());
			pstmt.setInt(6, ue.getUser_id());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public int getUserId(String userName) {
		// TODO �Զ����ɵķ������
		int userid=0;
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select user_id from user where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userid=rs.getInt(1);
			}else {
				return -1;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return userid;
	}

	@Override
	public String getUserName(int userId) {
		// TODO �Զ����ɵķ������
		String  user_name=null;
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select user_name from user where user_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				user_name=rs.getString("user_name");
			}else {
				return null;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return user_name;
	}

	@Override
	public int getUserNumber() {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(user_id) from user";
		int number=0;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				number=rs.getInt(1);
			}else {
				return -1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return number;
	}

	@Override
	public boolean setStatusOn(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set status=? where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, true);
			pstmt.setString(2,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;

	}

	@Override
	public boolean setStatusDown(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set status=? where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, false);
			pstmt.setString(2,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from user where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean promoteUser(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set priority = ? where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,"版主");
			pstmt.setString(2, userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean setUserAvater(String userName, String imgUrl) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set img = ? where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,imgUrl);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public ArrayList<UserEntity> getTotalUsers() {
		// TODO �Զ����ɵķ������
		ArrayList<UserEntity> allUsers=new ArrayList<UserEntity>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		String sql="select * from user";
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			UserEntity usertemp=new UserEntity();
				usertemp.setUser_id(rs.getInt("user_id"));
				usertemp.setPassword(rs.getString("password"));
				usertemp.setPriority(rs.getString("priority"));
				usertemp.setFans_number(rs.getInt("fans_number"));
				usertemp.setLogintime(rs.getTimestamp("logintime"));
				usertemp.setUser_name(rs.getString("user_name"));
				usertemp.setPhone(rs.getString("phone"));
				usertemp.setMail(rs.getString("mail"));
				usertemp.setStatus(rs.getBoolean("status"));
				usertemp.setImg(rs.getString("img"));
				usertemp.setFollow_number(rs.getInt("follow_number"));
				usertemp.setSex(rs.getString("sex"));
				usertemp.setBirthdate(rs.getString("birthdate"));
				allUsers.add(usertemp);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return allUsers;
	}

	@Override
	public boolean addFansNumber(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set fans_number = fans_number +1 where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean reduceFansNumber(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set fans_number = fans_number-1 where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean addFollowNumber(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set follow_number = follow_number +1 where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean reduceFollowNumber(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="update user set follow_number = follow_number -1 where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

}
