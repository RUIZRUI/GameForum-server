package cn.ruizrui.gameforum.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.ruizrui.gameforum.repository.IosDAO;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.model.IosGame;

public class IosDAOImpl extends baseDAO implements IosDAO{

	@Override
	public ArrayList<IosGame> getAllGames() {
		// TODO �Զ����ɵķ������
		ArrayList<IosGame> allGames=new ArrayList<IosGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game";

	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			IosGame i_game=new IosGame();
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
	public IosGame getGameByName(String game_name) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		IosGame i_game=new IosGame();
		String sql="select * from ios_game where game_name=?";
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,game_name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
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
	public ArrayList<IosGame> getGameByType(String game_type) {
		// TODO �Զ����ɵķ������
		ArrayList<IosGame> typeGames=new ArrayList<IosGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game where game_type=?";

	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_type);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			IosGame i_game=new IosGame();
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
	public void addGame(IosGame game) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into ios_game(game_id,game_name,game_slogan,game_version,game_platform,game_type,"
				+ "game_release_date,game_release,game_language,game_score,game_rater_num,game_img) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,game.getGame_id());
			pstmt.setString(2, game.getGame_name());
			pstmt.setString(3,game.getGame_slogan());
			pstmt.setString(4,game.getGame_version());
			pstmt.setString(5, game.getGame_platform());
			pstmt.setString(6,game.getGame_type());
			pstmt.setDate(7, game.getGame_release_date());
			pstmt.setString(8,game.getGame_release());
			pstmt.setString(9, game.getGame_language());
			pstmt.setDouble(10, game.getGame_score());
			pstmt.setInt(11, game.getGame_rater_num());
			pstmt.setString(12, game.getGame_img());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
	}

	@Override
	public ArrayList<IosGame> getGameByTime() {
		// TODO �Զ����ɵķ������
		ArrayList<IosGame> timegames=new ArrayList<IosGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game order by game_release_date";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				IosGame i_game=new IosGame();
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
	public ArrayList<IosGame> getGameByRaterNum() {
		// TODO �Զ����ɵķ������
		ArrayList<IosGame> raternumgames=new ArrayList<IosGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game order by game_rater_num";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				IosGame i_game=new IosGame();
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
	public ArrayList<IosGame> getGameByScore() {
		// TODO �Զ����ɵķ������
		ArrayList<IosGame> scoregames=new ArrayList<IosGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from ios_game order by game_score";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				IosGame i_game=new IosGame();
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
	public boolean deleteGame(String gameName) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from ios_game where game_name=?";
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
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select game_id from ios_game where game_name=?";
		String game_id=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gameName);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				game_id=rs.getString(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
		return game_id;
	}

}
