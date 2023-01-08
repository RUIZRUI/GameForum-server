package cn.ruizrui.gameforum.model;

public class GameIntroduction {

    private String game_id;
    private String game_name;
    private String content;

    public GameIntroduction(){

    }

    public GameIntroduction(String game_id, String game_name){
        this.game_id = game_id;
        this.game_name = game_name;
        this.content = "该游戏暂无游戏简介";
    }
    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "GameIntroduction{" +
                "game_id='" + game_id + '\'' +
                ", game_name='" + game_name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
