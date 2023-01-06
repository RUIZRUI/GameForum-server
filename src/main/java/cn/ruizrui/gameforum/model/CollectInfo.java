package cn.ruizrui.gameforum.model;

public class CollectInfo {
private String game_name;
private String game_type;
private String game_img;
private String game_platform;
private String game_belong;

public CollectInfo(){

}

public CollectInfo(String game_name, String game_type, String game_img, String game_platform, String game_belong) {
	super();
	this.game_name = game_name;
	this.game_type = game_type;
	this.game_img = game_img;
	this.game_platform = game_platform;
	this.game_belong = game_belong;
}
public String getGame_belong() {
	return game_belong;
}
public void setGame_belong(String game_belong) {
	this.game_belong = game_belong;
}
public String getGame_name() {
	return game_name;
}
public void setGame_name(String game_name) {
	this.game_name = game_name;
}
public String getGame_type() {
	return game_type;
}
public void setGame_type(String game_type) {
	this.game_type = game_type;
}
public String getGame_img() {
	return game_img;
}
public void setGame_img(String game_img) {
	this.game_img = game_img;
}
public String getGame_platform() {
	return game_platform;
}
public void setGame_platform(String game_platform) {
	this.game_platform = game_platform;
}
}
