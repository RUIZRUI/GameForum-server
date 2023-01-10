package cn.ruizrui.gameforum.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.IOSDAO;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.IOSGame;

public class IOSDAOImpl extends baseDAO implements IOSDAO {

	@Override
	public ArrayList<IOSGame> getAllGames() {
		ArrayList<IOSGame> allGames=new ArrayList<IOSGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game";

	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			IOSGame i_game=new IOSGame();
				i_game.setGame_id(rs.getString(1));
				i_game.setGame_name(rs.getString(2));
				i_game.setGame_slogan(rs.getString(3));
				i_game.setGame_version(rs.getString(4));
				i_game.setGame_platform(rs.getString(5));
				i_game.setGame_type(rs.getString(6));
				i_game.setGame_release_date(rs.getDate(7));
				i_game.setGame_release(rs.getString(8));
				i_game.setGame_language(rs.getString(9));
				i_game.setGame_score(rs.getFloat(10));
				i_game.setGame_rater_num(rs.getInt(11));
				i_game.setGame_img(rs.getString(12));
				allGames.add(i_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return allGames;
	}

	@Override
	public IOSGame getGameById(String gameId) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		IOSGame i_game = null;
		String sql = "select * from ios_game where game_id=?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gameId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i_game = new IOSGame();
				i_game.setGame_id(rs.getString(1));
				i_game.setGame_name(rs.getString(2));
				i_game.setGame_slogan(rs.getString(3));
				i_game.setGame_version(rs.getString(4));
				i_game.setGame_platform(rs.getString(5));
				i_game.setGame_type(rs.getString(6));
				i_game.setGame_release_date(rs.getDate(7));
				i_game.setGame_release(rs.getString(8));
				i_game.setGame_language(rs.getString(9));
				i_game.setGame_score(rs.getFloat(10));
				i_game.setGame_rater_num(rs.getInt(11));
				i_game.setGame_img(rs.getString(12));
			}else {
				return null;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return i_game; 
	}

	@Override
	public ArrayList<IOSGame> getGameByType(String game_type) {
		ArrayList<IOSGame> typeGames=new ArrayList<IOSGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game where game_type=?";

	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_type);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			IOSGame i_game=new IOSGame();
				i_game.setGame_id(rs.getString(1));
				i_game.setGame_name(rs.getString(2));
				i_game.setGame_slogan(rs.getString(3));
				i_game.setGame_version(rs.getString(4));
				i_game.setGame_platform(rs.getString(5));
				i_game.setGame_type(rs.getString(6));
				i_game.setGame_release_date(rs.getDate(7));
				i_game.setGame_release(rs.getString(8));
				i_game.setGame_language(rs.getString(9));
				i_game.setGame_score(rs.getFloat(10));
				i_game.setGame_rater_num(rs.getInt(11));
				i_game.setGame_img(rs.getString(12));
				typeGames.add(i_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return typeGames;
	}

	@Override
	public boolean addGame(IOSGame iosGame){
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "insert into ios_game(game_id, game_name, game_slogan, game_version, game_platform, game_type, " +
				"game_release_date, game_release, game_language, game_score, game_rater_num, game_img) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, iosGame.getGame_id());
			pst.setString(2, iosGame.getGame_name());
			pst.setString(3, iosGame.getGame_slogan());
			pst.setString(4, iosGame.getGame_version());
			pst.setString(5, iosGame.getGame_platform());
			pst.setString(6, iosGame.getGame_type());
			pst.setDate(7, new Date(iosGame.getGame_release_date().getTime()));
			pst.setString(8, iosGame.getGame_release());
			pst.setString(9, iosGame.getGame_language());
			pst.setDouble(10, iosGame.getGame_score());
			pst.setInt(11, iosGame.getGame_rater_num());
			pst.setString(12, iosGame.getGame_img());
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public ArrayList<IOSGame> getGameByTime() {
		ArrayList<IOSGame> timegames=new ArrayList<IOSGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game order by game_release_date";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				IOSGame i_game=new IOSGame();
				i_game.setGame_id(rs.getString(1));
				i_game.setGame_name(rs.getString(2));
				i_game.setGame_slogan(rs.getString(3));
				i_game.setGame_version(rs.getString(4));
				i_game.setGame_platform(rs.getString(5));
				i_game.setGame_type(rs.getString(6));
				i_game.setGame_release_date(rs.getDate(7));
				i_game.setGame_release(rs.getString(8));
				i_game.setGame_language(rs.getString(9));
				i_game.setGame_score(rs.getFloat(10));
				i_game.setGame_rater_num(rs.getInt(11));
				i_game.setGame_img(rs.getString(12));
				timegames.add(i_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return timegames;
	}

	@Override
	public ArrayList<IOSGame> getGameByRaterNum() {
		ArrayList<IOSGame> raternumgames=new ArrayList<IOSGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game order by game_rater_num";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				IOSGame i_game=new IOSGame();
				i_game.setGame_id(rs.getString(1));
				i_game.setGame_name(rs.getString(2));
				i_game.setGame_slogan(rs.getString(3));
				i_game.setGame_version(rs.getString(4));
				i_game.setGame_platform(rs.getString(5));
				i_game.setGame_type(rs.getString(6));
				i_game.setGame_release_date(rs.getDate(7));
				i_game.setGame_release(rs.getString(8));
				i_game.setGame_language(rs.getString(9));
				i_game.setGame_score(rs.getFloat(10));
				i_game.setGame_rater_num(rs.getInt(11));
				i_game.setGame_img(rs.getString(12));
				raternumgames.add(i_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return raternumgames;
	}

	@Override
	public ArrayList<IOSGame> getGameByScore() {
		ArrayList<IOSGame> scoregames=new ArrayList<IOSGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game order by game_score";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				IOSGame i_game=new IOSGame();
				i_game.setGame_id(rs.getString(1));
				i_game.setGame_name(rs.getString(2));
				i_game.setGame_slogan(rs.getString(3));
				i_game.setGame_version(rs.getString(4));
				i_game.setGame_platform(rs.getString(5));
				i_game.setGame_type(rs.getString(6));
				i_game.setGame_release_date(rs.getDate(7));
				i_game.setGame_release(rs.getString(8));
				i_game.setGame_language(rs.getString(9));
				i_game.setGame_score(rs.getFloat(10));
				i_game.setGame_rater_num(rs.getInt(11));
				i_game.setGame_img(rs.getString(12));
				scoregames.add(i_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return scoregames;
	}

	@Override
	public boolean deleteGame(String gameId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "delete from ios_game where game_id = ?";
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
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(game_id) from ios_game";
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
		String sql = "select game_id from ios_game where game_name = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, gameName);
			rs = pst.executeQuery();
			if(rs.next()) {
				gameId = rs.getString("game_id");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, rs);
		return gameId;
	}

}
