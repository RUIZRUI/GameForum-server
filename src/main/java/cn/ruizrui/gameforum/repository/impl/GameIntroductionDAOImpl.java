package cn.ruizrui.gameforum.repository.impl;

import cn.ruizrui.gameforum.model.GameIntroduction;
import cn.ruizrui.gameforum.repository.baseDAO;
import cn.ruizrui.gameforum.repository.GameIntroductionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameIntroductionDAOImpl extends baseDAO implements GameIntroductionDAO{

    @Override
    public String getGameIntroduction(String gameId) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select content from game_introduction where game_id = ?";
        String content = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, gameId);
            rs = pst.executeQuery();
            if (rs.next()) {
                content = rs.getString("content");
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        closeAll(conn, pst, rs);
        return content;
    }

    @Override
    public boolean addGameIntroduction(GameIntroduction gameIntroduction) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        boolean result = false;
        String sql = "insert into game_introduction(game_id, game_name, content) values (?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, gameIntroduction.getGame_id());
            pst.setString(2, gameIntroduction.getGame_name());
            pst.setString(3, gameIntroduction.getContent());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll(conn, pst, null);
        return result;
    }

    @Override
    public boolean deleteGameIntroductionById(String gameId) {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        boolean result = false;
        String sql = "delete from game_introduction where game_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, gameId);
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeAll(conn, pst,  null);
        return result;
    }
}
