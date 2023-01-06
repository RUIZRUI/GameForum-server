package cn.ruizrui.gameforum.model;

import java.util.Date;

public class MyComment {

    private int comment_id;
    private String other_name;
    private String game_name;
    private String game_belong;
    private Date comment_time;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getGame_belong() {
        return game_belong;
    }

    public void setGame_belong(String game_belong) {
        this.game_belong = game_belong;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    @Override
    public String toString() {
        return "MyComment{" +
                "comment_id=" + comment_id +
                ", other_name='" + other_name + '\'' +
                ", game_name='" + game_name + '\'' +
                ", game_belong='" + game_belong + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }
}
