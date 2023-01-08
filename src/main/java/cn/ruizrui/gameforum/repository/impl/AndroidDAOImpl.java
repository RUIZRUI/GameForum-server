package cn.ruizrui.gameforum.repository.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import cn.ruizrui.gameforum.repository.*;
import cn.ruizrui.gameforum.model.AndroidGame;

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
	public AndroidGame getGameById(String gameId) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from android_Game where game_id=?";
		AndroidGame a_game = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gameId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				a_game = new AndroidGame();
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
	public boolean addGame(AndroidGame androidGame) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "insert into android_game(game_id, game_name, game_slogan, game_version, game_platform, game_type, " +
				"game_release_date, game_release, game_language, game_score, game_rater_num, game_img) " +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, androidGame.getGame_id());
			pst.setString(2, androidGame.getGame_name());
			pst.setString(3, androidGame.getGame_slogan());
			pst.setString(4, androidGame.getGame_version());
			pst.setString(5, androidGame.getGame_platform());
			pst.setString(6, androidGame.getGame_type());
			pst.setDate(7, new Date(androidGame.getGame_release_date().getTime()));
			pst.setString(8, androidGame.getGame_release());
			pst.setString(9, androidGame.getGame_language());
			pst.setDouble(10, androidGame.getGame_score());
			pst.setInt(11, androidGame.getGame_rater_num());
			pst.setString(12, androidGame.getGame_img());
			pst.executeUpdate();
			result = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		closeAll(conn, pst, null);
		return result;
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
			/* for(int i=0;i<raternumgames.size();i++) {
				System.out.println(raternumgames.get(i).getGame_rater_num());
			} */
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
	public boolean deleteGame(String gameId) {
		Connection conn = getConnection();
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "delete from android_game where game_id = ?";
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
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String gameId = null;
		String sql = "select game_id from android_game where game_name = ?";
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
