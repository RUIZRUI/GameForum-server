package cn.ruizrui.gameforum.entity;

import java.sql.Timestamp;

public class Comment {
private String game_name;
private String comment_name;
private int comment_id;
private int user_id;
private String game_id;
private int parent_id;
private String content;
private Timestamp timestamp;
private int like;
private int dislike;
public int getComment_id() {
	return comment_id;
}
public void setComment_id(int comment_id) {
	this.comment_id = comment_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getGame_id() {
	return game_id;
}
public void setGame_id(String game_id) {
	this.game_id = game_id;
}
public int getParent_id() {
	return parent_id;
}
public void setParent_id(int parent_id) {
	this.parent_id = parent_id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Timestamp getTimestamp() {
	return timestamp;
}
public void setTimestamp(Timestamp timestamp) {
	this.timestamp = timestamp;
}
public int getLike() {
	return like;
}
public void setLike(int like) {
	this.like = like;
}
public int getDislike() {
	return dislike;
}
public void setDislike(int dislike) {
	this.dislike = dislike;
}
public String getComment_name() {
	return comment_name;
}
public void setComment_name(String comment_name) {
	this.comment_name = comment_name;
}
public String getGame_name() {
	return game_name;
}
public void setGame_name(String game_name) {
	this.game_name = game_name;
}

}
