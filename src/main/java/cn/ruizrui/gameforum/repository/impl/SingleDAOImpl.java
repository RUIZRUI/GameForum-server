package cn.ruizrui.gameforum.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cn.ruizrui.gameforum.repository.SingleDAO;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.SingleGame;

public class SingleDAOImpl extends baseDAO implements SingleDAO{

	@Override
	public ArrayList<SingleGame> getAllGames() {
		// TODO �Զ����ɵķ������
		ArrayList<SingleGame> allGames=new ArrayList<SingleGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game";
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
				SingleGame s_game=new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
				allGames.add(s_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return allGames;
	}

	@Override
	public ArrayList<SingleGame> getGameByType(String game_type) {
		// TODO �Զ����ɵķ������
		ArrayList<SingleGame> typeGames=new ArrayList<SingleGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game where game_type=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, game_type);
		rs=pstmt.executeQuery();
		while(rs.next()) {
				SingleGame s_game=new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
				typeGames.add(s_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return typeGames;
	}

	@Override
	public ArrayList<SingleGame> getGameByDevelop(String game_develop) {
		// TODO �Զ����ɵķ������
		ArrayList<SingleGame> developGames=new ArrayList<SingleGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game where game_develop=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, game_develop);
		rs=pstmt.executeQuery();
		while(rs.next()) {
				SingleGame s_game=new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
				developGames.add(s_game);
		}
	}catch(SQLException e) {
		System.out.println("��ȡ���е�����Ϸʱ����");
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return developGames;
	}
	@Override
	public SingleGame getGameById(String gameId) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from single_game where game_id=?";
		SingleGame s_game = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gameId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				s_game = new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
			}else {
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return s_game;
	}
	

	@Override
	public boolean addGame(SingleGame singleGame) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "insert into single_game(game_id, game_name, game_type, game_release, game_release_date, game_arrange_date, " +
				"game_platform, game_website, game_label, game_language, game_score, game_rater_num, game_img) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, singleGame.getGame_id());
			pst.setString(2, singleGame.getGame_name());
			pst.setString(3, singleGame.getGame_type());
			pst.setString(4, singleGame.getGame_release());
			pst.setDate(5, new Date(singleGame.getGame_release_date().getTime()));
			pst.setDate(6, new Date(singleGame.getGame_arrange_date().getTime()));
			pst.setString(7, singleGame.getGame_platform());
			pst.setString(8, singleGame.getGame_website());
			pst.setString(9, singleGame.getGame_label());
			pst.setString(10, singleGame.getGame_language());
			pst.setFloat(11, singleGame.getGame_score());
			pst.setInt(12, singleGame.getGame_rater_num());
			pst.setString(13, singleGame.getGame_img());
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public List<SingleGame> getSingleGameByTime() {
		// TODO �Զ����ɵķ������
		ArrayList<SingleGame> timegames=new ArrayList<SingleGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game order by game_release_date";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SingleGame s_game=new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
				timegames.add(s_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return timegames;
	}

	@Override
	public List<SingleGame> getSingleGameByRaterNum() {
		// TODO �Զ����ɵķ������
		ArrayList<SingleGame> timegames=new ArrayList<SingleGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game order by game_rater_num";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SingleGame s_game=new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
				timegames.add(s_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return timegames;
	}

	@Override
	public List<SingleGame> getSingleGameByScore() {
		// TODO �Զ����ɵķ������
		ArrayList<SingleGame> timegames=new ArrayList<SingleGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game order by game_score";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SingleGame s_game=new SingleGame();
				s_game.setGame_id(rs.getString("game_id"));
				s_game.setGame_name(rs.getString("game_name"));
				s_game.setGame_label(rs.getString("game_label"));
				s_game.setGame_release(rs.getString("game_release"));
				s_game.setGame_release_date(rs.getDate("game_release_date"));
				s_game.setGame_arrange_date(rs.getDate("game_arrange_date"));
				s_game.setGame_platform(rs.getString("game_platform"));
				s_game.setGame_language(rs.getString("game_language"));
				s_game.setGame_website(rs.getString("game_website"));
				s_game.setGame_type(rs.getString("game_type"));
				s_game.setGame_score(rs.getFloat("game_score"));
				s_game.setGame_rater_num(rs.getInt("game_rater_num"));
				s_game.setGame_img(rs.getString("game_img"));
				timegames.add(s_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return timegames;
	}

	@Override
	public boolean deleteGame(String gameId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "delete from single_game where game_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, gameId);
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public int getGameNumber() {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(game_id) from single_game";
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
	public String getGameIdByName(String gameName) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String gameId = null;
		String sql = "select game_id from single_game where game_name = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, gameName);
			rs = pst.executeQuery();
			if(rs.next()) {
				gameId = rs.getString("game_id");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return gameId;
	}


}
