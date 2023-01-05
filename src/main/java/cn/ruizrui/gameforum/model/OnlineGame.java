package cn.ruizrui.gameforum.model;

public class OnlineGame extends HostGame{
	private int game_hope_num;
	private String game_frame;
	private String game_develop;
	private String game_operator;
	private String game_status;
	private String game_website;
	private String game_label;
	public int getGame_hope_num() {
		return game_hope_num;
	}
	public void setGame_hope_num(int game_hope_num) {
		this.game_hope_num = game_hope_num;
	}
	public String getGame_frame() {
		return game_frame;
	}
	public void setGame_frame(String game_frame) {
		this.game_frame = game_frame;
	}
	public String getGame_develop() {
		return game_develop;
	}
	public void setGame_develop(String game_develop) {
		this.game_develop = game_develop;
	}
	public String getGame_operator() {
		return game_operator;
	}
	public void setGame_operator(String game_operator) {
		this.game_operator = game_operator;
	}
	public String getGame_status() {
		return game_status;
	}
	public void setGame_status(String game_status) {
		this.game_status = game_status;
	}

	@Override
	public String getGame_website() {
		return game_website;
	}

	@Override
	public void setGame_website(String game_website) {
		this.game_website = game_website;
	}

	@Override
	public String getGame_label() {
		return game_label;
	}

	@Override
	public void setGame_label(String game_label) {
		this.game_label = game_label;
	}

	@Override
	public String toString() {
		return "OnlineGame [game_hope_num=" + game_hope_num + ", game_frame=" + game_frame + ", game_develop="
				+ game_develop + ", game_operator=" + game_operator + ", game_status=" + game_status + ", game_id="
				+ game_id + ", game_name=" + game_name + ", game_type=" + game_type + ", game_website=" + game_website
				+ ", game_label=" + game_label + ", game_score=" + game_score + ", game_rater_num=" + game_rater_num
				+ ", game_img=" + game_img + ", game_website=" + game_website + ", game_label=" + game_label + "]";
	}
	
}
