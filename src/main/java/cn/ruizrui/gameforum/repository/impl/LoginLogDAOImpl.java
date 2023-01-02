package cn.ruizrui.gameforum.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.repository.loginLogDAO;

public class LoginLogDAOImpl extends baseDAO implements loginLogDAO{

	@Override
	public int getDay() {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int number=0;
		Date date=new Date(new java.util.Date().getTime());
		String sql="select count(distinct user_id) from login_log where to_days(login_time)=to_days(?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setDate(1, date);
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
	public int getMonth() {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int number=0;
		Date date=new Date(new java.util.Date().getTime());
		String sql="select count(distinct user_id) from login_log where month(login_time)=month(?) and year(login_time) = year(?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setDate(1, date);
			pstmt.setDate(2, date);
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
	public boolean log(String userName) {
		UserDAOImpl ui=new UserDAOImpl();
		int user_id=ui.getUserId(userName);
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Date login_time=new Date(new java.util.Date().getTime());
		String sql="insert into login_log(user_id,login_time) values(?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setDate(2, login_time);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return true;
	}

}
