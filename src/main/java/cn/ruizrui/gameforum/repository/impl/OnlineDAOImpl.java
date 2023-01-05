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
		// TODO �Զ����ɵķ������
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
			o_game.setGame_status(rs.getString("games_tatus"));
			allGames.add(o_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return allGames;
	}

	@Override
	public OnlineGame getGameByName(String game_name) {
		// TODO �Զ����ɵķ������
		OnlineGame o_game=new OnlineGame();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from online_game where game_name=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_name);
		rs=pstmt.executeQuery();
		if(rs.next()) {
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
		// TODO �Զ����ɵķ������
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
			o_game.setGame_status(rs.getString("games_tatus"));
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
		// TODO �Զ����ɵķ������
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
			o_game.setGame_status(rs.getString("games_tatus"));
			developGames.add(o_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return developGames;
	}

	@Override
	public void addGame(OnlineGame game) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into ios_game(game_id,game_name,game_hope_num,game_type,game_frame,game_develop,"
				+ "game_operator,game_website,game_status,game_label,game_score,game_rater_num,game_img) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,game.getGame_id());
			pstmt.setString(2, game.getGame_name());
			pstmt.setInt(3,game.getGame_rater_num());
			pstmt.setString(4,game.getGame_type());
			pstmt.setString(5, game.getGame_frame());
			pstmt.setString(6,game.getGame_develop());
			pstmt.setString(7, game.getGame_operator());
			pstmt.setString(8,game.getGame_website());
			pstmt.setString(9, game.getGame_status());
			pstmt.setString(10, game.getGame_label());
			pstmt.setDouble(11, game.getGame_score());
			pstmt.setInt(12, game.getGame_rater_num());
			pstmt.setString(13, game.getGame_img());
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
	}

	@Override
	public ArrayList<OnlineGame> getGameByHopeNum() {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
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
	public boolean deleteGame(String gameName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from online_game where game_name=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gameName);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return true;
	}

	@Override
	public int getGameNumber() {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select game_id from online_game where game_name=?";
		String game_id=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gameName);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				game_id=rs.getString(1);
			}else {
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return game_id;
	}


}
