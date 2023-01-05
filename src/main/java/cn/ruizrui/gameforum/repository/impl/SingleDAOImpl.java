package cn.ruizrui.gameforum.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public SingleGame getGameByName(String game_name) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from single_game where game_name=?";
		SingleGame s_game=new SingleGame();
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_name);
		rs=pstmt.executeQuery();
		if(rs.next()) {
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
	public void addGame(SingleGame game) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into ios_game(game_id,game_name,game_type,game_release,game_release_date,game_arrange_date,"
				+ "game_platform,game_website,game_label,game_language,game_score,game_rater_num,game_img) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,game.getGame_id());
			pstmt.setString(2, game.getGame_name());
			pstmt.setString(3,game.getGame_type());
			pstmt.setString(4,game.getGame_release());
			pstmt.setDate(5, game.getGame_release_date());
			pstmt.setDate(6,game.getGame_arrange_date());
			pstmt.setDate(7, game.getGame_release_date());
			pstmt.setString(8,game.getGame_platform());
			pstmt.setString(9, game.getGame_website());
			pstmt.setString(10, game.getGame_label());
			pstmt.setString(11, game.getGame_language());
			pstmt.setInt(12, game.getGame_rater_num());
			pstmt.setString(13, game.getGame_img());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
	}

	@Override
	public ArrayList<SingleGame> getSingleGameByTime() {
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
	public ArrayList<SingleGame> getSingleGameByRaterNum() {
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
	public ArrayList<SingleGame> getSingleGameByScore() {
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
	public boolean deleteGame(String gameName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from single_game where game_name=?";
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
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select game_id from single_game where game_name=?";
		String game_id=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gameName);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("无");
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
