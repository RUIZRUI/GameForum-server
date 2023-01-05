package cn.ruizrui.gameforum.model;

public class RelationUser {

    private int user_id;
    private String user_name;
    private String user_avatar;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    @Override
    public String toString() {
        return "RelationUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                '}';
    }
}
