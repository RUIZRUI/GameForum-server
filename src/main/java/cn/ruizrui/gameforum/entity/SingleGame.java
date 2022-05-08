package cn.ruizrui.gameforum.entity;

import java.sql.Date;

public class SingleGame extends HostGame{
	private String game_platform;
	private Date game_release_date;
	private String game_release;
	private Date game_arrange_date;
	private String game_language;
	
	public String getGame_platform() {
		return game_platform;
	}
	public void setGame_platform(String game_platform) {
		this.game_platform = game_platform;
	}
	public Date getGame_release_date() {
		return game_release_date;
	}
	public void setGame_release_date(Date game_release_date) {
		this.game_release_date = game_release_date;
	}
	public String getGame_release() {
		return game_release;
	}
	public void setGame_release(String game_release) {
		this.game_release = game_release;
	}
	public Date getGame_arrange_date() {
		return game_arrange_date;
	}
	public void setGame_arrange_date(Date game_arrange_date) {
		this.game_arrange_date = game_arrange_date;
	}
	public String getGame_language() {
		return game_language;
	}
	@Override
	public String toString() {
		return "SingleGame [game_platform=" + game_platform + ", game_release_date=" + game_release_date
				+ ", game_release=" + game_release + ", game_arrange_date=" + game_arrange_date + ", game_language="
				+ game_language + ", game_id=" + game_id + ", game_name=" + game_name + ", game_type=" + game_type
				+ ", game_website=" + game_website + ", game_label=" + game_label + ", game_score=" + game_score
				+ ", game_rater_num=" + game_rater_num + ", game_img=" + game_img + "]";
	}
	public void setGame_language(String game_language) {
		this.game_language = game_language;
	}
	
}
