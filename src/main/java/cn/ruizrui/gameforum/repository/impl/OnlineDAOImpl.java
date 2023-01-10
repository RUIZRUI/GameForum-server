package cn.ruizrui.gameforum.repository.impl;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.OnlineGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.OnlineDAO;
public class OnlineDAOImpl extends baseDAO implements OnlineDAO{

	@Override
	public ArrayList<OnlineGame> getAllGame() {
		ArrayList<OnlineGame> allGames=new ArrayList<OnlineGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from online_game";
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			OnlineGame o_game=new OnlineGame();
			o_game.setGame_id(rs.getString("game_id"));
			o_game.setGame_name(rs.getString("game_name"));
			o_game.setGame_hope_num(rs.getInt("game_hope_num"));
			o_game.setGame_type(rs.getString("game_type"));
			o_game.setGame_score(rs.getFloat("game_score"));
			o_game.setGame_rater_num(rs.getInt("game_rater_num"));
			o_game.setGame_img(rs.getString("game_img"));
			o_game.setGame_frame(rs.getString("game_frame"));
			o_game.setGame_develop(rs.getString("game_develop"));
			o_game.setGame_operator(rs.getString("game_operator"));
			o_game.setGame_status(rs.getString("game_status"));
			allGames.add(o_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return allGames;
	}

	@Override
	public OnlineGame getGameById(String gameId) {
		OnlineGame o_game = null;
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from online_game where game_id=?";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, gameId);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			o_game = new OnlineGame();
			o_game.setGame_id(rs.getString("game_id"));
			o_game.setGame_name(rs.getString("game_name"));
			o_game.setGame_hope_num(rs.getInt("game_hope_num"));
			o_game.setGame_type(rs.getString("game_type"));
			o_game.setGame_score(rs.getFloat("game_score"));
			o_game.setGame_rater_num(rs.getInt("game_rater_num"));
			o_game.setGame_img(rs.getString("game_img"));
			o_game.setGame_frame(rs.getString("game_frame"));
			o_game.setGame_develop(rs.getString("game_develop"));
			o_game.setGame_operator(rs.getString("game_operator"));
			o_game.setGame_status(rs.getString("game_status"));
			o_game.setGame_website(rs.getString("game_website"));
			o_game.setGame_label(rs.getString("game_label"));
		}else {
			return null;
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return o_game;
	}

	@Override
	public ArrayList<OnlineGame> getGameByType(String game_type) {
		ArrayList<OnlineGame> typeGames=new ArrayList<OnlineGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from online_game where game_type=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_type);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			OnlineGame o_game=new OnlineGame();
			o_game.setGame_id(rs.getString("game_id"));
			o_game.setGame_name(rs.getString("game_name"));
			o_game.setGame_hope_num(rs.getInt("game_hope_num"));
			o_game.setGame_type(rs.getString("game_type"));
			o_game.setGame_score(rs.getFloat("game_score"));
			o_game.setGame_rater_num(rs.getInt("game_rater_num"));
			o_game.setGame_img(rs.getString("game_img"));
			o_game.setGame_frame(rs.getString("game_frame"));
			o_game.setGame_develop(rs.getString("game_develop"));
			o_game.setGame_operator(rs.getString("game_operator"));
			o_game.setGame_status(rs.getString("game_status"));
			typeGames.add(o_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return typeGames;
	}

	@Override
	public ArrayList<OnlineGame> getGameByDevelop(String game_develop) {
		ArrayList<OnlineGame> developGames=new ArrayList<OnlineGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from online_game where game_develop=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_develop);
		rs=pstmt.executeQuery();
		while(rs.next()) {
		    OnlineGame o_game=new OnlineGame();
			o_game.setGame_id(rs.getString("game_id"));
			o_game.setGame_name(rs.getString("game_name"));
			o_game.setGame_hope_num(rs.getInt("game_hope_num"));
			o_game.setGame_type(rs.getString("game_type"));
			o_game.setGame_score(rs.getFloat("game_score"));
			o_game.setGame_rater_num(rs.getInt("game_rater_num"));
			o_game.setGame_img(rs.getString("game_img"));
			o_game.setGame_frame(rs.getString("game_frame"));
			o_game.setGame_develop(rs.getString("game_develop"));
			o_game.setGame_operator(rs.getString("game_operator"));
			o_game.setGame_status(rs.getString("game_status"));
			developGames.add(o_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return developGames;
	}

	@Override
	public boolean addGame(OnlineGame onlineGame) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "insert into online_game(game_id, game_name, game_hope_num, game_type, game_frame, game_develop, " +
				"game_operator, game_website, game_status, game_label, game_score, game_rater_num, game_img) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, onlineGame.getGame_id());
			pst.setString(2, onlineGame.getGame_name());
			pst.setInt(3, onlineGame.getGame_hope_num());
			pst.setString(4, onlineGame.getGame_type());
			pst.setString(5, onlineGame.getGame_frame());
			pst.setString(6, onlineGame.getGame_develop());
			pst.setString(7, onlineGame.getGame_operator());
			pst.setString(8, onlineGame.getGame_website());
			pst.setString(9, onlineGame.getGame_status());
			pst.setString(10, onlineGame.getGame_label());
			pst.setDouble(11, onlineGame.getGame_score());
			pst.setInt(12, onlineGame.getGame_rater_num());
			pst.setString(13, onlineGame.getGame_img());
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
	}

	@Override
	public ArrayList<OnlineGame> getGameByHopeNum() {
		ArrayList<OnlineGame> timegames=new ArrayList<OnlineGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from online_game order by game_hope_num";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OnlineGame o_game=new OnlineGame();
				o_game.setGame_id(rs.getString("game_id"));
				o_game.setGame_name(rs.getString("game_name"));
				o_game.setGame_hope_num(rs.getInt("game_hope_num"));
				o_game.setGame_type(rs.getString("game_type"));
				o_game.setGame_score(rs.getFloat("game_score"));
				o_game.setGame_rater_num(rs.getInt("game_rater_num"));
				o_game.setGame_img(rs.getString("game_img"));
				o_game.setGame_frame(rs.getString("game_frame"));
				o_game.setGame_develop(rs.getString("game_develop"));
				o_game.setGame_operator(rs.getString("game_operator"));
				o_game.setGame_status(rs.getString("game_status"));
				o_game.setGame_website(rs.getString("game_website"));
				o_game.setGame_label(rs.getString("game_label"));
				timegames.add(o_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return timegames;
	}

	@Override
	public ArrayList<OnlineGame> getGameByRaterNum() {
		ArrayList<OnlineGame> raternumgames=new ArrayList<OnlineGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from online_game order by game_rater_num";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OnlineGame o_game=new OnlineGame();
				o_game.setGame_id(rs.getString("game_id"));
				o_game.setGame_name(rs.getString("game_name"));
				o_game.setGame_hope_num(rs.getInt("game_hope_num"));
				o_game.setGame_type(rs.getString("game_type"));
				o_game.setGame_score(rs.getFloat("game_score"));
				o_game.setGame_rater_num(rs.getInt("game_rater_num"));
				o_game.setGame_img(rs.getString("game_img"));
				o_game.setGame_frame(rs.getString("game_frame"));
				o_game.setGame_develop(rs.getString("game_develop"));
				o_game.setGame_operator(rs.getString("game_operator"));
				o_game.setGame_status(rs.getString("game_status"));
				o_game.setGame_website(rs.getString("game_website"));
				o_game.setGame_label(rs.getString("game_label"));
				raternumgames.add(o_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return raternumgames;
	}

	@Override
	public ArrayList<OnlineGame> getGameByScore() {
		ArrayList<OnlineGame> scoregames=new ArrayList<OnlineGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from online_game order by game_score";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OnlineGame o_game=new OnlineGame();
				o_game.setGame_id(rs.getString("game_id"));
				o_game.setGame_name(rs.getString("game_name"));
				o_game.setGame_hope_num(rs.getInt("game_hope_num"));
				o_game.setGame_type(rs.getString("game_type"));
				o_game.setGame_score(rs.getFloat("game_score"));
				o_game.setGame_rater_num(rs.getInt("game_rater_num"));
				o_game.setGame_img(rs.getString("game_img"));
				o_game.setGame_frame(rs.getString("game_frame"));
				o_game.setGame_develop(rs.getString("game_develop"));
				o_game.setGame_operator(rs.getString("game_operator"));
				o_game.setGame_status(rs.getString("game_status"));
				o_game.setGame_website(rs.getString("game_website"));
				o_game.setGame_label(rs.getString("game_label"));
				scoregames.add(o_game);
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
		String sql = "delete from online_game where game_id = ?";
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
		String sql="select count(game_id) from online_game";
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
		String sql = "select game_id from online_game where game_name = ?";
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
