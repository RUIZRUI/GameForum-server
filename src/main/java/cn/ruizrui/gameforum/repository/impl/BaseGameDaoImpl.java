package cn.ruizrui.gameforum.repository.impl;

import cn.ruizrui.gameforum.repository.BaseGameDao;
import cn.ruizrui.gameforum.repository.baseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseGameDaoImpl extends baseDAO implements BaseGameDao {

    @Override
    public String getGameBelongById(String gameId) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String gameBelong = null;
        String sql = "select game_belong from base_game where game_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, gameId);
            rs = pst.executeQuery();
            if (rs.next()) {
                gameBelong = rs.getString("game_belong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll(conn, pst, rs);
        return gameBelong;
    }

    @Override
    public boolean deleteGameById(String gameId) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        boolean result = false;
        String sql = "delete from base_game where game_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, gameId);
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll(conn, pst, null);
        return result;
    }
}
