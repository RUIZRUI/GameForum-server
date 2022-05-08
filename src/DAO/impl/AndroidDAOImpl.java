package DAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.*;
import entity.AndroidGame;

public class AndroidDAOImpl extends baseDAO implements AndroidDAO {

	@Override
	public ArrayList<AndroidGame> getAllGames() {
		// TODO �Զ����ɵķ������
		ArrayList<AndroidGame> allGames=new ArrayList<AndroidGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from android_game";
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
				AndroidGame a_game=new AndroidGame();
				a_game.setGame_id(rs.getString(1));
				a_game.setGame_name(rs.getString(2));
				a_game.setGame_slogan(rs.getString(3));
				a_game.setGame_version(rs.getString(4));
				a_game.setGame_platform(rs.getString(5));
				a_game.setGame_type(rs.getString(6));
				a_game.setGame_release_date(rs.getDate(7));
				a_game.setGame_release(rs.getString(8));
				a_game.setGame_language(rs.getString(9));
				a_game.setGame_score(rs.getFloat(10));
				a_game.setGame_rater_num(rs.getInt(11));
				a_game.setGame_img(rs.getString(12));
				allGames.add(a_game);
			
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return allGames;
	
	}

	@Override
	public AndroidGame getGameByName(String game_name) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from android_Game where game_name=?";
		AndroidGame a_game=new AndroidGame();
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,game_name);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				a_game.setGame_id(rs.getString(1));
				a_game.setGame_name(rs.getString(2));
				a_game.setGame_slogan(rs.getString(3));
				a_game.setGame_version(rs.getString(4));
				a_game.setGame_platform(rs.getString(5));
				a_game.setGame_type(rs.getString(6));
				a_game.setGame_release_date(rs.getDate(7));
				a_game.setGame_release(rs.getString(8));
				a_game.setGame_language(rs.getString(9));
				a_game.setGame_score(rs.getFloat(10));
				a_game.setGame_rater_num(rs.getInt(11));
				a_game.setGame_img(rs.getString(12));
			}else {
				return null;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return a_game; 
	}
	
    public ArrayList<AndroidGame> getGameByType(String game_type) {
    	ArrayList<AndroidGame> typeGames=new ArrayList<AndroidGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from android_game where game_type=?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,game_type);
		rs=pstmt.executeQuery();
		while(rs.next()) {
				AndroidGame a_game=new AndroidGame();
				a_game.setGame_id(rs.getString(1));
				a_game.setGame_name(rs.getString(2));
				a_game.setGame_slogan(rs.getString(3));
				a_game.setGame_version(rs.getString(4));
				a_game.setGame_platform(rs.getString(5));
				a_game.setGame_type(rs.getString(6));
				a_game.setGame_release_date(rs.getDate(7));
				a_game.setGame_release(rs.getString(8));
				a_game.setGame_language(rs.getString(9));
				a_game.setGame_score(rs.getFloat(10));
				a_game.setGame_rater_num(rs.getInt(11));
				a_game.setGame_img(rs.getString(12));
				typeGames.add(a_game);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
		closeAll(con,pstmt,rs);
		return typeGames;
    }

	@Override
	public void addGame(AndroidGame game) {
		// TODO �Զ����ɵķ������
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into android_game(game_id,game_name,game_slogan,game_version,game_platform,game_type,"
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
		}catch(SQLException e) {
			e.printStackTrace();
		}closeAll(con,pstmt,rs);
	}

	@Override
	public ArrayList<AndroidGame> getGameByTime() {
		// TODO �Զ����ɵķ������
		ArrayList<AndroidGame> timegames=new ArrayList<AndroidGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from android_game order by game_release_date";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AndroidGame a_game=new AndroidGame();
				a_game.setGame_id(rs.getString(1));
				a_game.setGame_name(rs.getString(2));
				a_game.setGame_slogan(rs.getString(3));
				a_game.setGame_version(rs.getString(4));
				a_game.setGame_platform(rs.getString(5));
				a_game.setGame_type(rs.getString(6));
				a_game.setGame_release_date(rs.getDate(7));
				a_game.setGame_release(rs.getString(8));
				a_game.setGame_language(rs.getString(9));
				a_game.setGame_score(rs.getFloat(10));
				a_game.setGame_rater_num(rs.getInt(11));
				a_game.setGame_img(rs.getString(12));
				timegames.add(a_game);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return timegames;
	}

	@Override
	public ArrayList<AndroidGame> getGameByRaterNum() {
		// TODO �Զ����ɵķ������
		ArrayList<AndroidGame> raternumgames=new ArrayList<AndroidGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from android_game order by game_rater_num";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AndroidGame a_game=new AndroidGame();
				a_game.setGame_id(rs.getString(1));
				a_game.setGame_name(rs.getString(2));
				a_game.setGame_slogan(rs.getString(3));
				a_game.setGame_version(rs.getString(4));
				a_game.setGame_platform(rs.getString(5));
				a_game.setGame_type(rs.getString(6));
				a_game.setGame_release_date(rs.getDate(7));
				a_game.setGame_release(rs.getString(8));
				a_game.setGame_language(rs.getString(9));
				a_game.setGame_score(rs.getFloat(10));
				a_game.setGame_rater_num(rs.getInt(11));
				a_game.setGame_img(rs.getString(12));
				raternumgames.add(a_game);
			}
			for(int i=0;i<raternumgames.size();i++) {
				System.out.println(raternumgames.get(i).getGame_rater_num());
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		closeAll(con,pstmt,rs);
		return raternumgames;
	}

	@Override
	public ArrayList<AndroidGame> getGameByScore() {
		// TODO �Զ����ɵķ������
		ArrayList<AndroidGame> scoregames=new ArrayList<AndroidGame>();
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from android_game order by game_score";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AndroidGame a_game=new AndroidGame();
				a_game.setGame_id(rs.getString(1));
				a_game.setGame_name(rs.getString(2));
				a_game.setGame_slogan(rs.getString(3));
				a_game.setGame_version(rs.getString(4));
				a_game.setGame_platform(rs.getString(5));
				a_game.setGame_type(rs.getString(6));
				a_game.setGame_release_date(rs.getDate(7));
				a_game.setGame_release(rs.getString(8));
				a_game.setGame_language(rs.getString(9));
				a_game.setGame_score(rs.getFloat(10));
				a_game.setGame_rater_num(rs.getInt(11));
				a_game.setGame_img(rs.getString(12));
				scoregames.add(a_game);
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
		String sql="delete from android_game where game_name=?";
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
		String sql="select count(game_id) from android_game";
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
		String sql="select game_id from android_game where game_name=?";
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
