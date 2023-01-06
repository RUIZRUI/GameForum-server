package cn.ruizrui.gameforum.model;

import java.util.List;

public class Comment {

	private int comment_id;
	private int user_id_from;
	// 空值判断
	private Integer parent_id;
	private String content;
	// 13位时间戳
	private long comment_time;
	private String img;
	private String user_name;
	private String priority;
	private List<Comment> child;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getUser_id_from() {
		return user_id_from;
	}

	public void setUser_id_from(int user_id_from) {
		this.user_id_from = user_id_from;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getComment_time() {
		return comment_time;
	}

	public void setComment_time(long comment_time) {
		this.comment_time = comment_time;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public List<Comment> getChild() {
		return child;
	}

	public void setChild(List<Comment> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"comment_id=" + comment_id +
				", user_id_from=" + user_id_from +
				", parent_id=" + parent_id +
				", content='" + content + '\'' +
				", comment_time=" + comment_time +
				", img='" + img + '\'' +
				", user_name='" + user_name + '\'' +
				", priority='" + priority + '\'' +
				", child=" + child +
				'}';
	}
}
