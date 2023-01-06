package cn.ruizrui.gameforum.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.repository.CollectDAO;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.*;
import cn.ruizrui.gameforum.factory.AbstractFactory;
import cn.ruizrui.gameforum.factory.AndroidGameCreator;
import cn.ruizrui.gameforum.factory.IosGameCreator;
import cn.ruizrui.gameforum.factory.OnlineGameCreator;
import cn.ruizrui.gameforum.factory.SingleGameCreator;
import cn.ruizrui.gameforum.helper.JudgeGame;

public class CollectDAOImpl extends baseDAO implements CollectDAO{

	@Override
	public List<CollectInfo> getCollectionByUserId(int userId) {
		// TODO �Զ����ɵķ������
		List<CollectInfo> collections = new ArrayList<CollectInfo>();
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String game_name = null;
		String game_type = null;
		String game_platform = null;
		String game_belong = null;
		String game_img = null;
		String sql = "select game_name,game_type,game_platform,game_belong,game_img from collection where user_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				game_name = rs.getString("game_name");
				game_type = rs.getString("game_type");
				game_platform = rs.getString("game_platform");
				game_belong = rs.getString("game_belong");
				game_img = rs.getString("game_img");
				CollectInfo c = new CollectInfo(game_name,game_type,game_img,game_platform,game_belong);
				collections.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return collections;
	}

	@Override
	public boolean cancelCollection(String userName, String gameName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from collection where game_name=? and user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,gameName);
			pstmt.setString(2, userName);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public boolean clearCollection(String userName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from collection where user_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return true;
	}

	public boolean addCollection(String userName,String gameName) {
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		JudgeGame jg=new JudgeGame();
		UserDAOImpl ui=new UserDAOImpl();
		int user_id=ui.getUserId(userName);
		AbstractFactory af;
		int number=-1;
		if(jg.judgeSingle(gameName)!=null) {
			number=0;
		}else if(jg.judgeAndroid(gameName)!=null) {
			number=1;
		}else if(jg.judgeIOS(gameName)!=null) {
			number=2;
		}else if(jg.judgeOnline(gameName)!=null) {
			number=3;
		}else {
			return false;
		}
		String sql="insert into collection(user_id,user_name,game_id,game_name,game_type,game_platform,"
				+ "game_belong,game_img) values(?,?,?,?,?,?,?,?)";
		try {
		switch(number) {
		case 0:
		af=new SingleGameCreator();
		SingleGame sgame=jg.judgeSingle(gameName);
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, userName);
		pstmt.setString(3,sgame.getGame_id());
		pstmt.setString(4, gameName);
		pstmt.setString(5, sgame.getGame_type());
		pstmt.setString(6, sgame.getGame_platform());
		pstmt.setString(7, "网页游戏");
		pstmt.setString(8, sgame.getGame_img());
        pstmt.executeUpdate();
		break;
		case 1:af=new AndroidGameCreator();
		MobileGame ag=af.createMoblieGame();
		ag=jg.judgeAndroid(gameName);
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, userName);
		pstmt.setString(3,ag.getGame_id());
		pstmt.setString(4, gameName);
		pstmt.setString(5, ag.getGame_type());
		pstmt.setString(6, ag.getGame_platform());
		pstmt.setString(7, "安卓游戏");
		pstmt.setString(8, ag.getGame_img());
		pstmt.executeUpdate();
		break;
		case 2:af=new IosGameCreator();
		MobileGame ig=af.createMoblieGame();
		ig=jg.judgeIOS(gameName);
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, userName);
		pstmt.setString(3,ig.getGame_id());
		pstmt.setString(4, gameName);
		pstmt.setString(5, ig.getGame_type());
		pstmt.setString(6, ig.getGame_platform());
		pstmt.setString(7, "苹果游戏");
		pstmt.setString(8, ig.getGame_img());
		pstmt.executeUpdate();
		break;
		case 3:af=new OnlineGameCreator();
		HostGame hg=af.createHostGame();
		hg=jg.judgeOnline(gameName);
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setString(2, userName);
		pstmt.setString(3,hg.getGame_id());
		pstmt.setString(4, gameName);
		pstmt.setString(5, hg.getGame_type());
		pstmt.setString(6, "网页");
		pstmt.setString(7, "网页游戏");
		pstmt.setString(8, hg.getGame_img());
		pstmt.executeUpdate();
		break;
		default:return false;
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return true;
	}
}
