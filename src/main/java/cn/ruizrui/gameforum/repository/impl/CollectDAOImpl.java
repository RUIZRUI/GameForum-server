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
import cn.ruizrui.gameforum.helper.GameHelper;

public class CollectDAOImpl extends baseDAO implements CollectDAO{

	@Override
	public List<CollectInfo> getCollectionByUserId(int userId) {
		List<CollectInfo> collections = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String game_id = null;
		String game_name = null;
		String game_type = null;
		String game_platform = null;
		String game_belong = null;
		String game_img = null;
		String sql = "select game_id, game_name, game_type, game_platform, game_belong, game_img from collection where user_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				game_id = rs.getString("game_id");
				game_name = rs.getString("game_name");
				game_type = rs.getString("game_type");
				game_platform = rs.getString("game_platform");
				game_belong = rs.getString("game_belong");
				game_img = rs.getString("game_img");
				CollectInfo c = new CollectInfo(game_id, game_name, game_type, game_img, game_platform, game_belong);
				collections.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return collections;
	}

	@Override
	public boolean cancelCollection(int userId, String gameId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "delete from collection where user_id=? and game_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setString(2, gameId);
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public boolean clearCollection(int userId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "delete from collection where user_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	public boolean addCollection(int userId, String gameId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		GameHelper gameHelper = new GameHelper();
		boolean result = false;
		String sql = "insert into collection(user_id, game_id, game_name, game_type, game_platform, game_belong, game_img) " +
				" values(?, ?, ?, ?, ?, ?, ?)";
		try {
			String gameBelong = gameHelper.getGameBelongById(gameId);
			CollectInfo collectInfo = new CollectInfo();
			collectInfo.setGame_belong(gameBelong);
			switch(gameBelong) {
				case "单机游戏":
					SingleGame singleGame = gameHelper.getSingleGameById(gameId);
					collectInfo.setGame_name(singleGame.getGame_name());
					collectInfo.setGame_type(singleGame.getGame_type());
					collectInfo.setGame_platform(singleGame.getGame_platform());
					collectInfo.setGame_img(singleGame.getGame_img());
					break;
				case "安卓游戏":
					AndroidGame androidGame = gameHelper.getAndroidGameById(gameId);
					collectInfo.setGame_name(androidGame.getGame_name());
					collectInfo.setGame_type(androidGame.getGame_type());
					collectInfo.setGame_platform(androidGame.getGame_platform());
					collectInfo.setGame_img(androidGame.getGame_img());
					break;
				case "苹果游戏":
					IOSGame iosGame = gameHelper.getIOSGameById(gameId);
					collectInfo.setGame_name(iosGame.getGame_name());
					collectInfo.setGame_type(iosGame.getGame_type());
					collectInfo.setGame_platform(iosGame.getGame_platform());
					collectInfo.setGame_img(iosGame.getGame_img());
					break;
				case "网页游戏":
					OnlineGame onlineGame = gameHelper.getOnlineGameById(gameId);
					collectInfo.setGame_name(onlineGame.getGame_name());
					collectInfo.setGame_type(onlineGame.getGame_type());
					collectInfo.setGame_platform("网页");
					collectInfo.setGame_img(onlineGame.getGame_img());
					break;
				default:
					return false;
			}
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setString(2, gameId);
			pst.setString(3, collectInfo.getGame_name());
			pst.setString(4, collectInfo.getGame_type());
			pst.setString(5, collectInfo.getGame_platform());
			pst.setString(6, collectInfo.getGame_belong());
			pst.setString(7, collectInfo.getGame_img());
			pst.executeUpdate();
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public boolean isExistCollection(int userId, String gameId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select * from collection where user_id = ? and game_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setString(2, gameId);
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
